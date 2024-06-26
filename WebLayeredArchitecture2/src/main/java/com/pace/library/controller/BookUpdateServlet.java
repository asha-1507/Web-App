package com.pace.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pace.library.dao.BookDAO;
import com.pace.library.service.BookServiceProvider;

/**
 * Servlet implementation class BookUpdateServlet
 */
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO bookDao = new BookDAO();
		boolean rows = false;
		int id;

		id = Integer.parseInt(request.getParameter("id"));
		try {
			rows = bookDao.updateBook(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Book data could not updated");
		}
		if (rows == true) {
			System.out.println("Book data successfully updated");
		} else {
			System.out.println("Book data could not update");
		}
		RequestDispatcher dis = 
				request.getRequestDispatcher("updateSuccess.html");
		dis.forward(request, response);
	}

}
