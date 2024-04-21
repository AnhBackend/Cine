package cinema.DTO.Tuan3;

import cinema.Entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private int Number;
    private String Line;
    private boolean IsActive;
    public static SeatDTO fromEntity(Seat seat){
        return new SeatDTO(
                seat.getNumber(),
                seat.getLine(),
                seat.isActive()
        );
    }
}
