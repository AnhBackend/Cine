package cinema.Controller.UnAuth;

import cinema.DTO.Response.ListMovieReponse;
import cinema.Service.ServiceImpl.UnAuthServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/unauth")
@RequiredArgsConstructor
public class UnAuthController {
    private final UnAuthServicesImpl unAuthServices;

    @GetMapping("/displayhighratemovie")
    public ResponseEntity<List<ListMovieReponse>> listMovie(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize
    ){
        return new ResponseEntity<>(unAuthServices.listMovie(pageNumber, pageSize), HttpStatus.OK);
    }
}
