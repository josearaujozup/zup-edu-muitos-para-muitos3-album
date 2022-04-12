package br.com.zup.edu.album.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.album.model.Album;
import br.com.zup.edu.album.model.Imagem;
import br.com.zup.edu.album.repository.AlbumRepository;
import br.com.zup.edu.album.repository.ImagemRepository;

@RestController
public class ImagemController {
	
	private final AlbumRepository albumRepository;
	private final ImagemRepository repository;
	
	public ImagemController(AlbumRepository albumRepository, ImagemRepository repository) {
		this.albumRepository = albumRepository;
		this.repository = repository;
	}
	
	
	@Transactional
	@PostMapping("/albuns/{idAlbum}/imagens")
	ResponseEntity<?> cadastrar(@PathVariable Long idAlbum, @RequestBody @Valid ImagemDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Album album = albumRepository.findById(idAlbum).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de blog para o id informado"));
		
		Imagem imagem = request.toModel();
		
		repository.save(imagem);
		
		album.adicionar(imagem);
		
		albumRepository.save(album);
		
		URI location = uriComponentsBuilder.path("/albuns/{idAlbum}/imagens/{id}").buildAndExpand(album.getId(),imagem.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
