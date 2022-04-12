package br.com.zup.edu.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.album.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
