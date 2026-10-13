package com.stylecumpx.service;

import com.stylecumpx.model.Profile;
import com.stylecumpx.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile saveOrUpdateProfile(Profile profile) {
        Optional<Profile> existing = profileRepository.findByUserId(profile.getUser().getId());
        if (existing.isPresent()) {
            Profile current = existing.get();
            current.setFullName(profile.getFullName());
            current.setDepartment(profile.getDepartment());
            current.setCourse(profile.getCourse());
            current.setYear(profile.getYear());
            current.setStylePreference(profile.getStylePreference());
            current.setFavoriteColors(profile.getFavoriteColors());
            return profileRepository.save(current);
        }
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId);
    }
}