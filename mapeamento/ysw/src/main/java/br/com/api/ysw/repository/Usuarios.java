package br.com.api.ysw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ysw.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer> {
  
}
