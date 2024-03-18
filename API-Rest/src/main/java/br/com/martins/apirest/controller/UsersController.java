package br.com.martins.apirest.controller;

import br.com.martins.apirest.model.Users;
import br.com.martins.apirest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getUser(){
        return usersRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void findAll(@PathVariable Long id){
        usersRepository.deleteById(id);
    }

    @PostMapping("/save")
    public Users save(@RequestBody Users users){
        return usersRepository.save(users);
    }

    @PutMapping("/update")
    public Users update(@RequestBody Users users){
        return usersRepository.save(users);
    }

}
