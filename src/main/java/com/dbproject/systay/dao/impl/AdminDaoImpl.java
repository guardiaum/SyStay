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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johny
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
    
    private JdbcTemplate template;
    @Autowired
    public LoginDao loginDao;
    private PessoaDaoUtil pessoa = new PessoaDaoUtil();
    
    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
    
    @Override
    public Administrador getAdministrador(String numeroDocumento) {
        String sql = "SELECT A.login.username as username, "+
                "A.login.senha as senha, A.nome as nome, A.numerodocumento as numerodocumento, "+
                "A.data_nascimento as data_nascimento, A.dataadimissao as dataadimissao, "+
                "A.salario as salario, A.cargo as cargo, A.endereco.rua as rua, A.endereco.numero as numero, "+
                "A.endereco.complemento as complemento, A.endereco.bairro as bairro, "+
                "A.endereco.cidade as cidade, A.endereco.estado as estado, A.endereco.cep as cep "+
                "FROM tb_administrador A WHERE A.numerodocumento='"+numeroDocumento+"'";

        List<Administrador> admins = template.query(sql, new AdminRowMapper());
        List<Administrador> aux = new ArrayList();
        for(Administrador adm : admins){
            List<Telefone> telefones = pessoa.getTelefones(adm, template);
            adm.setTelefone(telefones);
            aux.add(adm);
        }
        return admins.size()>0 ? aux.get(0) : admins.get(0);
    }

    @Override
    public Administrador cadastrar(Administrador admin) {
        boolean result = loginDao.criarUsuario(admin.getLogin());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
        String data_nascimento = dateFormat.format(admin.getData_nascimento());
        String dataAdimissao = dateFormat.format(admin.getDataAdmissao());
        //System.out.println("Endereço: CEP-"+admin.getEndereco().getCep()+" | No-"+admin.getEndereco().getNumero());
        if(result){
            String sql = "INSERT INTO tb_administrador(numeroDocumento, nome, data_nascimento, "
            + "dataAdimissao, salario, cargo, lista_fones, endereco, login) "
            + "VALUES ('"+admin.getNumeroDocumento()+"', '"+admin.getNome()+"', "
            + "'"+data_nascimento+"', '"+dataAdimissao+"', "+admin.getSalario()+", '"+admin.getCargo()+"',"
            + "tp_fones(tp_fone('"+admin.getTelefone().get(0).getCod_area()+"', '"+admin.getTelefone().get(0).getNumero()+"'),"
            + "tp_fone('"+admin.getTelefone().get(1).getCod_area()+"','"+admin.getTelefone().get(1).getNumero()+"'),"
            + "tp_fone('"+admin.getTelefone().get(2).getCod_area()+"','"+admin.getTelefone().get(2).getNumero()+"'),"
            + "tp_fone('"+admin.getTelefone().get(3).getCod_area()+"','"+admin.getTelefone().get(3).getNumero()+"')),"
            + "tp_endereco('"+admin.getEndereco().getRua()+"',"+admin.getEndereco().getNumero()+","
            + "'"+admin.getEndereco().getComplemento()+"','"+admin.getEndereco().getBairro()+"',"
            + "'"+admin.getEndereco().getCidade()+"','"+admin.getEndereco().getEstado()+"',"+admin.getEndereco().getCep()+"), "
            + "(SELECT REF (L) FROM tb_login L WHERE username = '"+admin.getLogin().getUsername()+"'))";
            //System.out.println("SQL >> "+sql);
            template.update(sql);
        }
        return getAdministrador(admin.getNumeroDocumento());
    }

    @Override
    public List<Administrador> getAdministradores() {
        String sql = "SELECT A.login.username as username, "+
                "A.login.senha as senha, A.nome as nome, A.numerodocumento as numerodocumento, "+
                "A.data_nascimento as data_nascimento, A.dataadimissao as dataadimissao, "+
                "A.salario as salario, A.cargo as cargo, A.endereco.rua as rua, A.endereco.numero as numero, "+
                "A.endereco.complemento as complemento, A.endereco.bairro as bairro, "+
                "A.endereco.cidade as cidade, A.endereco.estado as estado, A.endereco.cep as cep "+
                "FROM tb_administrador A";

        List<Administrador> admins = template.query(sql, new AdminRowMapper());
        List<Administrador> aux = new ArrayList();
        for(Administrador adm : admins){
            List<Telefone> telefones = pessoa.getTelefones(adm, template);
            adm.setTelefone(telefones);
            aux.add(adm);
        }
        return !aux.isEmpty() ? aux : admins;
    }

    @Override
    public boolean atualizarAdministrador(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletarAdministrador(String numeroDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
