package com.equilibrium.dao;

import com.equilibrium.model.Processo;
import com.equilibrium.model.TipoProcesso;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProcessoDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(Processo p){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(p.getDataEntrada());

        String sql="insert into processo(numero,tipo_processo_id,objetivo,data_entrada,valor_recurso) values('"+p.getNumero()+"',"+ p.getTipoProcessoId()+",'"+p.getObjetivo()+"','"+date+"',"+p.getValorRecurso()+")";
        return template.update(sql);
    }
    public int update(Processo p){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(p.getDataEntrada());

        String sql="update processo set numero='"+p.getNumero()+"', tipo_processo_id="+p.getTipoProcessoId()+", objetivo='"+p.getObjetivo()+"', data_entrada='"+date+"', valor_recurso=" + p.getValorRecurso() + " where id="+p.getId()+"";
        return template.update(sql);
    }
    public int delete(int id){
        String sql="delete from processo where id="+id+"";
        return template.update(sql);
    }
    public Processo getProcessoById(int id){
        String sql="select * from processo where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Processo>(Processo.class));
    }

    public List<Processo> getProcessoByNumero(String numero){
        String sql="select * from processo inner join tipo_processo on tipo_processo.id = processo.tipo_processo_id where numero LIKE '" + numero + "'";
        return template.query(sql,new RowMapper<Processo>(){
            public Processo mapRow(ResultSet rs, int row) throws SQLException {
                Processo p=new Processo();
                p.setId(rs.getInt(1));
                p.setNumero(rs.getString(2));
                p.setDataEntrada(rs.getDate(3));
                p.setValorRecurso(rs.getDouble(4));
                p.setObjetivo(rs.getString(5));
                p.setTipoProcessoId(rs.getInt(6));
                p.setTipoProcesso(new TipoProcesso(rs.getInt(7),rs.getString(8)));
                return p;
            }
        });
    }
    public List<Processo> getProcesso(){
        return template.query("select * from processo inner join tipo_processo on tipo_processo.id = processo.tipo_processo_id",new RowMapper<Processo>(){
            public Processo mapRow(ResultSet rs, int row) throws SQLException {
                Processo p=new Processo();
                p.setId(rs.getInt(1));
                p.setNumero(rs.getString(2));
                p.setDataEntrada(rs.getDate(3));
                p.setValorRecurso(rs.getDouble(4));
                p.setObjetivo(rs.getString(5));
                p.setTipoProcessoId(rs.getInt(6));
                p.setTipoProcesso(new TipoProcesso(rs.getInt(7),rs.getString(8)));
                return p;
            }
        });

    }

    public boolean existsProcessoByTipoProcesso(int id){
        List<Processo> list = getProcesso();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTipoProcessoId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean existsProcessoByNumero(String numero){
        List<Processo> list = getProcesso();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumero().equalsIgnoreCase(numero)){
                return true;
            }
        }
        return false;
    }

}
