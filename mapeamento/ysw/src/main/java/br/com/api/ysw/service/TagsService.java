package br.com.api.ysw.service;

import br.com.api.ysw.DTO.request.TagDTO;
import br.com.api.ysw.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

    public TagDTO consultaTag(String numSerial) {
        TagDTO tagDTO = new RestTemplate().getForObject("http://192.168.182.22/", TagDTO.class);

        //Optional<Tag> tag = tagRepository.findByNumSerial(numSerial);
        // if (tag.isPresent()) {
        // return new ResponseEntity<>("Tag encontrada no Sistema", HttpStatus.OK);
        //}
        //return throw new ConsultarTagException("Não existe uma tag com esse Numero Serial");

        return tagDTO;
    }

//    public ResponseEntity<TagDTO> consultaTag = new RestTemplate().exchange("http://192.168.182.22:8080/",
//            HttpMethod.GET, null, TagDTO.class);
}
