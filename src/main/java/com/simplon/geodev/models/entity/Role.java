package com.simplon.geodev.models.entity;

import com.simplon.geodev.Enum.ERole;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.LinkedHashSet;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleID;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new LinkedHashSet<>();

    public Role(ERole name) {
        this.name = name;
    }
}
