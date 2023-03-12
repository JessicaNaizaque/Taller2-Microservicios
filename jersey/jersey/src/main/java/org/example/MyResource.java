package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myapp/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String first(@QueryParam("name") String name) {
        return "Hola " + name;
    }

    @GET
    @Path("hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String second(@PathParam("name") String name) {
        return "Hola " + name;
    }

    /*@GET
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String third(@QueryParam("name") String name) {
        return "Hola " + name;
    }*/

    @GET
    @Path("user")
    @Produces(MediaType.TEXT_HTML)
    public String fourth(@QueryParam("name") String name) {
        return "<html>\n" +
                "<head>\n" +
                "\t<title> Rest Server </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Bienvenido " + name + "</h1>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    @GET
    @Path("multiplication/{num1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String fifth(@PathParam("num1") String num1, @QueryParam("num2") String num2) {
        return String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2));
    }
}
