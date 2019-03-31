package com.talentsprint.us.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.talentsprint.us.dao.BranchDAO;
import com.talentsprint.us.dao.FeedbackDAO;
import com.talentsprint.us.dao.RecipeDAO;
import com.talentsprint.us.dao.RestaurantDAO;
import com.talentsprint.us.dao.UserDAO;
import com.talentsprint.us.model.Branch;
import com.talentsprint.us.model.Feedback;
import com.talentsprint.us.model.Recipe;
import com.talentsprint.us.model.Restaurant;
import com.talentsprint.us.model.User;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (null == action) {
			List<Recipe> recipesList = new RecipeDAO().getRecipes();
			request.setAttribute("recipesList", recipesList);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else if (action.equals("viewBranch")) {
			int recipeId = Integer.parseInt(request.getParameter("id"));
			Set<Branch> branchList = new BranchDAO().getBranchperRecipe(
					recipeId, 0);
			request.setAttribute("branchList", branchList);
			request.getRequestDispatcher("viewbranch.jsp").forward(request,
					response);
		} else if (action.equals("ViewRestaurantviseBranches")) {
			int recipeId = Integer.parseInt(request.getParameter("id"));
			Set<Restaurant> restaurants = new RestaurantDAO()
					.getRestaurantsServe(recipeId);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("recipeId", recipeId);
			request.setAttribute("restaurntList", restaurants);
			request.getRequestDispatcher("viewbranch.jsp").forward(request,
					response);
		} else if (action.equals("AddFeedback")) {
			String branch = request.getParameter("branch");
			request.setAttribute("branch", branch);
			HttpSession httpSession = request.getSession();
			request.setAttribute("recipeId",
					(int) httpSession.getAttribute("recipeId"));
			request.getRequestDispatcher("addFeedback.jsp").forward(request,
					response);
		}

		else if (action.equals("feedback")) {
			int recipeId = Integer.parseInt(request.getParameter("recipeId"));
			List<Feedback> feedbackList = new FeedbackDAO()
					.getFeedbacksByItem(recipeId);
			request.setAttribute("feedbackList", feedbackList);
			request.getRequestDispatcher("viewfeedback.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			DiskFileItemFactory dis = new DiskFileItemFactory();
			ServletFileUpload sfd = new ServletFileUpload(dis);
			try {
				List<FileItem> list = sfd.parseRequest(request);
				Restaurant restaurant = new Restaurant();
				Branch branch = new Branch();
				int restaurantId = 0;
				for (FileItem fileItem : list) {
					System.out.println(fileItem.getFieldName());
					if (!fileItem.isFormField()) {
						String imagePath = "D:/project"
								+ getServletContext().getContextPath()
								+ "/WebContent/images/branches/"
								+ fileItem.getName();
						fileItem.write(new File(imagePath));
						System.out.println(imagePath);
						branch.setImagePath(fileItem.getName());

					} else {
						if (fileItem.getFieldName().equals("name")) {
							restaurant
									.setRegistrationName(fileItem.getString());
						} else if (fileItem.getFieldName().equals("password")) {
							restaurant.setPassword(fileItem.getString());
						} else if (fileItem.getFieldName().equals(
								"registrationId")) {
							restaurant
									.setRegistartionId((fileItem.getString()));

						} else if (fileItem.getFieldName().equals("location")) {
							branch.setLocation((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("city")) {
							branch.setCity((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("state")) {
							branch.setState((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("postalCode")) {
							branch.setPostalCode((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("country")) {
							branch.setCountry((fileItem.getString()));
						} else if (fileItem.getFieldName().equals("emailId")) {
							branch.setEmailId((fileItem.getString()));
						} else if (fileItem.getFieldName()
								.equals("phoneNumber")) {
							branch.setPhoneNumber((Long.parseLong(fileItem
									.getString())));
						}
					}
				}
				System.out.println(restaurant);
				RestaurantDAO restaurantDAO = new RestaurantDAO();
				/*
				 * restaurantId = restaurantDAO.insert(restaurant);
				 * branch.setRestaurntId(new
				 * RestaurantDAO().getRestaurant(restaurant
				 * .getRegistrationName()));
				 */
				int status = new BranchDAO().insert(branch);
				if (status > 0) {
					request.setAttribute("userName",
							restaurant.getRegistrationName());
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				} else {
					response.sendRedirect("registration.jsp");

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String action = request.getParameter("action");
			if (action.equals("user_registration")) {
				String firstName = request.getParameter("FirstName");
				String lastName = request.getParameter("LastName");
				String email = request.getParameter("EmailId");
				String password = request.getParameter("password");
				long phoneNumber = Long.parseLong(request
						.getParameter("phoneNumber"));

				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmailId(email);
				user.setPassword(password);
				user.setPhoneNumber(phoneNumber);
				
				if (new UserDAO().insert(user) > 0) {
					request.setAttribute("userName", email);
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				} else {

				}

			} else if (action.equals("login")) {

				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String loginAs = request.getParameter("loginAs");
				if (loginAs.equals("userLogin")) {
					User user = new UserDAO().getuser(userName);
					if (user != null && user.getPassword().equals(password)) {
						HttpSession httpSession = request.getSession();
						httpSession.setAttribute("loggedUser",
								user.getUser_id());
						response.sendRedirect("HomeController");
					} else {
						response.sendRedirect("login.jsp");
					}
				} else if (loginAs.equals("restaurantLogin")) {
					System.out.println(userName);
					Restaurant restaurant = new RestaurantDAO()
							.getRestaurant(userName);
					if (restaurant != null
							&& restaurant.getPassword().equals(password)) {
						HttpSession httpSession = request.getSession();
						httpSession.setAttribute("loggedUser",
								restaurant.getRestaurantId());
						response.sendRedirect("restaurantHome.jsp");
					} else {
						response.sendRedirect("login.jsp");
					}
				}
			} else if (action.equals("Comments")) {
				Feedback feedback = new Feedback();
				HttpSession session = request.getSession();
				feedback.setBranchId(new BranchDAO().getBranchId(
						request.getParameter("branch")));
				feedback.setRecipeId(Integer.parseInt(request.getParameter("recipeId")));
				feedback.setComments(request.getParameter("comments"));
				feedback.setRate(Integer.parseInt(request
						.getParameter("ratings")));
				feedback.setCustomerId(Integer.parseInt(session.getAttribute(
						"loggedUser").toString()));
				if (0 < new FeedbackDAO().saveRatings(feedback)) {
					response.sendRedirect("HomeController");

				}
			}

		}

	}

}
