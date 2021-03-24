package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest { 
	
	@Autowired
    private BookRepository repository;

  /* @Test
    public void findAll() {
        List<Book> books = repository.findAll()
        
        
        assertThat(books).hasSize(2);
    }*/
    
    @Test
    public void createNewBook() {
    	Book book = new Book(3L, "Sapiens: Kenen historia?", "Mish", 2021, "978-3-16-148410-10", 29.99, new Category("Hupi"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}
