package br.com.api.ysw.service;

import br.com.api.ysw.model.Estrutura;
import br.com.api.ysw.repository.EstruturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EstruturaService {

    @Autowired
    private EstruturaRepository estruturaRepository;

    @Transactional
    public Estrutura salvarEstrutura(Estrutura estrutura){
        estrutura.setEstrutura_id(null);
        return estruturaRepository.save(estrutura);
    }

}
