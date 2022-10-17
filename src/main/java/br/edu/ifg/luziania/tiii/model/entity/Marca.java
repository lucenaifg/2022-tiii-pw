package br.edu.ifg.luziania.tiii.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbmarca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca(){
    }

    public Marca(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
