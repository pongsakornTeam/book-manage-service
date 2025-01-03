package manage.book.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.book.dao.Book;
import manage.book.repository.BookRepository;
import manage.book.request.SaveBookRequest;
import manage.book.response.BookResponse;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookResponse> getAllBook(){
		System.out.println("Find all book");
		List<BookResponse> result = new ArrayList<BookResponse>();
		try {
			List<Book> bookList = new ArrayList<Book>();
			bookList = bookRepository.findAll();
			for(Book bookItem : bookList) {
				BookResponse bookResponse = new BookResponse();
				bookResponse.setId(String.valueOf(bookItem.getId()));
				bookResponse.setTitle(bookItem.getTitle());
				bookResponse.setAuthor(bookItem.getAuthor());
				bookResponse.setPublishedDate(dateToString(bookItem.getPublishedDate()));
				result.add(bookResponse);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<BookResponse> getBookByAuthor(String author){
		System.out.println("Find by author");
		List<BookResponse> result = new ArrayList<BookResponse>();
		try {
			List<Book> bookList = new ArrayList<Book>();
			bookList = bookRepository.getBookFormAuthor(author);
			for(Book bookItem : bookList) {
				BookResponse bookResponse = new BookResponse();
				bookResponse.setId(String.valueOf(bookItem.getId()));
				bookResponse.setTitle(bookItem.getTitle());
				bookResponse.setAuthor(bookItem.getAuthor());
				bookResponse.setPublishedDate(dateToString(bookItem.getPublishedDate()));
				result.add(bookResponse);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
	
	public boolean saveBook(SaveBookRequest input) {
		System.out.println("Save Book");
		try {
			Book testSave = new Book();
			testSave.setTitle(input.getTitle());
			testSave.setAuthor(input.getAuthor());
			testSave.setPublishedDate(stringToDate(input.getPublishedDate()));
			bookRepository.save(testSave);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private String dateToString(Date input) {
		String strDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			int yeartemp = input.getYear();
			strDate = formatter.format(input);
		} catch (Exception e) {
			System.out.println("date to string error");
		}
		return strDate;
	}
	
	private Date stringToDate(String input) {
		Date date = new Date();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 date = formatter.parse(input);
		}catch (Exception e) {
			System.out.println("string to date error");
		}
		return date;
	}
}
