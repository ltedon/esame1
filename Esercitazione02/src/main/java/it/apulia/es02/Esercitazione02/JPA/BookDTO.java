package it.apulia.es02.Esercitazione02.JPA;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    @Size(min = 3, max = 500, message = "Titolo troppo corto!")
    String titolo;
    String autore;
    @Min(1000)
    Integer annoPB;
    String link;

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
