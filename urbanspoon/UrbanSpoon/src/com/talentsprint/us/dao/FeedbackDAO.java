package com.talentsprint.us.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.talentsprint.us.dao.util.DAOUtility;
import com.talentsprint.us.model.Feedback;

public class FeedbackDAO {
	public int saveRatings(Feedback feedback) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DAOUtility.getConncetion();

		try {
			preparedStatement = connection
					.prepareStatement("insert into feedback_recipe(branch_id,user_id,recipe_id,comments,feedback_date,rating) values (?,?,?,?,?,?)");
			preparedStatement.setInt(1, feedback.getBranchId());
			preparedStatement.setInt(2, feedback.getCustomerId());
			preparedStatement.setInt(3, feedback.getRecipeId());
			preparedStatement.setString(4, feedback.getComments());
			java.util.Date date = new Date();
			java.sql.Date ratedDate = new java.sql.Date(date.getTime());
			preparedStatement.setDate(5, ratedDate);
			preparedStatement.setInt(6, feedback.getRate());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DAOUtility.getConncetion();
		try {
			preparedStatement = connection
					.prepareStatement("delete from  rating  where id=? ");

			preparedStatement.setInt(1, id);

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	public List<Feedback> getFeedbacksByItem(int recipeId) {

		List<Feedback> feedbackList = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DAOUtility.getConncetion();

		try {
			preparedStatement = connection
					.prepareStatement("select f.comments,u.first_name,f.feedback_date,rating from feedback_recipe f join user u where u.user_id=f.user_id and recipe_id=?;");
			preparedStatement.setInt(1, recipeId);
			resultSet = preparedStatement.executeQuery();
			feedbackList = new ArrayList<Feedback>();
			while (resultSet.next()) {
				Feedback feedback = new Feedback();
				feedback.setComments(resultSet.getString(1));
				feedback.setFirstName(resultSet.getString(2));
				feedback.setFeedbackDate(resultSet.getDate(3));
				feedback.setRate(resultSet.getInt(4));
				feedbackList.add(feedback);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return feedbackList;

	}

	public List<Feedback> getFeedbacksByUser(int userId) {

		List<Feedback> feedbackList = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DAOUtility.getConncetion();

		try {
			preparedStatement = connection
					.prepareStatement("SELECT * from feedback_recipe where recipe_id=?;");
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			feedbackList = new ArrayList<Feedback>();
			while (resultSet.next()) {
				Feedback feedback = new Feedback();
				feedback.setFeedbackId(resultSet.getInt(1));
				feedback.setComments(resultSet.getString(2));
				feedback.setFeedbackDate(resultSet.getDate(3));
				feedback.setBranchId(resultSet.getInt(4));
				feedback.setCustomerId(resultSet.getInt(5));
				feedbackList.add(feedback);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return feedbackList;

	}

}
