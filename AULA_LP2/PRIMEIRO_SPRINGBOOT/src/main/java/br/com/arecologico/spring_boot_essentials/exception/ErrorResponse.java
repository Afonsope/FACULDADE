package br.com.arecologico.spring_boot_essentials.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    
    private String message;
    private Integer status;
}
