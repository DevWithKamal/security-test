package com.javatechie.jwt.api.service;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.entity.CustDocModel;
import com.javatechie.jwt.api.repository.CustDocRepo;


@Service
public class CustDocService {

	@Autowired
    private CustDocRepo imageRepo;
	public byte[] downloadImage(String fileName) throws IOException{
        Optional<CustDocModel> imageObject = imageRepo.findByCustId(fileName);
        String fullPath = imageObject.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());
    }

}

