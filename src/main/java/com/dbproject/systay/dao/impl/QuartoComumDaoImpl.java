/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.Administrador;
import com.dbproject.systay.beans.Login;
import com.dbproject.systay.beans.QuartoComum;
import com.dbproject.systay.dao.interfaces.QuartoComumDao;
import com.dbproject.systay.dao.rowmappers.AdminRowMapper;
import com.dbproject.systay.dao.rowmappers.QuartoComumRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("quartoCDao")
public class QuartoComumDaoImpl implements QuartoComumDao {
    
    private JdbcTemplate template;
    
    final static String QUARTO_COMUM_TABLE = "tb_quarto_comum";
    
    @Inject private AdminRowMapper quartoCRowMapper;

    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }

    @Override
    public QuartoComum getQuartoComum(int id) {
        String sql="select * from "+QUARTO_COMUM_TABLE+ " where id="+id;
         List<QuartoComum> quartos = template.query(sql, new QuartoComumRowMapper());
         System.out.println("ID: "+ quartos.get(0).getId());
        return quartos.get(0);
    }

    @Override
    public int cadastrar(QuartoComum quartocomum) {
        
            String sql = "INSERT INTO "+QUARTO_COMUM_TABLE+" (id, numero, observacao,ramal, valor_diaria, qtd_camas, tipo_camas, tem_varanda, area) "
            + "VALUES (sq_quarto_comum.nextval,"+quartocomum.getNumero()+", '"
            +quartocomum.getObservacao()+"', " +quartocomum.getRamal()+", " +quartocomum.getValor_diaria()+", "+quartocomum.getQtd_camas()+", "
                    + "'"+quartocomum.getTipo_camas()+"', '"+quartocomum.getTem_varanda()+"', "+quartocomum.getArea()+")"; ;    
            System.out.println(sql);
            

            return template.update(sql);
        }
        

    @Override
    public List<QuartoComum> getQuartoComuns() {
        //numero, ramal, valor_diaria, qtd_camas, tipo_camas
        return template.query("select * from " + QUARTO_COMUM_TABLE, new RowMapper<QuartoComum>(){
            public QuartoComum mapRow(ResultSet rs, int row) throws SQLException{
                QuartoComum q = new QuartoComum();
                q.setId(rs.getInt("id"));
                q.setNumero(rs.getInt("numero"));
                q.setRamal(rs.getString("ramal"));
                q.setValor_diaria(rs.getFloat("valor_diaria"));
                q.setQtd_camas(rs.getInt("qtd_camas"));
                q.setTipo_camas(rs.getString("tipo_camas"));
                q.setObservacao(rs.getString("observacao"));
                q.setTem_varanda(rs.getString("tem_varanda").charAt(0));
                q.setArea(rs.getDouble("area"));
//                Administrador adm = new Administrador();
//                //adm.setNumeroDocumento(rs.getString("responsavel_doc"));
//                q.setResponsavelGerencia(adm);
                return q;    
            }
        });
    }

    @Override
    public boolean atualizarQuartoComum(QuartoComum q) {
       String sql = "update " + QUARTO_COMUM_TABLE + " set numero="+q.getNumero()+", area="+q.getArea()+", ramal="+q.getRamal()+", valor_diaria="+q.getValor_diaria()+", observacao='"+q.getObservacao()+"', qtd_camas="+q.getQtd_camas()+", tem_varanda='"+q.getTem_varanda()+"', tipo_camas='"+q.getTipo_camas()+"' where id= "+q.getId() ;
       return template.update(sql)!= 0;
    }

   @Override
    public int deletarQuartoComum(int id) {
        String sql = "delete from "+ QUARTO_COMUM_TABLE+ " where id="+id+"";
        return template.update(sql);
    }
    
}