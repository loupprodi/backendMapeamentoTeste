package br.com.api.ysw.controller;

import br.com.api.ysw.model.Estrutura;
import br.com.api.ysw.repository.Estruturas;
import br.com.api.ysw.service.EstruturaService;
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
@RequestMapping("api/estruturas")
public class EstruturaController {

    @Autowired
    EstruturaService estruturaService;

    @Autowired
    Estruturas estruturasRepository;


    //metodo de buscar a estrutura por id
    @GetMapping("{id}")
    public Estrutura getEstruturaById(@PathVariable Integer id){
        return estruturasRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Estrutura não encontrada"));
    }

    //rota de criar a estrutura
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estrutura save (@RequestBody Estrutura estruturas){
        return estruturasRepository.save(estruturas);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Estrutura> updateEstrutura(@PathVariable("id") Integer id, @RequestBody Estrutura estruturas) {
        Optional<Estrutura> estruturaDados = estruturasRepository.findById(id);

        if (estruturaDados.isPresent()) {
            Estrutura _estruturas = estruturaDados.get();
            _estruturas.setName(estruturaDados.get().getName());
            _estruturas.setId(estruturaDados.get().getId());
            _estruturas.setDescription(estruturaDados.get().getDescription());
            return new ResponseEntity<>(estruturasRepository.save(_estruturas), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllEstrutura() {
        try {
            estruturasRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a estrutura tbm
    @GetMapping
    public List<Estrutura> find(Estrutura filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return estruturasRepository.findAll(example);
    }
}
