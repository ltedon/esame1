package it.apulia.es02.Esercitazione02.JPA;

import lombok.Data;

import javax.persistence.*;
//
// Da inserire l'annotation @Data ??
@Entity
@Table(name = "book")
public class Book {

	@Id
	@SequenceGenerator(
			name = "book_sequence",
			sequenceName = "book_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "book_sequence"
	)

	Long bookId;
	String titolo;
	String autore;
	Integer annoPB;
	String link;


	public Book(Long bookId, String titolo, String autore, Integer annoPB, String link) {
		this.titolo = titolo;
		this.autore = autore;
		this.annoPB = annoPB;
		this.link = link;
	}

	public Book(String titolo, String autore, Integer annoPB, String link) {
		this.titolo = titolo;
		this.autore = autore;
		this.annoPB = annoPB;
		this.link = link;
	}

	public Book(){

	}

	public Book(String titolo) {
		this.titolo = titolo;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Integer getAnnoPB() {
		return annoPB;
	}

	public void setAnnoPB(Integer annoPB) {
		this.annoPB = annoPB;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
