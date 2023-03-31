package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class AbstractEntity {

    @Builder.Default
    protected UUID  id = UUID.randomUUID();

    @Builder.Default
    protected LocalDate creationDate = LocalDate.now();

    protected LocalDate updateDate;

    protected LocalDate deleteDate;
}