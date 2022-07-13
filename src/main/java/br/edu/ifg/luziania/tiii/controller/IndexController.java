package br.edu.ifg.luziania.tiii.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class IndexController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getIndexHTML(){
        return Templates.index();
    }


}
