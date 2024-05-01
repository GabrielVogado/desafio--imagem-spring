package com.desafio.spring.desafioimagemspring.controller;

import com.desafio.spring.desafioimagemspring.entity.Image;
import com.desafio.spring.desafioimagemspring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.savedUploadImage(file);
        return ResponseEntity.ok("Image uploaded successfully");
    }
}
