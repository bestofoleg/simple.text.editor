package ru.boo.simple.text.editor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.boo.simple.text.editor.entity.model.Text;

import java.util.List;

@Repository
public interface TextRepository extends CrudRepository <Text, Long> {
    List<Text> findTextByUserTextContains(String text);
}
