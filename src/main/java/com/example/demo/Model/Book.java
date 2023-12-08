package com.example.demo.Model;



import java.sql.Blob;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "books_img")
	private String booksImg;
	@Column(name = "books_name")
	private String booksName;
	@Column(name = "book_series_name")
	private String bookSeriesName;
	@Column(name = "episode")
	private int episode;
	@Column(name = "type")
	private String type;
	@Column(name = "author")
	private String author;
	@Column(name = "publish_company")
	private String publishCompany;
	@OneToMany(mappedBy = "booksId") // khai báo relationship của phía 1
	private Set<LoanCard> loanCard;
	
	public Book() {
		super();
	}
	
	
	public Book(int id) {
		super();
		this.id = id;
	}


	public Book(String booksName) {
		super();
		this.booksName = booksName;
	}

	public Book(int id, String booksName) {
		super();
		this.id = id;
		this.booksName = booksName;
	}

	public Book(int id, String booksName, String bookSeriesName, int episode, String type, String author,
			String publishCompany) {
		super();
		this.id = id;
		this.booksName = booksName;
		this.bookSeriesName = bookSeriesName;
		this.episode = episode;
		this.type = type;
		this.author = author;
		this.publishCompany = publishCompany;
	}

	public Book(int id, String booksImg, String booksName, String bookSeriesName, int episode, String type,
			String author, String publishCompany) {
		super();
		this.id = id;
		this.booksImg = booksImg;
		this.booksName = booksName;
		this.bookSeriesName = bookSeriesName;
		this.episode = episode;
		this.type = type;
		this.author = author;
		this.publishCompany = publishCompany;
	}
	

	public Book(int id, String booksImg, String booksName, String bookSeriesName, int episode, String type,
			String author, String publishCompany, Set<LoanCard> loanCard) {
		super();
		this.id = id;
		this.booksImg = booksImg;
		this.booksName = booksName;
		this.bookSeriesName = bookSeriesName;
		this.episode = episode;
		this.type = type;
		this.author = author;
		this.publishCompany = publishCompany;
		this.loanCard = loanCard;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBooksImg() {
		return booksImg;
	}

	public void setBooksImg(String booksImg) {
		this.booksImg = booksImg;
	}
	public String getBooksName() {
		return booksName;
	}
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}
	public String getBookSeriesName() {
		return bookSeriesName;
	}
	public void setBookSeriesName(String bookSeriesName) {
		this.bookSeriesName = bookSeriesName;
	}
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishCompany() {
		return publishCompany;
	}
	public void setPublishCompany(String publishCompany) {
		this.publishCompany = publishCompany;
	}

	public Set<LoanCard> getLoanCard() {
		return loanCard;
	}

	public void setLoanCard(Set<LoanCard> loanCard) {
		this.loanCard = loanCard;
	}
	
	
	
}
