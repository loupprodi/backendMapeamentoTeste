package br.com.api.ysw.controller;

import br.com.api.ysw.model.Usuario;
import br.com.api.ysw.repository.Usuarios;
import br.com.api.ysw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Usuarios usuariosRepository;


    //metodo de buscar o usuario
    @GetMapping("{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Integer id){

        try {
            Optional<Usuario> user = usuariosRepository.findById(id);
            if (user.isEmpty()) {
                return new ResponseEntity<>("Usuário não encontrado.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //rota de criar o usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save (@RequestBody Usuario usuarios){
        return usuariosRepository.save(usuarios);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Usuario> updateUsers(@PathVariable("id") Integer id, @RequestBody Usuario usuarios) {
        Optional<Usuario> usuarioDados = usuariosRepository.findById(id);

        if (usuarioDados.isPresent()) {
            Usuario _usuarios = usuarioDados.get();
            _usuarios.setName(usuarioDados.get().getName());
            _usuarios.setResponsable(usuarioDados.get().getResponsable());
            _usuarios.setContatResponsable(usuarioDados.get().getContatResponsable());
            _usuarios.setEmail(usuarioDados.get().getEmail());
            return new ResponseEntity<>(usuariosRepository.save(_usuarios), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllUsers() {
        try {
            usuariosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a estrutura tbm
    @GetMapping
    public List<Usuario> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return usuariosRepository.findAll(example);
    }
}
