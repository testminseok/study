package me.testmain.demospringsecurityform.common;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import me.testmain.demospringsecurityform.account.Account;
import me.testmain.demospringsecurityform.account.AccountService;
import me.testmain.demospringsecurityform.book.Book;
import me.testmain.demospringsecurityform.book.BookRepository;

@Component
public class DefaultDataGenerator implements ApplicationRunner{
	
	private final AccountService accountService;
	
	private final BookRepository bookRepository;
	
	public DefaultDataGenerator(AccountService accountService, BookRepository bookRepository) {
		this.accountService = accountService;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account testmin = createNewAccount("testmin");
		Account testermin = createNewAccount("testermin");
		
		createNewBook(testmin, "spring");
		createNewBook(testermin, "hibernate");
		
	}

	private void createNewBook(Account testmin, String title) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(testmin);
		bookRepository.save(book);
	}

	private Account createNewAccount(String username) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword("123123");
		account.setRole("USER");
		
		return accountService.createNew(account);
	}
}
