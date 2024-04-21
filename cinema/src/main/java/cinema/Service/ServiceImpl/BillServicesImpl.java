package cinema.Service.ServiceImpl;

import cinema.DTO.Tuan3.RevenueReportDTO;
import cinema.Repository.BillRepo;
import cinema.Repository.CinemaRepo;
import cinema.Service.IBillServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
    public class BillServicesImpl implements IBillServices {
    @Autowired
    BillRepo billRepo;
    @Autowired
    CinemaRepo cinemaRepo;

    @Override
    public List<RevenueReportDTO> getRevenueReportByCinemaAndDateRange(int cinemaId, LocalDate startDate, LocalDate endDate) {
        List<Object[]> result = billRepo.findTotalRevenueByCinemaAndDateRange(cinemaId, startDate, endDate);
        List<RevenueReportDTO> revenueReportDTOS = new ArrayList<>();
        for (Object[] row:result){
            String cinemaName = (String) row[0];
            Double totalRevenue = (Double) row[1];
            RevenueReportDTO reportDTO = new RevenueReportDTO();
            reportDTO.setCinemaName(cinemaName);
            reportDTO.setTotalRevenue(totalRevenue != null ? totalRevenue : 0.0);
            revenueReportDTOS.add(reportDTO);
        }
        return revenueReportDTOS;
    }
}
