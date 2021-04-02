package org.acme.resource;

import org.acme.entity.Person;
import org.acme.repository.PersonRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository repository;

    @POST
    @Transactional
    public void create(Person person) {
        person.persist();
    }

    @GET
    @Path("/{id}")
    public Person getById(@PathParam Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
}
