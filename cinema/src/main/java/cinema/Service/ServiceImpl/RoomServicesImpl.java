package cinema.Service.ServiceImpl;

import cinema.DTO.Tuan3.RequestTuan3.SuaRoom_Request;
import cinema.DTO.Tuan3.RoomDTO;
import cinema.Entity.Cinema;
import cinema.Entity.Room;
import cinema.Repository.*;
import cinema.Service.IRoomServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoomServicesImpl implements IRoomServices {
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    CinemaRepo cinemaRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    SeatRepo seatRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    BillTicketRepo billTicketRepo;

    @Override
    public List<Room> getAllRoom() {
        return roomRepo.findAll();
    }

    @Override
    public void addRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setCapacity(roomDTO.getCapacity());
        room.setType(roomDTO.getType());
        room.setDescription(roomDTO.getDescription());
        room.setCode(roomDTO.getCode());
        room.setName(roomDTO.getName());
        room.setActive(true);
        room.setCinema(cinemaRepo.findById(3).get());
        roomRepo.save(room);
    }
    private void checkCinemaId(int cinemaId){
        Optional<Cinema> cinema = cinemaRepo.findById(cinemaId);
        if (cinema.isEmpty()){
            System.out.println("Cinema id"+cinemaId+" không tồn tại.");
        }
    }

    @Override
    public Room getRoomById(int roomId) {
        return roomRepo.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id: " + roomId));
    }

    @Override
    public Optional<Room> updateRoom(int roomId, SuaRoom_Request updateRoom) {
        Optional<Room> optionalRoom = roomRepo.findById(roomId);
        if (optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            room.setCapacity(updateRoom.getCapacity());
            room.setType(updateRoom.getType());
            room.setDescription(updateRoom.getDescription());
            room.setName(updateRoom.getName());
            room.setCode(updateRoom.getCode());
            room.setCinema(cinemaRepo.findById(updateRoom.getCinemaId()).get());
            return Optional.of(roomRepo.save(room));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteRoom(Integer roomId) throws Exception {
        Optional<Room> room = roomRepo.findById(roomId);
        if (room.isPresent()){
            roomRepo.delete(room.get());
        }
        else {
            throw new Exception("RoomId not found");
        }
    }
}
