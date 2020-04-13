package com.picture.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.picture.entities.Profile;
import com.picture.services.I_ProfileSRV;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileCTR {
	@Autowired I_ProfileSRV pry;
	@Autowired ServletContext context;

	
	@PostMapping(value="/profiles", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file ,@RequestParam("user") String user) throws IOException,JsonParseException,JsonMappingException {
		Profile profile = new ObjectMapper().readValue(user, Profile.class);
		System.out.println(file);
  	  System.out.println("wach rak hna ");

		boolean isExist = new File(context.getRealPath("/userprofile/")).exists();
		if(!isExist) {
			new File(context.getRealPath("/userprofile/")).mkdir();
		}
		String filename = 	file.getOriginalFilename();
		System.out.println(filename);
		String modifierFileName = FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
		File serverfile = new File(context.getRealPath("/userprofile/"+File.separator+modifierFileName));
		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		profile.setPicture(modifierFileName.getBytes());
		profile.setGetpic("./picture/src/main/webapp/userprofile/"+modifierFileName);

		Profile pprofile = pry.save(profile);
      if(pprofile!=null) {
    	  System.out.println("raaaaaaaaaaaah khadmat");
  		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
  	

      }else {
    	  System.out.println("raaaaaaaaaaaah maaaaaa khadmat");

  		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.BAD_REQUEST);

       }

	}

}
