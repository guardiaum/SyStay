/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.dao.interfaces.AdminDao;
import com.dbproject.systay.dao.interfaces.LoginDao;
import com.dbproject.systay.dao.rowmappers.AdminRowMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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

    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }
    
    @Override
    public Administrador getAdministrador(String numeroDocumento) {
        String sql = "SELECT A.login.username as username, "+
                    "A.login.senha as senha, "+
                    "A.nome as nome, "+
                    "A.numerodocumento as numerodocumento, "+
                    "A.data_nascimento as data_nascimento, "+
                    "A.dataadimissao as dataadimissao, "+
                    "A.salario as salario "+
                    "FROM tb_administrador A WHERE A.numerodocumento='"+numeroDocumento+"'";

        List<Administrador> admins = template.query(sql, new AdminRowMapper());
        return admins.size()>0?admins.get(0):null;
    }

    @Override
    public Administrador cadastrar(Administrador admin) {
        boolean result = loginDao.criarUsuario(admin.getLogin());
        if(result){
            String sql = "INSERT INTO tb_administrador(numeroDocumento, nome, data_nascimento, dataAdimissao, salario, login) " +
                            "VALUES ('"+admin.getNumeroDocumento()+"', '"+admin.getNome()+"', " +
                            "to_date('1980-12-01', 'YYYY-MM-DD'), to_date('2001-12-01', 'YYYY-MM-DD'), "+admin.getSalario()+", "+
                            "(SELECT REF (L) FROM tb_login L WHERE username = '"+admin.getLogin().getUsername()+"'))";
            template.update(sql);
        }
        return getAdministrador(admin.getNumeroDocumento());
    }

    @Override
    public List<Administrador> getAdministradores() {
        String sql = "SELECT A.login.username as username, "+
                    "A.login.senha as senha, "+
                    "A.nome as nome, "+
                    "A.numerodocumento as numerodocumento, "+
                    "A.data_nascimento as data_nascimento, "+
                    "A.dataadimissao as dataadimissao, "+
                    "A.salario as salario "+
                    "FROM tb_administrador A";

        List<Administrador> admins = template.query(sql, new AdminRowMapper());
        return admins;
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
