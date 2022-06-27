package com.spring.boot.test.dao;

import com.spring.boot.test.bean.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
}
