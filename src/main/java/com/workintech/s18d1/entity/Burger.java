package com.workintech.s18d1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "burger")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Double price;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Column(name = "bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    private String contents;

    public void setIsVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean getIsVegan() {
        return isVegan;
    }
}
