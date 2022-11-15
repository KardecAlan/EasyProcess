package com.equilibrium.dao;

import com.equilibrium.model.TipoProcesso;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TipoProcessoDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(TipoProcesso p){
        String sql="insert into tipo_processo(nome) values('"+p.getNome()+"')";
        return template.update(sql);
    }
    public int update(TipoProcesso p){
        String sql="update tipo_processo set nome='"+p.getNome()+"' where id="+p.getId()+"";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from tipo_processo where id="+id+"";
        return template.update(sql);
    }
    public TipoProcesso getTipoProcessoById(int id){
        String sql="select * from tipo_processo where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<TipoProcesso>(TipoProcesso.class));
    }
    public List<TipoProcesso> getTipoProcesso(){
        return template.query("select * from tipo_processo",new RowMapper<TipoProcesso>(){
            public TipoProcesso mapRow(ResultSet rs, int row) throws SQLException {
                TipoProcesso tp=new TipoProcesso();
                tp.setId(rs.getInt(1));
                tp.setNome(rs.getString(2));
                return tp;
            }
        });
    }

}