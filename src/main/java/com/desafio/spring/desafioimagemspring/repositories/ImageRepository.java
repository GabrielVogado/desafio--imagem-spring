package com.desafio.spring.desafioimagemspring.repositories;

import com.desafio.spring.desafioimagemspring.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
