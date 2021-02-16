package ru.boo.simple.text.editor.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.boo.simple.text.editor.repository.TextRepository;
import ru.boo.simple.text.editor.service.TextService;
import ru.boo.simple.text.editor.service.TextServiceImpl;

@TestConfiguration
public class ServicesConfiguration {
    @Bean
    TextService textService(TextRepository textRepository) {
        return new TextServiceImpl(textRepository);
    }
}
