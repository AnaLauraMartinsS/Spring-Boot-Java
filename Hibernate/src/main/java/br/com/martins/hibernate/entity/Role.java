package br.com.martins.hibernate.entity;

import br.com.martins.hibernate.StatusRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusRole status;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Funcionality> funcionalities;

    public Role(String name, StatusRole status, List<Funcionality> funcionalities) {
        this.name = name;
        this.status = status;
        this.funcionalities = funcionalities;
    }

    public Role(String name, StatusRole status) {
        this.name = name;
        this.status = status;
    }
}
