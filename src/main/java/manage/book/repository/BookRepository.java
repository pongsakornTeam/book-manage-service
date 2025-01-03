package manage.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import manage.book.dao.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query(value = "SELECT * FROM book where author = ?1", nativeQuery = true)
	public List<Book> getBookFormAuthor(String author);
}
