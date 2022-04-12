package br.com.zup.edu.album.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	private LocalDateTime criadoEm=LocalDateTime.now();
	
	@Column(nullable = false)
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "album_imagem", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "imagem_id"))
    private Set<Imagem> imagens = new HashSet<>();
	
	public Album(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Album() {
		
	}


	public Long getId() {
		return id;
	}


	public void adicionar(Imagem imagem) {
		this.imagens.add(imagem);
	}
	
}
