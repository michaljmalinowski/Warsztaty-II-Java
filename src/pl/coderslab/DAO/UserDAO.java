package pl.coderslab.DAO;

import pl.coderslab.models.User;

import java.sql.*;

public class UserDAO {
	private static final String CREATE_USER_QUERY =
			"INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
	private static final String READ_USER_QUERY =
			"SELECT * FROM users where id = ?";
	private static final String UPDATE_USER_QUERY =
			"UPDATE users SET username = ?, email = ?, password = ? where id = ?";
	private static final String DELETE_USER_QUERY =
			"DELETE FROM users WHERE id = ?";
	private static final String FIND_ALL_USERS_QUERY =
			"SELECT * FROM users";
	private final String URL =
			"jdbc:mysql://localhost:3306/warsztat2?useSSL=false&characterEncoding=utf8";
	private final String USER = "root";
	private final String PASSWORD = "coderslab";

	//dodawanie obiektu
	public User create (User user) {
		try (Connection conn = DriverManager.getConnection (URL, USER, PASSWORD)) {
			PreparedStatement statement =
					conn.prepareStatement (CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setString (1, user.getUserName ());
			statement.setString (2, user.getEmail ());
			statement.setString (3, user.getPassword ());
			statement.executeUpdate ();
			ResultSet resultSet = statement.getGeneratedKeys ();
			if (resultSet.next ()) {
				user.setId (resultSet.getInt (1));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace ();
			return null;
		}
	}
}
