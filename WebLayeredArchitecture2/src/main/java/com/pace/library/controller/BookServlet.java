package com.pace.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pace.library.bean.Book;
import com.pace.library.service.BookServiceProvider;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book book = new Book();
		ArrayList<Book> bookList = new ArrayList<Book>();
		BookServiceProvider bookServiceProvider = 
				new BookServiceProvider();
		try {
			bookList = bookServiceProvider.getBookService();
			HttpSession session = request.getSession();
			session.setAttribute("booklist",bookList);
			RequestDispatcher dis = 
					request.getRequestDispatcher("showBookDetails.jsp");
			dis.forward(request, response); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Book data could not found");
		}
		
		
		// send books data to service
		/*
		 * try { bookServiceProvider.showBooksService(bookList); } catch
		 * (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch
		 * block System.out.println("Book data could not found"); }
		 */
	}

	
}
