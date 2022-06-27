package com.spring.boot.test.service;

import com.spring.boot.test.bean.Book;
import com.spring.boot.test.dao.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Resource
    private BookRepository bookRepository;

    public Iterable<Book> findAllSort(Sort sort){
        return bookRepository.findAll(sort);
    }

    public Page<Book> findAll(Pageable page){
        return bookRepository.findAll(page);
    }

    public void save(List<Book> lstBook){
        if (lstBook == null || lstBook.size() == 0) {
            return;
        }

        bookRepository.saveAll(lstBook);
    }
}
