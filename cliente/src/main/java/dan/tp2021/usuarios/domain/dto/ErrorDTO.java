package dan.tp2021.usuarios.domain.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String message;

}
