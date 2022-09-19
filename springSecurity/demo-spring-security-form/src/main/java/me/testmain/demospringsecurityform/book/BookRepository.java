package me.testmain.demospringsecurityform.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book, Long>{
	
	/*
	 * spring security 에서 principal 객체를 참조할 수 있게 제공한다.
	 * 여기서 principal 객체는 UserDetailsService 에서 return 하는 객체이다. 
	 * */
	@Query("select b from Book b where b.author.id = ?#{principal.account.id}")
	List<Book> findCurrentUserBook();
	
}
