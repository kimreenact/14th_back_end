package com.example.CarPractice.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CAR")
@Schema(description = "자동차 정보")
public class Car {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "차량 ID (서버 자동 생성)", example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "BRAND")
    @Schema(description = "브랜드", example = "현대")
    private String brand;

    @Column(name = "MODEL")
    @Schema(description = "모델명", example = "아반떼")
    private String model;

    @Column(name = "PRICE")
    @Schema(description = "가격(원)", example = "25000000")
    private int price;

    @Column(name = "SOLD")
    @Schema(description = "판매 여부", example = "false")
    private boolean sold;
}
