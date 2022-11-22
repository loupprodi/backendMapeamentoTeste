package br.com.api.ysw.controller;

import br.com.api.ysw.DTO.UsuarioDTO;
import br.com.api.ysw.exception.ErroAutenticacao;
import br.com.api.ysw.model.Usuario;
import br.com.api.ysw.repository.UsuarioRepository;
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
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;


    /*metodo de buscar o usuario http://localhost:8080/api/users/:id */
    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuario não encontrado"));
    }

    //rota de criar o usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvarUsuario (@RequestBody Usuario usuarios){
        return  usuarioService.salvarUsuario(usuarios);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Usuario> updateUsers(@PathVariable("id") Integer id, @RequestBody Usuario usuarios) {
        Optional<Usuario> usuarioDados = usuarioRepository.findById(id);

        if (usuarioDados.isPresent()) {
            Usuario _usuarios = usuarioDados.get();
            _usuarios.setName(usuarioDados.get().getName());
            _usuarios.setResponsable(usuarioDados.get().getResponsable());
            _usuarios.setContatResponsable(usuarioDados.get().getContatResponsable());
            _usuarios.setEmail(usuarioDados.get().getEmail());
            return new ResponseEntity<>(usuarioRepository.save(_usuarios), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            usuarioRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a estrutura tbm
    @GetMapping
    public List<Usuario> find(Usuario filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return usuarioRepository.findAll(example);
    }

    /**outra rota de criar usuario*/
    @PostMapping("/authenticate")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto){
        try{
        Usuario usuarioAutenticado =  usuarioService.autenticar(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok(usuarioAutenticado);
        }catch (ErroAutenticacao e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
