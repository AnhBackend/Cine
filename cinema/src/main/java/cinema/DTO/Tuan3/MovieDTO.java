package cinema.DTO.Tuan3;

import cinema.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
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
    private boolean IsActive;
    public static MovieDTO fromEntity(Movie movie){
        return new MovieDTO(
                movie.getMovieDuration(),
                movie.getEndTime(),
                movie.getPremiereDate(),
                movie.getDescription(),
                movie.getDirector(),
                movie.getImage(),
                movie.getLanguage(),
                movie.getHeroImage(),
                movie.getName(),
                movie.getTrailer(),
                movie.isActive()
        );
    }
}
