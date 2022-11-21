package br.com.api.ysw.service;

import br.com.api.ysw.repository.Estruturas;
import br.com.api.ysw.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstruturaService {

    @Autowired
    private Estruturas estruturas;
}
