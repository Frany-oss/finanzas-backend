package com.finance.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Moneda")
@Data
@Accessors(chain = true)
public class Moneda {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long CMoneda;

  private String NMoneda;
  private String NSimbolo;
}
