package ru.boo.simple.text.editor.entity.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "TEXT")
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    @Id
    @GeneratedValue(generator = "TEXT_ID_SEQ")
    @Column(columnDefinition = "serial")
    @SequenceGenerator(name = "TEXT_ID_SEQ", sequenceName = "TEXT_ID_SEQ")
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "user_text")
    private String userText;
}
