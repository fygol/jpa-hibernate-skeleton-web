package com.learning.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/book")
public class BookController extends HttpServlet {

    @Inject
    BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        bookService.create();
        List<Book> books = bookService.getAllBooks();

        PrintWriter out = resp.getWriter();
        for (Book book: books) {
            out.print("<p>id:" + book.getId() + "</p>");
            out.print("<p>name:" + book.getName() + "</p>");
            out.print("<p>year:" + book.getYear() + "</p>");
            out.print("<hr/>");
        }
    }
}
