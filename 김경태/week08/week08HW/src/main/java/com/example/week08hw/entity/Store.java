package com.example.week08hw.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private Long  id;
    private String name;

    public Store(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
