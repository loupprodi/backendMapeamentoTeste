package br.com.api.ysw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer usuario_id;

  @Column(name = "nome")
  private String name;

  @Size(min = 3, max = 20, message = "O usuario deve conter entre 3 a 20 caracteres")
  @Column(name = "username")
  private String username;

  @Size(min=3 ,max = 8, message = "A senha deve conter entre 3 a 8 caracteres")
  @Column(name = "senha")
  private String password;

  @Email
  @Column(name = "email")
  private String email;

  @Column(name = "reponsavel")
  private String responsable;

  @Column(name = "contatoReponsavel")
  private String contatResponsable;
}
