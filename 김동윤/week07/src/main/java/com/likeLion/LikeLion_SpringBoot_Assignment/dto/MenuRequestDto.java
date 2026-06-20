package com.likeLion.LikeLion_SpringBoot_Assignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuRequestDto {
    private String name;
    private int price;
    private String category;
}
