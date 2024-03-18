package br.com.martins.pagweb.controller;

import br.com.martins.pagweb.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value ="user/{name}", method = RequestMethod.GET)
    public List<User> getUsers(@PathVariable String name){

        List<User> users = new ArrayList<>();

        User user = new User("Ana Laura Martins", "ana.martins@gmail.com");

        User user1 = new User(name, "carol.martins@gmail.com");

        users.add(user);
        users.add(user1);

        return users;

    }

    @RequestMapping(value ="user", method = RequestMethod.POST)
    public User setUser(@RequestBody User user ){

        return user;
    }


}
