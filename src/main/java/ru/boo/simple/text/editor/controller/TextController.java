package ru.boo.simple.text.editor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.boo.simple.text.editor.entity.dto.TextDto;
import ru.boo.simple.text.editor.entity.model.Text;
import ru.boo.simple.text.editor.service.TextService;
import ru.boo.simple.text.editor.util.Constants;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@RestController
@RequestMapping(path = Constants.API_URL + "/text")
@RequiredArgsConstructor
public class TextController {
    private final TextService textService;

    @GetMapping(path = "/{id}")
    public TextDto getText(@PathVariable("id") Long id) {
        return textService.getText(id);
    }

    @PostMapping(path = "/save")
    public TextDto saveText(@RequestBody TextDto textDto) {
        Text text = textService.saveText(textDto);
        return TextDto.builder()
                .id(text.getId())
                .userText(text.getUserText())
                .build();
    }

    @GetMapping(path = "/random")
    public TextDto getRandomText() {
        Random random = new Random();
        byte [] bytes = {};
        random.nextBytes(bytes);
        return TextDto.builder()
                .userText(new String(bytes, StandardCharsets.UTF_8))
                .build();
    }
}
