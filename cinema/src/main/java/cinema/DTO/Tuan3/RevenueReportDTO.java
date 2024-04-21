package cinema.DTO.Tuan3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RevenueReportDTO {
    private String cinemaName;
    private double totalRevenue;
}
