package com.gmail.merzlikinnikplay.springbootcrudapp.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer  age;

    public User(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
