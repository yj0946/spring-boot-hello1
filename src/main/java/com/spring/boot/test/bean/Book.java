package com.spring.boot.test.bean;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;			//图书编号
    private String bookName;		//图书名称
    private String category;		//类别
    private String author;			//作者
    private String press;			//出版社
    private Double price;			//价格

//    @Temporal(TemporalType.DATE)
//    @Column(name="CREATED_DATE")
//    private Date createdDate;
     private String createdDate;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
