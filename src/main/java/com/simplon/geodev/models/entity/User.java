package com.simplon.geodev.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_user_username_email", columnList = "username, email")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_users_username", columnNames = {"username"}),
        @UniqueConstraint(name = "uc_users_email", columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @NotBlank
    @Column(name = "username")
    @Size(max = 20)
    private String username;

    @NotBlank
    @Email
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}

