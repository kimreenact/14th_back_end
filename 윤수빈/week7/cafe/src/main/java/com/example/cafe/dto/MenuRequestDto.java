package com.example.cafe.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
//외부에 있는 데이터를 private 안으로 넣을때
@Setter
//private 안에 있는 데이터를 외부에 꺼낼 떄

public class MenuRequestDto {
    //Dto 가 뭘까 -> Data Transfer Object 데이터 전달용 객체 -- 유지보수가 쉽게하려고


    private String name;
    private int price;
    private String category;
    //private(캡슐화)로 @Setter를 통해 데이터 접근 가능

}