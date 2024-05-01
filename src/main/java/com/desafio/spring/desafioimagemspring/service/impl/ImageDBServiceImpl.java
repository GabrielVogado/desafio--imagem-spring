package com.desafio.spring.desafioimagemspring.service.impl;

import com.desafio.spring.desafioimagemspring.entity.Image;
import com.desafio.spring.desafioimagemspring.repositories.ImageRepository;
import com.desafio.spring.desafioimagemspring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


@Service
@Profile("!local")
public class ImageDBServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageDBServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    /**
     * @param file
     */
    @Override
    public void savedUploadImage(MultipartFile file) {

        try {
            Image imageEntity = Image.builder().imageBase64(Base64.getEncoder().encodeToString(file.getBytes())).imageName(file.getOriginalFilename()).build();
            imageRepository.save(imageEntity);
        } catch (IOException e) {
            throw new RuntimeException("Falha Ao Carregar a Imagem", e);
        }

    }

    /**
     * @param nameImage
     * @return
     */
    @Override
    public byte[] getDownloadImage(String nameImage) {
        Image imageEntity = imageRepository.findImageByImageName(nameImage);
        if (imageEntity == null) {
            throw new RuntimeException("Imagen Não Encontrada");
        }
        return Base64.getDecoder().decode(imageEntity.getImageBase64());
    }
}
