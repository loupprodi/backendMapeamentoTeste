package br.com.api.ysw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estrutura")
@Getter
@Setter

public class Estrutura {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "nome")
  private String name;

  @Column(name = "descricao")
  private String description;
}
