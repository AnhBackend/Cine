package cinema.Service;

import cinema.DTO.Tuan3.RequestTuan3.SuaRoom_Request;
import cinema.DTO.Tuan3.RoomDTO;
import cinema.Entity.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomServices {
    public List<Room> getAllRoom();
    public Room getRoomById(int roomId);
    public void addRoom(RoomDTO roomDTO);
    public Optional<Room> updateRoom(int roomId, SuaRoom_Request updateRoom);
    public void deleteRoom(Integer roomId) throws Exception;
}
