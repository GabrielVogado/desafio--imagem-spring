package com.desafio.spring.desafioimagemspring.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    void savedUploadImage(MultipartFile file) throws IOException;

    byte[] getDownloadImage(String nameImage);
}
