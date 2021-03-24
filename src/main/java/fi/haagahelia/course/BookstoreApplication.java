package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;



@SpringBootApplication 
@EnableJpaRepositories(basePackageClasses = BookRepository.class)
public class BookstoreApplication { 
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	} 
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catrepo, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			catrepo.save(new Category("Tietokirja"));  
			catrepo.save(new Category("Fantasia"));
			
			repository.save(new Book(1L, "Sapiens: Ihmisen lyhyt historia", "Harari", 2017, "978-3-16-148410-0", 24.99,  
				catrepo.findByName("Tietokirja").get(0)));
			repository.save(new Book(2L, "Sapiens: Huomisen lyhyt historia", "Harari", 2019, "978-3-16-148410-1", 29.55, 
				catrepo.findByName("Tietokirja").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
