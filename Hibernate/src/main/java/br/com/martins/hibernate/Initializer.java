package br.com.martins.hibernate;


import br.com.martins.hibernate.entity.Funcionality;
import br.com.martins.hibernate.entity.Role;
import br.com.martins.hibernate.entity.Users;
import br.com.martins.hibernate.repository.RoleRepository;
import br.com.martins.hibernate.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        Funcionality funcionality = new Funcionality();
        funcionality.setName("Add");

        Funcionality funcionality2 = new Funcionality();
        funcionality2.setName("Delete");

        Role role = new Role("Admin", StatusRole.ATIVO, Arrays.asList(funcionality));
        Role role3 = new Role("Aluno", StatusRole.INATIVO, Arrays.asList(funcionality2));

        Users users = new Users();

        users.setName("Ana Laura Martins Souto");
        users.setEmail("ana.martins@gmail.com");
        users.setRoles(Arrays.asList(role, role3));

        this.usersRepository.save(users);

        List<Users> usersR = this.usersRepository.findAll();

        for(Users users2 : usersR){
            for(Role role2 : users2.getRoles()){
                for(Funcionality f : role2.getFuncionalities()){
                    System.out.println(f.getName());
                }
                System.out.println(role2.getName());
            }
        }

    }

}
