package br.com.api.ysw.service;

import br.com.api.ysw.repository.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsService {

    @Autowired
    private Tags tags;
}
