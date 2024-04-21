package cinema.Controller.Tuan2;

import cinema.DTO.Tuan3.RequestTuan3.SuaSeat_Request;
import cinema.DTO.Tuan3.SeatDTO;
import cinema.Entity.Seat;
import cinema.Service.ServiceImpl.SeatServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/seat")
@RequiredArgsConstructor
public class SeatController {
    @Autowired
    SeatServicesImpl seatServices;
    @GetMapping(value = "/getallseat")
    public List<Seat> getAllSeat(){
        return seatServices.getAllSeat();
    }
    @RequestMapping(value = "getseatbyid",method = RequestMethod.GET)
    public ResponseEntity<Seat> getSeatById(@RequestParam int seatId){
        Seat seat = seatServices.getSeatById(seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
    @RequestMapping(value = "/themseat",method = RequestMethod.POST)
    public ResponseEntity<?> addSeat(@RequestBody SeatDTO seatDTO){
        try {
            seatServices.addSeat(seatDTO);
            return ResponseEntity.ok("thêm seat thành công.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updateseat")
    public ResponseEntity<Optional<Seat>> updateSeat(@RequestParam Integer seatid, @RequestBody SuaSeat_Request updatedSeat) {
        Optional<Seat> seat = seatServices.updateSeat(seatid, updatedSeat);
        return new ResponseEntity<>(seat,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteseat")
    public ResponseEntity<?> deleteSeat(@RequestParam Integer seatid) throws Exception {
        try {
            seatServices.deleteSeat(seatid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
