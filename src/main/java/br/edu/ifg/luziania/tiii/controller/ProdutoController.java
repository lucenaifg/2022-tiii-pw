package br.edu.ifg.luziania.tiii.controller;

import br.edu.ifg.luziania.tiii.model.bo.ProdutoBO;
import br.edu.ifg.luziania.tiii.model.dto.ProdutoDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("produto")
public class ProdutoController {

    @Inject
    ProdutoBO bo;

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(ProdutoDTO dto){
        bo.save(dto);
        return Response.ok().build();
    }

    @POST
    @Path("marca/save/{marca}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMarca(@PathParam("marca") String marca){
        bo.saveMarca(marca);
        return Response.ok().build();
    }

    @POST
    @Path("marca/save/jdbc/{marca}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMarcaJDBC(@PathParam("marca") String marca){
        bo.saveMarcaWithJDBC(marca);
        return Response.ok().build();
    }

    @GET
    @Path("marca/search/jdbc/{marca}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listMarcasJDBC(@PathParam("marca") String marca){
        return Response.ok(bo.searchMarcasWithJDBC(marca)).build();
    }



//
//    @GET
//    @Path("search/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response save(@PathParam("id") Integer id){
//        Produto produto = dao.getById(id);
//        if (nonNull(produto))
//            System.out.println(produto.getNome());
//        return Response.ok(produto).build();
//    }
//
//    @GET
//    @Path("list/{nome}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response save(@PathParam("nome") String nome){
//        List<Produto> produtos = dao.getByNome(nome);
//        return Response.ok(produtos).build();
//    }
}
