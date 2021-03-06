package edu.ufrn.pds.healthsystem.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BoardForm {
    private Long id_admin;
    private String name;
    private LocalDate date_end;
}
