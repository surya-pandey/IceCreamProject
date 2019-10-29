package com.iceCream.registerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;
import com.icecreamparlour.entities.Seller;
import com.icecreamparlour.persistence.FlavoursDao;
import com.icecreamparlour.service.FlavourOfferingsBySellerBL;
import com.icecreamparlour.service.FlavoursBL;
import com.icecreamparlour.service.FlavoursBLImpl;
import com.icecreamparlour.service.SellerBL;
import com.icecreamparlour.service.SellerBLImpl;

public class AddFlavour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FlavoursBL flavourbl = new FlavoursBLImpl();
		SellerBL sellerbl = new SellerBLImpl();
		HttpSession session = request.getSession(false);
		Seller seller = sellerbl.searchSellerBL((String) session.getAttribute("pNumber"));
		 Flavours flavour = new Flavours(request.getParameter("flavourname"));
		  FlavourOfferingsBySeller flavourOfferingsBySeller = new FlavourOfferingsBySeller(
		    Integer.parseInt(request.getParameter("sPrice")), Integer.parseInt(request.getParameter("dPrice")),
		    Integer.parseInt(request.getParameter("oPrice")));
		  flavourbl.addNewFlavourBL(flavour, flavourOfferingsBySeller, seller.getSellerId());
		  session.setAttribute("status", "success");
		  response.sendRedirect("./allflavours");
		  
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
