package com.workintech.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="fsweb")
public class Vegetable {
@Min(1)    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotBlank
@Column(name="name")
private String name; 

@Min(0)
@Column(name="price")
private double price;

@NotBlank
@Column(name="isGrownOnTree")
private boolean isGrownOnTree;
}
