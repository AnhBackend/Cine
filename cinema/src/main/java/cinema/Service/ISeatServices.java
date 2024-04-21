package cinema.Service;


import cinema.DTO.Tuan3.RequestTuan3.SuaSeat_Request;
import cinema.DTO.Tuan3.SeatDTO;
import cinema.Entity.Seat;

import java.util.List;
import java.util.Optional;

public interface ISeatServices {
    public List<Seat> getAllSeat();
    public Seat getSeatById(int seatId);
    public void addSeat(SeatDTO seatDTO);
    public Optional<Seat> updateSeat(int seatId, SuaSeat_Request updateSeat);
    public void deleteSeat(Integer seatId) throws Exception;
}
