package cinema.Service;

import cinema.Entity.Cinema;

import java.util.List;
import java.util.Optional;

public interface ICinemaServices {
    public List<Cinema> getAllCinema();
    public Cinema getCinemaById(int CinemaId);
    public Cinema addCinema(Cinema cinema);
    public Optional<Cinema> updateCinema(int CinemaId,Cinema cinema);
    public boolean deleteCinema(int CinemaId);
}
