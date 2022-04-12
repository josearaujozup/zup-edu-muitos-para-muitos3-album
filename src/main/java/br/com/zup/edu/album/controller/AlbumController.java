package br.com.zup.edu.album.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.album.model.Album;
import br.com.zup.edu.album.repository.AlbumRepository;

@RestController
@RequestMapping("/albuns")
public class AlbumController {
	
	private final AlbumRepository repository;
	
	public AlbumController(AlbumRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	ResponseEntity<Void> cadastrar(@RequestBody @Valid AlbumDTO request, UriComponentsBuilder uriComponentsBuilder){
		Album album = request.toModel();
		
		repository.save(album);
		URI location = uriComponentsBuilder.path("/albuns/{id}").buildAndExpand(album.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
