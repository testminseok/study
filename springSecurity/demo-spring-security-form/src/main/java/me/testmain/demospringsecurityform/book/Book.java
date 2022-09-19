package me.testmain.demospringsecurityform.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import me.testmain.demospringsecurityform.account.Account;

@Entity
public class Book {
	
	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	@ManyToOne
	private Account author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}
	
	
}
