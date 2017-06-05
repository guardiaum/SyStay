/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbproject.systay.dao.impl;

import com.dbproject.systay.beans.QuartoFamilia;
import com.dbproject.systay.dao.interfaces.QuartoFamiliaDao;
import com.dbproject.systay.dao.rowmappers.AdminRowMapper;
import com.dbproject.systay.dao.rowmappers.QuartoFamiliaRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("quartoFDao")
public class QuartoFamiliaDaoImpl implements QuartoFamiliaDao {
    
    private JdbcTemplate template;
    
    final static String QUARTO_FAMILIA_TABLE = "tb_quarto_familia";
    
    @Inject private AdminRowMapper quartoFRowMapper;

    public void setTemplate(JdbcTemplate template) {  
        this.template = template;  
    }

    @Override
    public QuartoFamilia getQuartoFamilia(int id) {
        String sql="select * from "+QUARTO_FAMILIA_TABLE+ " where id="+id;
         List<QuartoFamilia> quartos = template.query(sql, new QuartoFamiliaRowMapper());
         System.out.println("ID: "+ quartos.get(0).getId());
        return quartos.get(0);
    }

    @Override
    public int cadastrar(QuartoFamilia quartofamilia) {
        String sql = "INSERT INTO "+QUARTO_FAMILIA_TABLE+" (id, numero, observacao,ramal, valor_diaria, qtd_camas_adicionais, tem_varanda, area) "
            + "VALUES (sq_quarto_comum.nextval,"+quartofamilia.getNumero()+", '"
            +quartofamilia.getObservacao()+"', " +quartofamilia.getRamal()+", " +quartofamilia.getValor_diaria()+", "+quartofamilia.getQtd_camas_adicionais()+", "
                + "'"+quartofamilia.getTem_varanda()+"', "+quartofamilia.getArea()+")"; ;    
            System.out.println(sql);
            return template.update(sql);
    }

    @Override
    public List<QuartoFamilia> getQuartosFamilia() {
        return template.query("select * from " + QUARTO_FAMILIA_TABLE, new RowMapper<QuartoFamilia>(){
            public QuartoFamilia mapRow(ResultSet rs, int row) throws SQLException{
                QuartoFamilia qf = new QuartoFamilia();
                qf.setId(rs.getInt("id"));
                qf.setNumero(rs.getInt("numero"));
                qf.setRamal(rs.getString("ramal"));
                qf.setValor_diaria(rs.getFloat("valor_diaria"));
                qf.setQtd_camas_adicionais(rs.getInt("qtd_camas_adicionais"));
                qf.setObservacao(rs.getString("observacao"));
                qf.setTem_varanda(rs.getString("tem_varanda").charAt(0));
                qf.setArea(rs.getDouble("area"));
//                Administrador adm = new Administrador();
//                //adm.setNumeroDocumento(rs.getString("responsavel_doc"));
//                q.setResponsavelGerencia(adm);
                return qf;    
            }
        });
    }

    @Override
    public boolean atualizarQuartoFamilia(QuartoFamilia qfamilia) {
        String sql = "update " + QUARTO_FAMILIA_TABLE + " set numero="+qfamilia.getNumero()+", area="+qfamilia.getArea()+", ramal="+qfamilia.getRamal()+", valor_diaria="+qfamilia.getValor_diaria()+", observacao='"+qfamilia.getObservacao()+"', qtd_camas_adicionais="+qfamilia.getQtd_camas_adicionais()+", tem_varanda='"+qfamilia.getTem_varanda()+"' where id= "+qfamilia.getId() ;
        return template.update(sql)!= 0;
    }

    @Override
    public int deletarQuartoFamilia(int id) {
        String sql = "delete from "+ QUARTO_FAMILIA_TABLE+ " where id="+id+"";
        return template.update(sql);
    }
    
}
