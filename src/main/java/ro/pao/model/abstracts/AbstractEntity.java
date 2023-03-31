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

    protected UUID id;

    protected LocalDate creationDate;

    protected LocalDate updateDate;

    protected LocalDate deleteDate;
}