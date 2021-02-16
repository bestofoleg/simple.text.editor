package ru.boo.simple.text.editor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boo.simple.text.editor.entity.dto.TextDto;
import ru.boo.simple.text.editor.entity.model.Text;
import ru.boo.simple.text.editor.repository.TextRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {
    private final TextRepository textRepository;

    @Override
    public Text saveText(TextDto textDto) {
        return textRepository.save(Text.builder()
                .userText(textDto.getUserText())
                .build());
    }

    @Override
    public List<TextDto> findTextByContains(String text) {
        return textRepository.findTextByUserTextContains(text).stream()
                .map(dbText -> TextDto.builder()
                        .id(dbText.getId())
                        .userText(dbText.getUserText())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TextDto getText(Long id) {
        return textRepository.findById(id)
                .map(text -> TextDto.builder()
                        .id(text.getId())
                        .userText(text.getUserText())
                        .build())
                .orElse(TextDto.builder()
                        .id(-1L)
                        .userText("not found")
                        .build());
    }
}
