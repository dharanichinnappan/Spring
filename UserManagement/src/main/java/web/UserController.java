package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.UserDAO;
import model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/addUser")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("addUser.jsp");
		System.out.println("here");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addUser(request, response);
	}
	
	private void addUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		System.out.println("all deails");
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setCountry(country);
		System.out.println("creaing dao");
		UserDAO userdao=new UserDAO();
		
		try {
			int result=userdao.addUser(user);
			System.out.println("calling dao mehod");
			if(result==1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			}
					} catch (Exception e) {
			// TODO: handle exception
						e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
		dispatcher.forward(request, response);

		
	}

}
