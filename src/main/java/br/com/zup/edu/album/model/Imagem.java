package br.com.zup.edu.album.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private LocalDateTime momentoCadastro;

	public Imagem(String titulo, String descricao, String link, LocalDateTime momentoCadastro) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.link = link;
		this.momentoCadastro = momentoCadastro;
	}
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Imagem() {
		
	}

	public Long getId() {
		return id;
	}
	
}
