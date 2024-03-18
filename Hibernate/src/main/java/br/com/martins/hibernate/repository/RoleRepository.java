package br.com.martins.hibernate.repository;

import br.com.martins.hibernate.StatusRole;
import br.com.martins.hibernate.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByStatus(StatusRole status);

    @Override
    Page<Role> findAll(Pageable pageable);
}
