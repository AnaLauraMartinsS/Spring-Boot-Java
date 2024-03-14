package br.com.martins.hibernate;


import br.com.martins.hibernate.entity.Role;
import br.com.martins.hibernate.entity.Users;
import br.com.martins.hibernate.repository.RoleRepository;
import br.com.martins.hibernate.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Role role = new Role();

        role.setName("Administrador");
        role.setStatus(StatusRole.ATIVO);

        Role role2 = new Role();
        role2.setName("Aluno");
        role2.setStatus(StatusRole.INATIVO);

        this.roleRepository.save(role);
        this.roleRepository.save(role2);

        Users users = new Users();

        users.setName("Ana Laura Martins");
        users.setEmail("ana.martins@gmail.com");
        users.setRole(role);

        Users users2 = new Users();

        users2.setName("Carolina Martins");
        users2.setEmail("carol.martins@gmail.com");
        users2.setRole(role);

        this.userRepository.save(users);
        this.userRepository.save(users2);

    }

}
