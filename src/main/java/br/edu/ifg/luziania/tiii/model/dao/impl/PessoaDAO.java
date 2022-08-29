package br.edu.ifg.luziania.tiii.model.dao.impl;


import br.edu.ifg.luziania.tiii.model.dao.AbstractDAO;
import br.edu.ifg.luziania.tiii.model.entity.Pessoa;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class PessoaDAO extends AbstractDAO<Pessoa> {

    private Pessoa fromResultSet(ResultSet resultSet){
        try {
            return new Pessoa(resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("telefone"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("CREATE TABLE IF NOT EXISTS PESSOA ")
                .append(" (id INTEGER auto_increment,")
                .append(" nome VARCHAR(255), ")
                .append(" sexo VARCHAR(20), ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connection().prepareStatement(sql.toString()).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Pessoa entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("INSERT INTO PESSOA (nome, sexo) VALUES (?, ?);");
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getSexo());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void update(Pessoa entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("UPDATE PESSOA SET ")
                .append("nome = '"+entity.getNome()+"', ")
                .append("sexo = '"+entity.getSexo()+"',")
                .append("WHERE id = "+entity.getId()+";");
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("UPDATE PESSOA SET nome = ?, sexo = ? WHERE id = ?;");
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getSexo());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Pessoa entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("DELETE FROM PESSOA WHERE id = ?;");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Pessoa getById(Pessoa entity) {
        Pessoa pessoa = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM PESSOA WHERE id = ?");
            ps.setInt(1, entity.getId());
            pessoa = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return pessoa;
    }

    @Override
    public List<Pessoa> getAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM PESSOA");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                pessoas.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return pessoas;
    }
}