/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Telefone;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.dao.interfaces.LoginDao;
import com.dbproject.systay.dao.rowmappers.AdminRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johny
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template;
    @Autowired
    public LoginDao loginDao;
    
    private PessoaDaoUtil pessoa = new PessoaDaoUtil();

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Administrador cadastrar(Administrador admin) {
        boolean result = loginDao.criarUsuario(admin.getLogin());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data_nascimento = dateFormat.format(admin.getData_nascimento());
        String dataAdimissao = dateFormat.format(admin.getDataAdmissao());
        
        if (result) {
            String sql = "INSERT INTO tb_administrador(numeroDocumento, nome, data_nascimento, "
                    + "dataAdimissao, salario, cargo, lista_fones, endereco, login) "
                    + "VALUES ('" + admin.getNumeroDocumento() + "', '" + admin.getNome() + "', "
                    + "'" + data_nascimento + "', '" + dataAdimissao + "', " + admin.getSalario() + ", '" + admin.getCargo() + "',"
                    + "tp_fones(tp_fone('" + admin.getTelefone().get(0).getCod_area() + "', '" + admin.getTelefone().get(0).getNumero() + "'),"
                    + "tp_fone('" + admin.getTelefone().get(1).getCod_area() + "','" + admin.getTelefone().get(1).getNumero() + "'),"
                    + "tp_fone('" + admin.getTelefone().get(2).getCod_area() + "','" + admin.getTelefone().get(2).getNumero() + "'),"
                    + "tp_fone('" + admin.getTelefone().get(3).getCod_area() + "','" + admin.getTelefone().get(3).getNumero() + "')),"
                    + "tp_endereco('" + admin.getEndereco().getRua() + "'," + admin.getEndereco().getNumero() + ","
                    + "'" + admin.getEndereco().getComplemento() + "','" + admin.getEndereco().getBairro() + "',"
                    + "'" + admin.getEndereco().getCidade() + "','" + admin.getEndereco().getEstado() + "'," + admin.getEndereco().getCep() + "), "
                    + "(SELECT REF (L) FROM tb_login L WHERE username = '" + admin.getLogin().getUsername() + "'))";
            
            template.update(sql);
        }
        return getAdministrador(admin.getNumeroDocumento());
    }

    @Override
    public List<Administrador> getAdministradores() {
        return template.query("select * from tb_administrador", new RowMapper<Administrador>() {
            public Administrador mapRow(ResultSet rs, int row) throws SQLException {
                Administrador a = new Administrador();
                a.setNumeroDocumento(rs.getString(1));
                a.setNome(rs.getString(2));
                return a;
            }
        });
    }

    @Override
    public Administrador getAdministrador(String numeroDocumento) {
        String sql = "SELECT A.login.username as username, "
                + "A.login.senha as senha, A.nome as nome, A.numerodocumento as numerodocumento, "
                + "A.data_nascimento as data_nascimento, A.dataadimissao as dataadimissao, "
                + "A.salario as salario, A.cargo as cargo, A.endereco.rua as rua, A.endereco.numero as numero, "
                + "A.endereco.complemento as complemento, A.endereco.bairro as bairro, "
                + "A.endereco.cidade as cidade, A.endereco.estado as estado, A.endereco.cep as cep "
                + "FROM tb_administrador A WHERE A.numerodocumento='" + numeroDocumento + "'";

        List<Administrador> admins = template.query(sql, new AdminRowMapper());
        List<Administrador> aux = new ArrayList();
        for (Administrador adm : admins) {
            List<Telefone> telefones = pessoa.getTelefones(adm, "tb_administrador", template);
            adm.setTelefone(telefones);
            aux.add(adm);
        }
        return admins.size() > 0 ? aux.get(0) : admins.get(0);
    }

    @Override
    public Administrador getAdministradorById(String numeroDocumento) {
        String query = "SELECT A.login.username as username, "
                + "A.login.senha as senha, A.nome as nome, A.numerodocumento as numerodocumento, "
                + "A.data_nascimento as data_nascimento, A.dataadimissao as dataadimissao, "
                + "A.salario as salario, A.cargo as cargo, A.endereco.rua as rua, A.endereco.numero as numero, "
                + "A.endereco.complemento as complemento, A.endereco.bairro as bairro, "
                + "A.endereco.cidade as cidade, A.endereco.estado as estado, A.endereco.cep as cep "
                + "FROM tb_administrador A WHERE A.numerodocumento='" + numeroDocumento + "'";

        List<Administrador> admins = template.query(query, new AdminRowMapper());
        List<Administrador> aux = new ArrayList();
        for (Administrador a : admins) {
            List<Telefone> telefones = pessoa.getTelefones(a, "tb_administrador", template);
            a.setTelefone(telefones);
            aux.add(a);
        }
        return admins.size() > 0 ? aux.get(0) : admins.get(0);
    }

    @Override
    public boolean atualizarAdministrador(Administrador a) {
        String query = "update tb_hospede H set H.numeroDocumento='" + a.getNumeroDocumento() + "', "
                + "H.nome='" + a.getNome() + "', H.endereco.rua='" + a.getEndereco().getRua() + "',"
                + "H.endereco.numero=" + a.getEndereco().getNumero() + ", H.endereco.complemento='" + a.getEndereco().getComplemento() + "',"
                + "H.endereco.bairro='" + a.getEndereco().getBairro() + "',H.endereco.cidade='" + a.getEndereco().getCidade() + "',"
                + "H.endereco.estado='" + a.getEndereco().getEstado() + "', H.endereco.cep=" + a.getEndereco().getCep() + ","
                + "H.observacao='" + a.getCargo() + "'where numeroDocumento='" + a.getNumeroDocumento() + "'";
        return template.update(query) != 0;
    }

    @Override
    public boolean deletarAdministrador(String numeroDocumento) {
        String query = "delete from tb_administrador where numeroDocumento='" + numeroDocumento + "'";
        return template.update(query) != 0;
    }

}
