package cinema.DTO.Tuan3.RequestTuan3;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuaMovie_Request {
    private int MovieDuration;
    private Date EndTime;
    private Date PremiereDate;
    private String Description;
    private String Director;
    private String Image;
    private String Language;
    private String HeroImage;
    private String Name;
    private String Trailer;
    private Integer movieTypeId;
    private Integer rateId;
}
