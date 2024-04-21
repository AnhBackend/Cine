package cinema.Controller.Tuan2;

import cinema.DTO.Tuan3.RequestTuan3.SuaRoom_Request;
import cinema.DTO.Tuan3.RoomDTO;
import cinema.Entity.Room;
import cinema.Service.ServiceImpl.RoomServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/room")
@RequiredArgsConstructor

public class RoomController {
    @Autowired
    RoomServicesImpl roomServices;
    @GetMapping(value = "/getallroom")
    public List<Room> getAllRoom(){
        return roomServices.getAllRoom();
    }
    @RequestMapping(value = "getroombyid",method = RequestMethod.GET)
    public ResponseEntity<Room> getRoomById(@RequestParam int roomId){
        Room room = roomServices.getRoomById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    @RequestMapping(value = "/addroom",method = RequestMethod.POST)
    public ResponseEntity<?> addRoom(@RequestBody RoomDTO roomDTO){
        try {
            roomServices.addRoom(roomDTO);
            return ResponseEntity.ok("thêm room thành công.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updateroom")
    public ResponseEntity<Optional<Room>> updateRoom(@RequestParam Integer roomid, @RequestBody SuaRoom_Request updatedRoom) {
        Optional<Room> room = roomServices.updateRoom(roomid, updatedRoom);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteroom")
    public ResponseEntity<?> deleteRoom(@RequestParam Integer roomid) throws Exception {
        try {
            roomServices.deleteRoom(roomid);
            return ResponseEntity.ok().body("Xóa thành công");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
