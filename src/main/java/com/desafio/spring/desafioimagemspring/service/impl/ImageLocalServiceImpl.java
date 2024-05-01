package com.desafio.spring.desafioimagemspring.service.impl;

import com.desafio.spring.desafioimagemspring.service.ImageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Profile("local")
public class ImageLocalServiceImpl implements ImageService {

    private static final String LOCAL_PATH = "C:/Users/Gabriel Vogado/Downloads/";


    /**
     * @param file
     */
    @Override
    public void savedUploadImage(MultipartFile file) {

        try {
            Path uploadPath = Paths.get(LOCAL_PATH);
            Files.copy(file.getInputStream(), uploadPath.resolve(Objects.requireNonNull(file.getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao Carregar imagem", e);
        }
    }

    /**
     * @param nameImage
     * @return
     */
    @Override
    public byte[] getDownloadImage(String nameImage) {
        try {
            Path imagePath = Paths.get(LOCAL_PATH).resolve(nameImage);
            return Files.readAllBytes(imagePath);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao Baixar o Arquivo de Imagem", e);
        }
    }
}
