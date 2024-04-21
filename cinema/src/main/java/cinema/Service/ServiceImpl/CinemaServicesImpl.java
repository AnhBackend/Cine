package cinema.Service.ServiceImpl;

import cinema.Entity.Cinema;
import cinema.Repository.CinemaRepo;
import cinema.Service.ICinemaServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServicesImpl implements ICinemaServices {
    @Autowired
    CinemaRepo cinemaRepo;
    @Override
    public List<Cinema> getAllCinema() {
        return cinemaRepo.findAll();
    }

    @Override
    public Cinema getCinemaById(int CinemaId) {
        return cinemaRepo.findById(CinemaId)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found with id: " + CinemaId));
    }
    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepo.save(cinema);
    }

    @Override
    public Optional<Cinema> updateCinema(int CinemaId, Cinema cinema) {
        Optional<Cinema> optionalCinema = cinemaRepo.findById(CinemaId);
        if (optionalCinema.isPresent()){
            Cinema cinema1 = optionalCinema.get();
            BeanUtils.copyProperties(cinema,cinema1,"id");
            return Optional.of(cinemaRepo.save(cinema1));
        }
        else return Optional.empty();
    }

    @Override
    public boolean deleteCinema(int CinemaId) {
        if (cinemaRepo.existsById(CinemaId)){
            cinemaRepo.deleteById(CinemaId);
            return true;
        }
        return false;
    }
}
