package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.model.User;
import test.response.Response;
import test.service.UsersService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Response> create(@Valid @RequestBody User user) {
        usersService.insert(user);
        return new ResponseEntity<>(new Response(HttpStatus.CREATED, user.toString()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Response> read() {
        final List<User> users = usersService.getAllUsers();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(new Response(HttpStatus.OK, users.toString()), HttpStatus.OK)
                : new ResponseEntity<>(new Response(HttpStatus.NOT_FOUND, "No users found!"), HttpStatus.NOT_FOUND);
    }
/*
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Response> read(@PathVariable(name = "id") int id) {
        final User user = userService.findUserByID(id);
        return user != null
                ? new ResponseEntity<>(new Response(HttpStatus.OK, user.toString()), HttpStatus.OK)
                : new ResponseEntity<>(new Response(HttpStatus.NOT_FOUND, "The user with ID " + id + " does not exist!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Response> delete(@PathVariable(name = "id") int id) {
        try {
            userService.deleteUserByID(id);
            return new ResponseEntity<>(new Response(HttpStatus.OK, "User successfully deleted!"), HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new Response(HttpStatus.NOT_MODIFIED, "The user with ID " + id + " does not exist!"), HttpStatus.NOT_MODIFIED);
        }
    }*/
}

























