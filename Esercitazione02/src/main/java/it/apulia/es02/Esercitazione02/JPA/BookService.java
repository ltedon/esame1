package it.apulia.es02.Esercitazione02.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;

	}

	public List<Book> verificaTitolo(RicercaDTO titolo) {

		List<Book> tmp = new ArrayList<Book>(this.bookRepository.findBookByTitle(titolo.getTitolo()));

		return tmp;
	}


	public void saveBook(BookDTO libro) {

		Book temp = new Book(libro.titolo, libro.autore, libro.annoPB, libro.link);
		this.bookRepository.save(temp);

	}


	public List<Book> getAllBooks(){

		return new ArrayList(this.bookRepository.findAll());
	}



}
