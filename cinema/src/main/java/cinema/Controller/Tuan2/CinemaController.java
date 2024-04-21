package cinema.Controller.Tuan2;

import cinema.Entity.Cinema;
import cinema.Service.ServiceImpl.CinemaServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/cinema")
@RequiredArgsConstructor
public class CinemaController {
    @Autowired
    CinemaServicesImpl cinemaServices;
    @GetMapping(value = "/getallcinema")
    public ResponseEntity<List<Cinema>> getAllCinema(){
        List<Cinema> cinemas = cinemaServices.getAllCinema();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }
    @RequestMapping(value = "getcinemabyid",method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaById(@RequestParam int cinemaId){
        Cinema cinema = cinemaServices.getCinemaById(cinemaId);
        return new ResponseEntity<>(cinema,HttpStatus.OK);
    }
    @PostMapping(value = "/addcinema")
    public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
        Cinema addedCinema = cinemaServices.addCinema(cinema);
        return new ResponseEntity<>(addedCinema, HttpStatus.CREATED);
    }
    @PutMapping("/updatecinema")
    public ResponseEntity<Optional<Cinema>> updateCinema(@RequestParam int cinemaId, @RequestBody Cinema updatedCinema) {
        Optional<Cinema> cinema = cinemaServices.updateCinema(cinemaId, updatedCinema);
        return new ResponseEntity<>(cinema,HttpStatus.OK);
    }
    @DeleteMapping("/deletecinema")
    public ResponseEntity<?> deleteCinema(@RequestParam int cinemaId) {
        boolean isDeleted = cinemaServices.deleteCinema(cinemaId);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa cinema thành công");
        } else {
            return ResponseEntity.ok("Xóa cinema thất bại");
        }
    }

}
