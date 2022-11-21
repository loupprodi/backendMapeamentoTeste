package br.com.api.ysw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "nome")
  private String name;

  @Column(name = "senha")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "reponsavel")
  private String responsable;

  @Column(name = "contatoReponsavel")
  private String contatResponsable;

  
}
