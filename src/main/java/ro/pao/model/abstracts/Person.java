package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person extends AbstractEntity {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

}
