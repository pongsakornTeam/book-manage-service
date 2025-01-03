package manage.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import manage.book.dao.Book;
import manage.book.request.SaveBookRequest;
import manage.book.response.BookResponse;
import manage.book.response.ServiceResponse;
import manage.book.service.BookService;


@RestController
@RequestMapping("api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/book")
	public ResponseEntity<ServiceResponse> getGetCar(){
		ServiceResponse response = new ServiceResponse();
		try {
			bookService.saveBook(null);
			List<BookResponse> bookResponseList = bookService.getAllBook();
			
			response.setResponse(bookResponseList);
			response.setErrorCode("001");
			response.setStatus("Success");
		}catch (Exception e) {
			System.out.println("controller error");
		}
		return ResponseEntity.ok(response);
	}
	
	
	
	@GetMapping("/books")
	public ResponseEntity<ServiceResponse> getFood2(@RequestParam String author){
		ServiceResponse response = new ServiceResponse(); 
		try {
			List<BookResponse> bookResponseList = bookService.getBookByAuthor(author);
			
			response.setResponse(bookResponseList);
			response.setErrorCode("001");
			response.setStatus("Success");
		}catch (Exception e) {
			System.out.println("error");
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "save-book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> searchDataDefault(@RequestBody SaveBookRequest saveBookRequest) {
		ServiceResponse response = null;
		try {
			response = new ServiceResponse();
			bookService.saveBook(saveBookRequest);
			response.setResponse(null);
			response.setStatus("Success");
			response.setErrorCode("");
		} catch (Exception e) {
			System.out.println("error");
		}
		return ResponseEntity.ok(response);
	}
	
}
