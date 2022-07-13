package br.edu.ifg.luziania.tiii.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PessoaFormDTO {

    private List<String> sexos;

    public PessoaFormDTO(){
        sexos = new ArrayList<>();
    }

    public List<String> getSexos() {
        return sexos;
    }

    public void setSexos(List<String> sexos) {
        this.sexos = sexos;
    }
}
