package cinema.Repository;

import cinema.DTO.Response.ListMovieReponse;
import cinema.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

    @Query("SELECT new cinema.DTO.Response.ListMovieReponse" +
            "(m.id, m.movieDuration, m.endTime, m.premiereDate, m.description, m.director, m.image, m.heroImage, m.language, t.movieTypeName, m.name, m.rateId, m.trailer, m.isActive, m.ticketSoldQuantity)" +
            "FROM Movie m JOIN MovieType t ON m.movieTypeId = t.id " +
            "ORDER BY m.ticketSoldQuantity DESC")
    Page<ListMovieReponse>findAllMovie(Pageable pageable);
    @Query("SELECT m, COUNT(t) FROM Movie m LEFT JOIN m.scheduleList s LEFT JOIN s.ticketList t GROUP BY m ORDER BY COUNT(t) DESC")
    List<Object[]> findTopMoviesWithTicketCount(int pageable);
}
