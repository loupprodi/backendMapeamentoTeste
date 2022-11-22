package br.com.api.ysw.service;

import br.com.api.ysw.DTO.request.TagDTO;
import br.com.api.ysw.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

    public TagDTO consultaTag(String numSerial) {
        TagDTO tagDTO = new RestTemplate().getForObject("http://localhost:3000/estrutura", TagDTO.class);

        //Optional<Tag> tag = tagRepository.findByNumSerial(numSerial);
        // if (tag.isPresent()) {
        // return OK
        //}
        //return EXCEPTION

        return tagDTO;
    }
}
