package br.com.api.ysw.controller;

import br.com.api.ysw.model.Tag;
import br.com.api.ysw.model.Usuario;
import br.com.api.ysw.repository.Tags;
import br.com.api.ysw.service.TagsService;
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
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    TagsService tagsService;

    @Autowired
    Tags tagsRepository;

    @GetMapping("{id}")
    public Tag getTagById(@PathVariable Integer id) {
        return tagsRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tag não encontrada"));
    }

    @GetMapping("/")
    public ResponseEntity<?> getTagByIdEstrutura(@RequestParam("idEstrutura") Integer idEstrutura) {
        try {
            List<Tag> tags = tagsRepository.findAllByIdEstrutura(idEstrutura);
            if (tags.isEmpty()) {
                return new ResponseEntity<>("Não há tags para essa estrutura", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag save (@RequestBody Tag tags){
        return tagsRepository.save(tags);
    }

    @PutMapping("/updateTags/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable("id") Integer id, @RequestBody Usuario usuarios) {
        Optional<Tag> tagDados = tagsRepository.findById(id);

        if (tagDados.isPresent()) {
            Tag _tag = tagDados.get();
            _tag.setName(tagDados.get().getName());
            _tag.setLocation(tagDados.get().getLocation());
            _tag.setNumSerial(tagDados.get().getNumSerial());
            return new ResponseEntity<>(tagsRepository.save(_tag), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        @DeleteMapping("/delete")
        public ResponseEntity<HttpStatus> deleteAllTags() {
            try {
                tagsRepository.deleteAll();
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
            return tagsRepository.findAll(example);
        }
    }
