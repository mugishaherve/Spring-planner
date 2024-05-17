package com.year2b.plannerproject.models;

import javax.persistence.*;
import  java.util.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    List<Todo> todos;

}
