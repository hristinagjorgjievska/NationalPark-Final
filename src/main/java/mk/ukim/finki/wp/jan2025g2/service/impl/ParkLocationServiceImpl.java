package mk.ukim.finki.wp.jan2025g2.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.jan2025g2.model.ParkLocation;
import mk.ukim.finki.wp.jan2025g2.model.exceptions.InvalidNationalParkIdException;
import mk.ukim.finki.wp.jan2025g2.repository.ParkLocationRepository;
import mk.ukim.finki.wp.jan2025g2.service.ParkLocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkLocationServiceImpl implements ParkLocationService {

    private final ParkLocationRepository parkLocationRepository;

    @Override
    public ParkLocation findById(Long id) {
        return parkLocationRepository.findById(id).orElseThrow(InvalidNationalParkIdException::new);
    }

    @Override
    public List<ParkLocation> listAll() {
        return parkLocationRepository.findAll();
    }

    @Override
    public ParkLocation create(String country, String continent) {
        ParkLocation parkLocation = new ParkLocation(country, continent);
        return parkLocationRepository.save(parkLocation);
    }
}
