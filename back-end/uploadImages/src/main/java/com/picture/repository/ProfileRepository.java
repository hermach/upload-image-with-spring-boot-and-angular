package com.picture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picture.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
