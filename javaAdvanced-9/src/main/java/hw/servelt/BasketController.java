package hw.servelt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.domain.Basket;
import hw.service.BasketService;
import hw.service.impl.BasketServiceImpl;


@WebServlet("/basket")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BasketService basketService = BasketServiceImpl.getBasketService();  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String productId = request.getParameter("productId");
	
	HttpSession session = request.getSession();
	Integer userId = (Integer)session.getAttribute("userId");
	Basket basket = new Basket(userId,Integer.parseInt(productId),new Date());

	
	basketService.creat(basket);

	System.out.println(basket);
	response.setContentType("type");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("Success");
	
	
	
	}

	
}
