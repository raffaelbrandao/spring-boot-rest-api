package com.raffaelbrandao.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String name;
    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable
    private List<String> roles;
}
