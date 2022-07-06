package br.edu.ifg.luziania.bsi.pw.aula05;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.io.*;
import java.net.URISyntaxException;

@Path("")
public class IndexController {

    @Context
    ServletContext servletContext;

    private FileInputStream getFile(String filename) {
        try {
            String base = servletContext.getRealPath("/WEB-INF/classes/frontend");
            File f = new File(String.format("%s/%s", base, filename));
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @GET
    @Path("")
    @Produces("text/html")
    public InputStream getHTML() throws URISyntaxException, IOException {
        return getFile("index.html");
    }

    @GET
    @Path("assets/js/{file}")
    @Produces("text/html")
    public InputStream getJS(@PathParam("file") String file, @Context HttpServletRequest request) throws URISyntaxException, IOException {
        return getFile("assets/js/"+file);
    }


}
