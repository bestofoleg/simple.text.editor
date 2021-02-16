package ru.boo.simple.text.editor.service;

import ru.boo.simple.text.editor.entity.dto.TextDto;
import ru.boo.simple.text.editor.entity.model.Text;

import java.util.List;

public interface TextService {
    TextDto getText(Long id);
    Text saveText(TextDto textDto);
    List<TextDto> findTextByContains(String text);
}
