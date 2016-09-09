/*
package com.springBoot.rest;

import com.springBoot.model.Hello;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

*/
/**
 * Created by Hafiz on 8/25/2016.
 *//*


@Component
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Hello resource", produces = "application/json")
public class HelloResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);

    @GET
    @Path("v1/hello/{name}")
    @ApiOperation(value = "Gets a hello resource. Version 1 - (version in URL)", response = Hello.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hello resource found"),
            @ApiResponse(code = 404, message = "Hello resource not found")
    })
    public Response getHelloVersionInUrl(@ApiParam @PathParam("name") String name) {
        LOGGER.info("getHelloVersionInUrl() v1");
        return this.getHello(name, "Version 1 - passed in URL");
    }

    @GET
    @Path("hello/{name}")
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value = "Gets a hello resource. World Version 1 (version in Accept Header)", response = Hello.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hello resource found"),
            @ApiResponse(code = 404, message = "Hello resource not found")
    })
    public Response getHelloVersionInAcceptHeader(@PathParam("name") String name) {
        LOGGER.info("getHelloVersionInAcceptHeader() v1");
        return this.getHello(name, "Version 1 - passed in Accept Header");
    }

    @POST
    @Path("v1/hello")
    @ApiOperation(value = "Creates hello resource. Version 1 - (version in URL)", response = Hello.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "hello resource created", responseHeaders = {
                    @ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
            })
    })
    public Response createHelloVersionInUrl(Hello hello, @Context UriInfo uriInfo) {
        LOGGER.info("createHelloVersionInUrl() v1");
        return this.createHelloWorld(hello, uriInfo);
    }

    @POST
    @Path("hello")
    @Consumes("application/json")
    @ApiOperation(value = "Creates hello resource. Version 1 - (version in Accept Header)", response = Hello.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "hello resource created", responseHeaders = {
                    @ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = String.class)
            })
    })
    public Response createHelloVersionInAcceptHeader(Hello hello, @Context UriInfo uriInfo) {
        LOGGER.info("createHelloVersionInAcceptHeader() v1");
        return this.createHelloWorld(hello, uriInfo);
    }

    private Response getHello(String name, String partialMsg) {
        if ("404".equals(name)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Hello result = new Hello();
        result.setMsg(String.format("Hello %s. %s", name, partialMsg));
        return Response.status(Response.Status.OK).entity(result).build();
    }

    private Response createHelloWorld(Hello hello, UriInfo uriInfo) {
        // Creates resource and return 201 with reference to new resource in Location header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(hello.getMsg());
        builder.path(hello.getId());
        builder.path(hello.getName());
        builder.path(hello.getCellNumber());

        return Response.created(builder.build()).build();
    }
}
*/
