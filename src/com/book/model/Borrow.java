package com.book.model;

/**
 * 借阅实体
 * @author sdssy
 *
 */
public class Borrow {

	private int id;//编号
	private Integer userId;//借阅人编号
	private String userName;//借阅人
	private Integer bookId;//图书编号
	private String bookName;//图书名称
	private String borrow;//借阅状态
	
	public Borrow(Integer userId) {
		super();
		this.userId = userId;
	}
	
	public Borrow(int id, String borrow) {
		super();
		this.id = id;
		this.borrow = borrow;
	}
	
	public Borrow(Integer userId, Integer bookId, String bookName) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
	}
	
	public Borrow(String userName, String bookName, String borrow) {
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.borrow = borrow;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String useName) {
		this.userName = useName;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBorrow() {
		return borrow;
	}

	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
