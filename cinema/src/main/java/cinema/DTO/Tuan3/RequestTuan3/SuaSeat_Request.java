package cinema.DTO.Tuan3.RequestTuan3;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuaSeat_Request {
    private int Number;
    private String Line;
    private Integer SeatStatusId;
    private Integer RoomId;
    private Integer SeatTypeId;
}
