package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	
	public void init() 
	{
		System.out.println("start");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("view/Page.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double res = 0;
		boolean err= false;
		double a = 0;
		double b = 0;
		
		try {
			a = Double.parseDouble(request.getParameter("num1"));
			b = Double.parseDouble(request.getParameter("num2"));
		} catch(NumberFormatException  e) {
			e.printStackTrace();
			request.setAttribute("errore", "Non hai inserito dei numeri");
			request.getRequestDispatcher("view/Page.jsp").forward(request, response);
		}
		
		String met = request.getParameter("met").trim();
		switch(met){
			case "+":
				res = a+b;
				break;
			case "-":
				res = a-b;
				break;
			case "*":
				res = a*b;
				break;
			case "/":
				try {
				res = a/b;
				} catch(ArithmeticException e) {
					e.printStackTrace();
					request.setAttribute("errore", "Impossibile dividere per 0");
					err = true;
				}
				break;
			default:
				request.setAttribute("errore", "Inserisci un operatore valido");
				err = true;
		}
		if(!err) {
			request.setAttribute("risultato", res);
		}
		request.getRequestDispatcher("view/Page.jsp").forward(request, response);
	}
	public void destroy() {
		System.out.println("dead");
	}
}
