package com.nvd.shop_demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String userName;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String password;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String phone;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String fullName;

    @Column(nullable = true)
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(name = "permission",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Blog> blog = new ArrayList<>();
}
