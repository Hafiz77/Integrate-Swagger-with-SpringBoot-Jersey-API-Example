/*
package com.springBoot.rest;

import com.springBoot.dao.SpringDataDBUtils;
import com.springBoot.model.User;
import com.springBoot.utility.AppConstant;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

*/
/**
 * Created by Hafiz on 8/25/2016.
 *//*


@Component
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "User resource", produces = "application/json")
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @GET
    @Path("v1/users/{id}")
    @ApiOperation(value = "Gets an User resource. Version 1 - (version in URL)", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User resource found"),
            @ApiResponse(code = 404, message = "User resource not found")
    })
    public Response getUser(@ApiParam @PathParam("id") String id, @Context UriInfo uriInfo) {
        LOGGER.info("getUser() v1");
        try {
            LOGGER.info("Retrieving  user with id=" + id);
            User u = this.get(id);
            LOGGER.info("User com.api.service called with this id=" + id);
            if (u != null) {
                return Response.status(Response.Status.OK).entity(u).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        } catch (Exception e) {
            LOGGER.error("Error retrieving user", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Path("v1/users")
    @ApiOperation(value = "Gets an User resource. Version 1 - (version in URL)", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User resource found"),
            @ApiResponse(code = 404, message = "User resource not found")
    })
    public Response getUsers(@Context UriInfo info) {
        Map<Object, Object> apiResponse = new HashMap<Object, Object>();
        Integer limit = AppConstant.RECORDS_LIMIT;
        Integer offset = AppConstant.RECORDS_OFFSET;

        LOGGER.info("getUsers() v1");
        try {
            if (info.getQueryParameters().getFirst("limit") != null) {
                limit = Integer.parseInt(info.getQueryParameters().getFirst("limit"));
            }
            if (info.getQueryParameters().getFirst("offset") != null) {
                offset = Integer.parseInt(info.getQueryParameters().getFirst("offset"));
            }
            List<User> users = this.list(offset, limit);
            apiResponse.put("offset", offset);
            apiResponse.put("limit", limit);
            apiResponse.put("total", users.size());
            apiResponse.put("users", users);
            return Response.ok(apiResponse).build();
        } catch (Exception e) {
            LOGGER.error("Error retrieving user", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @POST
    @Path("v1/users")
    @ApiOperation(value = "Creates User resource. Version 1 - (version in URL)", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User resource created", responseHeaders = {
                    @ResponseHeader(name = "Location", description = "The URL to retrieve created User", response = String.class)
            })
    })
    public Response createUser(User user, @Context UriInfo uriInfo) {
        LOGGER.info("createHelloVersionInUrl() v1");

        Map<Object, Object> apiResponse = new HashMap<Object, Object>();
        try {
            Set<ConstraintViolation<User>> validateErrors = validator.validate(user);
            if (validateErrors.isEmpty()) {
                LOGGER.debug("Calling user com.api.service: " + user.getEmail());
                user = (User) this.create(user);
                if (user != null) {
                    LOGGER.debug("User done creating user with email :" + user.getEmail());
                    apiResponse.put("message", Response.Status.CREATED);
                    apiResponse.put("user", user);
                    return Response.ok(apiResponse).build();
                }
            } else {
                for (ConstraintViolation<User> error : validateErrors) {
                    apiResponse.put(error.getPropertyPath().toString(),
                            error.getMessage());
                }
                return Response.status(Response.Status.BAD_REQUEST).entity(apiResponse).build();
            }

        } catch (Exception e) {
            LOGGER.error("Error retrieving user", e);
            apiResponse.put("error", e.getMessage());

        }
        return Response.status(500).entity(apiResponse).build();

    }


    */
/*
    service method for get an user
    * *//*

    public User get(String userId) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(userId));
        return SpringDataDBUtils.getMongoOperations().findOne(query, User.class);
    }

    */
/*
    service method for get  users
    * *//*

    public List<User> list(Integer offset, Integer limit) throws Exception {
        List<User> users = new ArrayList<User>();
        Query query = new Query();
        query.limit(limit);
        query.skip(offset);
        users = SpringDataDBUtils.getMongoOperations().find(query, User.class);
        return users;
    }

    public Object create(User user) throws Exception {
        SpringDataDBUtils.getMongoOperations().insert(user);
        return user;
    }

}
*/
