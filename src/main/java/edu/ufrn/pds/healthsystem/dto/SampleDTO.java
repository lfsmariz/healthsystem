package edu.ufrn.pds.healthsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDTO {
    private String nome;
    private Integer idade;
}
