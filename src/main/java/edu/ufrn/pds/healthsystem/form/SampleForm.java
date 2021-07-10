package edu.ufrn.pds.healthsystem.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SampleForm {
    @NotBlank
    private String nome;
    @Min(18)
    private Integer idade;
}
