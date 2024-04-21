package cinema.Controller.Tuan4;

import cinema.DTO.Tuan3.RevenueReportDTO;
import cinema.Service.ServiceImpl.BillServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/bill")
@RequiredArgsConstructor
public class BillController {
    @Autowired
    BillServicesImpl billServices;
    @GetMapping("/revenue-by-cinema")
    public ResponseEntity<List<RevenueReportDTO>> getRevenueReportByCinemaAndDateRange(
            @RequestParam int cinemaId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        List<RevenueReportDTO> revenueReports = billServices.getRevenueReportByCinemaAndDateRange(cinemaId, startDate, endDate);
        return new ResponseEntity<>(revenueReports, HttpStatus.OK);
    }
}
