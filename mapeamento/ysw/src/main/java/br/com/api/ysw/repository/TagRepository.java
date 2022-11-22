package br.com.api.ysw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ysw.model.Tag;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface TagRepository extends JpaRepository<Tag,Integer> {
    @Query(value = "select * from tag where estrutura_id = :estrutura_id", nativeQuery = true)
    List<Tag> findAllByIdEstrutura(Integer estrutura_id);

//    @Query(value= "select * from tag where numSerial = :numSerial", nativeQuery = true)
//    List<Tag> findByNumSerial(Tag tag);
}
