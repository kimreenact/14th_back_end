package org.example.week9assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity는 JPA가 관리. DB의 테이블과 1:1로 매핑
@Entity
public class Car {

    //DB에서 PK 지정할 때 @Id 사용
    @Id

    //GenerationType.IDENTITY는 DB에게 기본키 값 자동 증가하게 만듦
    //개발자가 직접 id를 계산해서 넣어줄 필요가 없어서 데이터 무결성을 지키기 편리함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer price;
    private boolean sold;

    //JPA가 DB에서 데이터를 꺼내와 객체로 만들 떄 이 비어있는 기본 생성자를 내부적으로 무조건 먼저 호출
    //만약 기본 생성자가 없으면 JPA가 에러. @Entity 클래스에는 필수로 있어야함
    public Car() {}


    public Car(String brand, String model, Integer price, boolean sold) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.sold = sold;
    }

    //필드는 private(캡슐화)으로 막고 Service와 Controller에서 값을 안정할 수전하게 꺼내고 수 있도록 Getter/Setter를 열어둔 구조임
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}