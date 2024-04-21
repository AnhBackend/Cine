package cinema.Repository;

import cinema.Entity.Movie;
import cinema.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
    @Query("SELECT DISTINCT s.movie FROM Schedule s JOIN s.room1 r JOIN r.seatList seat JOIN seat.seatStatus seatStatus WHERE r.cinema.Id = :cinemaId AND r.Id = :roomId AND seatStatus.Id = :seatStatusId")
    List<Movie> findMoviesByCinemaRoomAndSeatStatus(@Param("cinemaId") int cinemaId, @Param("roomId") int roomId, @Param("seatStatusId") int seatStatusId);
}
