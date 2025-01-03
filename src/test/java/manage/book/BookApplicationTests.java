package manage.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import manage.book.request.SaveBookRequest;
import manage.book.response.ServiceResponse;

@ContextConfiguration(classes = BookApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void testSaveBook() {
		SaveBookRequest saveRequest = new SaveBookRequest();
		saveRequest.setTitle("Title1");
		saveRequest.setAuthor("Author1");
		saveRequest.setPublishedDate("21/03/2567");
		ServiceResponse response = restTemplate.postForObject("/api/save-book", saveRequest, ServiceResponse.class);
		assertEquals("Success", response.getStatus());
	}
	
	
	@Test
	public void testGetBookByAuthor() {
		ServiceResponse response = restTemplate.getForObject("/api/books?author=Author1", ServiceResponse.class);
		assertEquals("Success", response.getStatus());
	}
	
	
}
