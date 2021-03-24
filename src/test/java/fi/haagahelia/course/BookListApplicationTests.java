package fi.haagahelia.course;



import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookListApplicationTests { 
	
	@Autowired  
	private BookController bcont; 
	

	@Test
	public void contextLoads() throws Exception { 
		assertThat(bcont).isNotNull();
	}

}
