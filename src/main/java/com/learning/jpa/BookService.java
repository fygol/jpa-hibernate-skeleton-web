package com.learning.jpa;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {

    @PersistenceContext
    EntityManager em;

    public void create() {
        Book book = new Book();
        book.setName("book");
        book.setYear(2004);
        em.persist(book);
    }

    public List<Book> getAllBooks() {
        return em.createQuery("select b from Book b", Book.class)
                .getResultList();
    }
}
