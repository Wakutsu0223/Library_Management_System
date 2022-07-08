package com.book.model;

/**
 * 图书实体
 * @author sdssy
 *
 */
public class Book {
	private int id;//编号
	private String bookName;//图书名称
	private String author;//作者
	private String sex;//性别
	private Float price;//价格
	private Integer bookTypeId;//图示类别Id
	private String bookTypeName;//图书类别名称
	private String bookDesc;//备注
	private int inStock;//库存
	
	
	
	public Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc, int inStock) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.inStock = inStock;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Book(int id) {
		super();
		this.id = id;
	}



	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}



	public Book(String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc, int inStock) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.inStock = inStock;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookTypeDesc) {
		this.bookDesc = bookTypeDesc;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

}
