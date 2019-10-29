package com.iceCream.registerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.icecreamparlour.entities.Seller;
import com.icecreamparlour.persistence.SellerDaoImpl;
import com.icecreamparlour.service.SellerBL;
import com.icecreamparlour.service.SellerBLImpl;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellerBL sellerbl = new SellerBLImpl();
		
		
		
		HttpSession session=request.getSession();
		Seller seller = sellerbl.loginSellerBL(request.getParameter("pNumber"), request.getParameter("password"));
		if (seller.getSellerName() != null) {
			session.setAttribute("phoneNumber", request.getParameter("pNumber"));
			session.setAttribute("seller", seller.getSellerName());
			response.sendRedirect("./flavour.jsp");
		} else {
			response.sendRedirect("./WrongLogin.jsp");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
