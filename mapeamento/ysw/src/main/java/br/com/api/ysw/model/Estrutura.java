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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer estrutura_id;

  @Column(name = "nome")
  private String name;

  @Column(name = "descricao")
  private String description;
}
