package br.com.api.ysw.repository;

import br.com.api.ysw.model.Estrutura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstruturaRepository extends JpaRepository<Estrutura, Integer> {
  
}
