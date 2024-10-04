package lt.ca.javau10.controllers;

import lt.ca.javau10.models.Advertisement;
import lt.ca.javau10.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementService adService;

    @GetMapping
    public List<Advertisement> getAllAds() {
        return adService.getAllAds();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public Advertisement postAd(@RequestBody Advertisement ad, Authentication authentication) {
        ad.setPostedBy(authentication.getName());
        return adService.postAd(ad);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
        return ResponseEntity.ok().build();
    }
}
