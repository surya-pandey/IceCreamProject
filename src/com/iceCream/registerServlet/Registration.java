package com.iceCream.registerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icecreamparlour.entities.Seller;
import com.icecreamparlour.service.SellerBL;
import com.icecreamparlour.service.SellerBLImpl;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellerBL sellerbl = new SellerBLImpl();
		HttpSession session = request.getSession(false);
		Seller seller=new Seller(request.getParameter("name"), request.getParameter("pnumber"), request.getParameter("email"), request.getParameter("password"));
		
		sellerbl.insertNewSellerBL(seller);
		session.setAttribute("Status", "success");
		response.sendRedirect("./login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
