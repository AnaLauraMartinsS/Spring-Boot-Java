package br.com.martins.hibernate.repository;

import br.com.martins.hibernate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.name like %?1%")
    Users findByName(String name);

    Users findByEmail(String email);


}
