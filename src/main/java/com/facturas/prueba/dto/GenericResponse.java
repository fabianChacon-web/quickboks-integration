package com.facturas.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GenericResponse {
    private String code;
    private String message;
    @JsonIgnore
    private HttpStatus status;
}
