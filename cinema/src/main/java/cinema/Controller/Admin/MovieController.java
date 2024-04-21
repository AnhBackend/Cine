package cinema.Controller.Admin;

import cinema.DTO.Request.NewMovieRequest;
import cinema.DTO.Response.MessageResponse;
import cinema.DTO.Tuan3.RequestTuan3.SuaMovie_Request;
import cinema.Entity.Movie;
import cinema.Service.ServiceImpl.MovieServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/admin")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServicesImpl movieServices;
    @PostMapping("addnewmovie")
    public ResponseEntity<MessageResponse> addNewMovie(@RequestBody NewMovieRequest request){
        return new ResponseEntity<>(movieServices.addMovie(request), HttpStatus.OK);
    }
    @GetMapping(value = "/getallmovie")
    public List<Movie> getAllMovie(){
        return movieServices.getAllMovie();
    }
    @RequestMapping(value = "getmoviebyid",method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@RequestParam int movieId){
        Movie movie = movieServices.getMovieById(movieId);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @PutMapping("/updatemovie")
    public ResponseEntity<Optional<Movie>> updateMovie(@RequestParam Integer movieid, @RequestBody SuaMovie_Request suaMovie_request) {
        Optional<Movie> movie = movieServices.updateMovie(movieid, suaMovie_request);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletemovie")
    public ResponseEntity<?> deleteMovie(@RequestParam Integer movieid) throws Exception {
        try {
            movieServices.deleteMovie(movieid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping(value = "/top")
    public List<Object[]> getTopMoviesByTicketSales(@RequestParam int limit){
        return movieServices.getTopMoviesByTicketSales(limit);
    }
    @GetMapping("/by-cinema-room-seat-status")
    public ResponseEntity<List<Movie>> getMoviesByCinemaRoomAndSeatStatus(@RequestParam int cinemaId,
                                                                          @RequestParam int roomId,
                                                                          @RequestParam int seatStatusId){
        List<Movie> movies = movieServices.getMoviesByCinemaRoomAndSeatStatus(cinemaId,roomId,seatStatusId);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
