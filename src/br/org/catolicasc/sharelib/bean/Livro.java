package br.org.catolicasc.sharelib.bean;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String editora;
	private Long isbnId;
	private String autor;
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public Livro() {}

	public Livro(Long id, String nome, String editora, Long isbnId, String autor, Genero genero) {
		setId(id);
		setNome(nome);
		setEditora(editora);
		setIsbnId(isbnId);
		setAutor(autor);
		setGenero(genero);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Long getIsbnId() {
		return isbnId;
	}

	public void setIsbnId(Long isbnId) {
		this.isbnId = isbnId;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
