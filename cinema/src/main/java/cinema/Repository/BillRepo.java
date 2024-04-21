package cinema.Repository;

import cinema.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {
    @Query("SELECT NEW com.example.movie.dto.RevenueReport(b.cinema.name, SUM(b.totalAmount)) FROM Bill b WHERE b.cinema.id = :cinemaId AND b.createdAt BETWEEN :startDate AND :endDate GROUP BY b.cinema.name")
    List<Object[]> findTotalRevenueByCinemaAndDateRange(@Param("cinemaId") int cinemaId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
