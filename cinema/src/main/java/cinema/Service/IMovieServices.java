package cinema.Service;

import cinema.DTO.Request.DeleteMovieRequest;
import cinema.DTO.Request.NewMovieRequest;
import cinema.DTO.Response.MessageResponse;
import cinema.DTO.Tuan3.RequestTuan3.SuaMovie_Request;
import cinema.Entity.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieServices {
    public List<Movie> getAllMovie();
    public Movie getMovieById(int movieId);
    public Optional<Movie> updateMovie(int movieId, SuaMovie_Request suaMovie_request)
    public MessageResponse addMovie(NewMovieRequest request);
    public void deleteMovie(Integer movieId) throws Exception;
    public List<Object[]> getTopMoviesByTicketSales(int limit);
    public List<Movie> getMoviesByCinemaRoomAndSeatStatus(int cinemaId, int roomId, int seatStatusId);
}
