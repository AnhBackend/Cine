package cinema.Service.ServiceImpl;

import cinema.DTO.Response.ListMovieReponse;
import cinema.Repository.MovieRepo;
import cinema.Service.IUnAuthServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UnAuthServicesImpl implements IUnAuthServices {

    private final MovieRepo movieRepo;

    @Override
    public List<ListMovieReponse> listMovie(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ListMovieReponse> moviePage = movieRepo.findAllMovie(pageable);
        return moviePage.getContent();
    }
}
