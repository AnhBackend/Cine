package cinema.Service.ServiceImpl;

import cinema.DTO.Request.DeleteMovieRequest;
import cinema.DTO.Request.NewMovieRequest;
import cinema.DTO.Response.MessageResponse;
import cinema.DTO.Tuan3.RequestTuan3.SuaMovie_Request;
import cinema.Entity.*;
import cinema.Repository.*;
import cinema.Service.IMovieServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServicesImpl implements IMovieServices {

    private final MovieRepo movieRepo;

    private final RateRepo rateRepo;

    private final MovieTypeRepo movieTypeRepo;

    private final ScheduleRepo scheduleRepo;

    private final TicketRepo ticketRepo;

    private final BillTicketRepo billTicketRepo;

    @Override
    public List<Movie> getAllMovie() {
        return movieRepo.findAll();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieRepo.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + movieId));
    }


    @Override
    public MessageResponse addMovie(NewMovieRequest request) {
        Optional<Rate>rateOptional = rateRepo.findById(request.getRateId());
        Optional<MovieType>movieTypeOptional = movieTypeRepo.findById(request.getMovieTypeId());
        if (rateOptional.isEmpty()) {
            return MessageResponse.builder().message("Rate not found").build();
        }
        if (movieTypeOptional.isEmpty()) {
            return MessageResponse.builder().message("Movie type not found").build();
        }

        Movie movie = new Movie();
        movie.setMovieDuration(request.getMovieDuration());
        movie.setEndTime(request.getEndTime());
        movie.setPremiereDate(request.getPremiereDate());
        movie.setDescription(request.getDescription());
        movie.setDirector(request.getDirector());
        movie.setImage(request.getImage());
        movie.setHeroImage(request.getHeroImage());
        movie.setLanguage(request.getLanguage());

        MovieType movieType = movieTypeOptional.get();
        movie.setMovieType(movieType);

        movie.setName(request.getName());

        Rate rate = rateOptional.get();
        rate.setId(request.getRateId());
        movie.setRate(rate);

        movie.setTrailer(request.getTrailer());
        movie.setActive(request.isActive());
        movie.setTicketSoldQuantity(request.getTicketSoldedQuantity());

        movieRepo.save(movie);
        return MessageResponse.builder().message("Add new movie success").build();
    }

    @Override
    public Optional<Movie> updateMovie(int movieId, SuaMovie_Request suaMovie_request) {
        Optional<Movie> movie = movieRepo.findById(movieId);
        if (movie.isPresent()){
            Movie movie1 = new Movie();
            movie1.setMovieDuration(suaMovie_request.getMovieDuration());
            movie1.setEndTime(suaMovie_request.getEndTime());
            movie1.setPremiereDate(suaMovie_request.getPremiereDate());
            movie1.setDescription(suaMovie_request.getDescription());
            movie1.setDirector(suaMovie_request.getDirector());
            movie1.setImage(suaMovie_request.getImage());
            movie1.setLanguage(suaMovie_request.getLanguage());
            movie1.setHeroImage(suaMovie_request.getHeroImage());
            movie1.setName(suaMovie_request.getName());
            movie1.setTrailer(suaMovie_request.getTrailer());
            movie1.setMovieType(movieTypeRepo.findById(suaMovie_request.getMovieTypeId()).get());
            movie1.setRate(rateRepo.findById(suaMovie_request.getRateId()).get());
            return Optional.of(movieRepo.save(movie1));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteMovie(Integer movieId) throws Exception {
        Optional<Movie> movie = movieRepo.findById(movieId);
        if (movie.isPresent()){
            movieRepo.delete(movie.get());
        }
        else {
            throw new Exception("MovieId not found");
        }
    }

    @Override
    public List<Object[]> getTopMoviesByTicketSales(int limit) {
        return movieRepo.findTopMoviesWithTicketCount(limit);
    }

    @Override
    public List<Movie> getMoviesByCinemaRoomAndSeatStatus(int cinemaId, int roomId, int seatStatusId) {
        return scheduleRepo.findMoviesByCinemaRoomAndSeatStatus(cinemaId,roomId,seatStatusId);
    }

}
