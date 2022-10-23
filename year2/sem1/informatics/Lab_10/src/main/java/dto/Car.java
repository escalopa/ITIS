package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private Long car_id;
    private String model_name;
}
