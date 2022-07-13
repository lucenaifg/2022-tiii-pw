package br.edu.ifg.luziania.tiii.controller;

import br.edu.ifg.luziania.tiii.model.bo.PessoaBO;
import br.edu.ifg.luziania.tiii.model.dto.PessoaDTO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pessoa")
public class CadastroPessoaController {

    @Inject
    PessoaBO bo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro();
    }

    @GET
    @Path("cadastro")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastroHTML(){
        return Templates.cadastro();
    }

    @GET
    @Path("cadastro/formdata")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getFormData(){
        return Response.ok(bo.getFormData()).build();
    }

    @POST
    @Path("cadastro/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PessoaDTO dto){
        return Response.ok(bo.save(dto)).build();
    }

}
