package cinema.Service;

import cinema.DTO.Tuan3.RevenueReportDTO;

import java.time.LocalDate;
import java.util.List;

public interface IBillServices {
    public List<RevenueReportDTO> getRevenueReportByCinemaAndDateRange(int cinemaId, LocalDate startDate, LocalDate endDate);
}
