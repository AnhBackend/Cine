package cinema.Service;

import cinema.DTO.Response.ListMovieReponse;
import cinema.DTO.Response.MessageResponse;

import java.util.List;

public interface IUnAuthServices {
    public List<ListMovieReponse> listMovie(Integer pageNumber, Integer pageSize);
}
