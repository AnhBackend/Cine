package cinema.Service.ServiceImpl;

import cinema.DTO.Tuan3.RequestTuan3.SuaSeat_Request;
import cinema.DTO.Tuan3.SeatDTO;
import cinema.Entity.Seat;
import cinema.Repository.RoomRepo;
import cinema.Repository.SeatRepo;
import cinema.Repository.SeatStatusRepo;
import cinema.Repository.SeatTypeRepo;
import cinema.Service.ISeatServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatServicesImpl implements ISeatServices {
    @Autowired
    SeatRepo seatRepo;
    @Autowired
    SeatStatusRepo seatStatusRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    SeatTypeRepo seatTypeRepo;

    @Override
    public List<Seat> getAllSeat() {
        return seatRepo.findAll();
    }

    @Override
    public Seat getSeatById(int seatId) {
        return seatRepo.findById(seatId)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + seatId));
    }

    @Override
    public void addSeat(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setNumber(seatDTO.getNumber());
        seat.setLine(seatDTO.getLine());
        seat.setActive(true);
        seat.setSeatStatus(seatStatusRepo.findById(1).get());
        seat.setSeatType(seatTypeRepo.findById(1).get());
        seat.setRoom(roomRepo.findById(6).get());
        seatRepo.save(seat);
    }

    @Override
    public Optional<Seat> updateSeat(int seatId, SuaSeat_Request updateSeat) {
        Optional<Seat> seat = seatRepo.findById(seatId);
        if (seat.isPresent()){
            Seat seat1 = new Seat();
            seat1.setNumber(updateSeat.getNumber());
            seat1.setLine(updateSeat.getLine());
            seat1.setSeatStatus(seatStatusRepo.findById(updateSeat.getSeatStatusId()).get());
            seat1.setSeatType(seatTypeRepo.findById(updateSeat.getSeatTypeId()).get());
            seat1.setRoom(roomRepo.findById(updateSeat.getRoomId()).get());
            return Optional.of(seatRepo.save(seat1));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteSeat(Integer seatId) throws Exception {
        Optional<Seat> seat = seatRepo.findById(seatId);
        if (seat.isPresent()){
            seatRepo.delete(seat.get());
        }
        else {
            throw new Exception("SeatId not found");
        }
    }
}
