package br.com.zup.edu.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.album.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long>{

}
