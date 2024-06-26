<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList,com.pace.library.bean.Book"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List Page</title>
</head>
<body>
	<%
	session.getAttribute("booklist");
	ArrayList<Book> bookList = new ArrayList<Book>();
	bookList = 
		(ArrayList<Book>) session.getAttribute("booklist");
	%>
	<table border='1' align="center">
	<tr>
	<td> bid</td>
	<td> bname</td>
	<td>Author</td>
	<td>price</td>
	</tr>
		<%
		for (Book book : bookList) {
		%>
		<tr>
			<td align="center"><%=book.getBookId()%></td>
			<td align="center"><%=book.getBname()%></td>
			<td align="center"><%=book.getAuthor()%></td>
			<td align="center"><%=book.getPrice()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="index.html" >Home Page!</a>
</body>
</html>


