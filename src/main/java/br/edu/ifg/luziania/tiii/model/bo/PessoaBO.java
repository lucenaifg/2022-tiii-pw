package br.edu.ifg.luziania.tiii.model.bo;

import br.edu.ifg.luziania.tiii.model.dto.PessoaDTO;
import br.edu.ifg.luziania.tiii.model.dto.PessoaFormDTO;

import javax.enterprise.context.Dependent;

@Dependent
public class PessoaBO {

    public PessoaFormDTO getFormData() {
        PessoaFormDTO dto = new PessoaFormDTO();
        dto.getSexos().add("Masculino");
        dto.getSexos().add("Feminino");
        return dto;
    }

    public Boolean save(PessoaDTO dto) {
        //codigo de persistencia da entidade Pessoa
        return true;
    }
}
