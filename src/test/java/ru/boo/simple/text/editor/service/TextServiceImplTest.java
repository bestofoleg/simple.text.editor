package ru.boo.simple.text.editor.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.boo.simple.text.editor.SimpleTextEditorApplication;
import ru.boo.simple.text.editor.configuration.ServicesConfiguration;
import ru.boo.simple.text.editor.entity.dto.TextDto;
import ru.boo.simple.text.editor.entity.model.Text;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        SimpleTextEditorApplication.class,
        ServicesConfiguration.class
})
public class TextServiceImplTest {
    @Autowired
    private TextService textService;

    private final TextDto testTextDtoForSaving = TextDto.builder()
            .userText("test")
            .build();

    @Test
    public void saveText_is_correct_savedText() {
        String correctText = testTextDtoForSaving.getUserText();
        Text savedText = textService.saveText(testTextDtoForSaving);
        assertEquals(correctText, savedText.getUserText());
    }

    @Test
    public void getText_is_correct_text_return() {
        Text savedText = textService.saveText(testTextDtoForSaving);
        Long savedTextId = savedText.getId();
        TextDto textFromDb = textService.getText(savedTextId);
        assertEquals(testTextDtoForSaving.getUserText(), textFromDb.getUserText());
    }

    @Test
    public void findTextByContains_is_correct_text_return() {
        String searchingMask = "te";
        TextDto textDtoIsContains1 = TextDto.builder()
                .userText("test")
                .build();
        TextDto textDtoIsContains2 = TextDto.builder()
                .userText("tetris")
                .build();
        TextDto textDtoIsNotContains = TextDto.builder()
                .userText("user is not reader")
                .build();
        textService.saveText(textDtoIsContains1);
        textService.saveText(textDtoIsContains2);
        Text textNotContainsSaved = textService.saveText(textDtoIsNotContains);
        List<TextDto> searchingResults = textService.findTextByContains(searchingMask);
        assertEquals(0, searchingResults.stream()
                .filter(result -> result.getId().equals(textNotContainsSaved.getId()))
                .count());
    }
}