package br.com.zup.edu.album.controller;

import javax.validation.constraints.NotBlank;

import br.com.zup.edu.album.model.Album;

public class AlbumDTO {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;

	public AlbumDTO(@NotBlank String titulo, @NotBlank String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public AlbumDTO() {
		
	}
	
	public Album toModel() {
		return new Album(titulo, descricao);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
