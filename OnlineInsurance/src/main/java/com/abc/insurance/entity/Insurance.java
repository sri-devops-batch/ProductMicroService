package com.abc.insurance.entity;

import java.util.List;

import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Insurance {
 private String insuranceName;
 private String description;

 
}