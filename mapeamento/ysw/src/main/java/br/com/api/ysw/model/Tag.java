package br.com.api.ysw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "nome")
  private String name;

  @Column(name = "localizacao")
  private String location;

  @Column(name = "numSerial")
  private String numSerial;

  @ManyToOne
  @JoinColumn(name = "estrutura_id")
  private Estrutura estrutura;

}
