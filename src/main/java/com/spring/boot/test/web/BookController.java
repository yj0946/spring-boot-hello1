package com.spring.boot.test.web;

import com.spring.boot.test.bean.Book;
import com.spring.boot.test.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/sort")
    public Iterable<Book> sortBook(){
        Sort sort = Sort.by(Sort.Direction.DESC,"bookId");
        Iterable<Book> bookSort=bookService.findAllSort(sort);
        return bookSort;
    }

    @RequestMapping("/pager")
    public List<Book> sortPagerBook(int pageIndex){
        Sort sort = Sort.by(Sort.Direction.DESC,"bookId");
        Pageable page= PageRequest.of(pageIndex-1, 10,sort);
        Page<Book> bookDatas=bookService.findAll(page);
        List<Book> books=bookDatas.getContent();
        return books;
    }

    @RequestMapping("/save")
    public String save() {
        List<Book> lstBook = new ArrayList();
        Book book;
        Date sysdate = Calendar.getInstance().getTime();
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        format = sdf.format(sysdate);
        for (int i = 0; i < 100; i++) {
            book = new Book();
            book.setBookName("新华字典" + String.valueOf(i));
            book.setAuthor("张三");
            book.setCategory("目录");
            book.setPress("6666");
            book.setPrice(99.66);
            book.setCreatedDate(format);
            lstBook.add(book);
        }
        bookService.save(lstBook);
        return "保存成功!";
    }

}
