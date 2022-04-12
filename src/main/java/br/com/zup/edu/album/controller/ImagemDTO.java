package br.com.zup.edu.album.controller;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.album.model.Imagem;

public class ImagemDTO {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String link;
	
	@PastOrPresent
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@NotNull
	private LocalDateTime momentoCadastro;

	public ImagemDTO(@NotBlank String titulo, @NotBlank String descricao, @NotBlank String link,
			@PastOrPresent @NotNull LocalDateTime momentoCadastro) {
//		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.link = link;
		this.momentoCadastro = momentoCadastro;
	}
	
	public ImagemDTO() {
		
	}
	
	public Imagem toModel() {
		return new Imagem(titulo, descricao, link, momentoCadastro);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLink() {
		return link;
	}

	public LocalDateTime getMomentoCadastro() {
		return momentoCadastro;
	}
	
}
