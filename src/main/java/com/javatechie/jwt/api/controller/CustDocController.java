package com.javatechie.jwt.api.controller;



import java.io.File
;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javatechie.jwt.api.entity.CustDocModel;
import com.javatechie.jwt.api.repository.CustDocRepo;
import com.javatechie.jwt.api.service.CustDocService;

import org.springframework.http.MediaType;


@RestController
@RequestMapping("/custdoc")
public class CustDocController {
	
	@Autowired
    private CustDocRepo imageRepo;
	
	@Autowired
	private CustDocService productImageService;
	
	private final String PATH = "C:\\workspace\\";//,@RequestParam String cid
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/upload/{cid}")
	public CustDocModel uploadImage(@RequestParam("productImage")MultipartFile file , @PathVariable String cid ) throws IOException {
		String fullPath = PATH+file.getOriginalFilename();
		CustDocModel pImage = new CustDocModel();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImagePath(fullPath);
		pImage.setCustId(cid);
		
		
		file.transferTo(new File(fullPath));
		return imageRepo.save(pImage);
	}
	
	

	
//	@GetMapping("/download/{fileName}")
//	public ResponseEntity<byte[]> downloadImage(@PathVariable int fileName) throws IOException {
//		byte[] image = productImageService.downloadImage( fileName);
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//	}

}

