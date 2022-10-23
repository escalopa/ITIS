package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private Long trip_id;
    private Driver driver;
    private String trip_from;
    private String trip_to;
    private Integer trip_cost;
}
