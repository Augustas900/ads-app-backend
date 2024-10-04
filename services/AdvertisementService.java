package lt.ca.javau10.services;

import lt.ca.javau10.models.Advertisement;
import lt.ca.javau10.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository adRepo;

    public List<Advertisement> getAllAds() {
        return adRepo.findAllByOrderByPostedAtDesc();
    }

    public Advertisement postAd(Advertisement ad) {
        ad.setPostedAt(LocalDateTime.now());
        return adRepo.save(ad);
    }

    public void deleteAd(Long id) {
        adRepo.deleteById(id);
    }
}
