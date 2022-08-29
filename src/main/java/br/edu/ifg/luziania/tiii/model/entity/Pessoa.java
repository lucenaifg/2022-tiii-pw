package br.edu.ifg.luziania.tiii.model.entity;


import br.edu.ifg.luziania.tiii.model.dto.PessoaDTO;

public class Pessoa {

    private Integer id;
    private String nome;
    private String sexo;

    public Pessoa(){
    }
    public Pessoa(PessoaDTO dto){
        this(dto.getId(), dto.getNome(), dto.getSexo());
    }

    public Pessoa(Integer id, String nome, String sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
