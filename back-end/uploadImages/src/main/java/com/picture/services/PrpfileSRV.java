package com.picture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picture.entities.Profile;
import com.picture.repository.ProfileRepository;

@Service
public class PrpfileSRV implements I_ProfileSRV{
	@Autowired ProfileRepository pry;
	
	public Profile save(Profile profile) {
		pry.save(profile);
		return profile;
	}	
}
