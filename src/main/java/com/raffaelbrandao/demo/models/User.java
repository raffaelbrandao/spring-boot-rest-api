package com.raffaelbrandao.demo.models;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String name;
    @ToString.Exclude @EqualsAndHashCode.Exclude private String password;

}
