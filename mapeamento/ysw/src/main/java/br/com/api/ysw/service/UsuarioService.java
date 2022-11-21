package br.com.api.ysw.service;

import br.com.api.ysw.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private Usuarios usuariosRepository;
}
