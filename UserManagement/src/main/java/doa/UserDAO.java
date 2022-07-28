package doa;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Utils.JDBCUtils;
import model.User;

public class UserDAO {
public int addUser(User user) {
	String INSERT_USERS_SQL = "INSERT INTO users"
			+ "  (id, name, email, country) VALUES "
			+ " (?, ?, ?, ?);";
	int result=0;
	try(Connection connection=JDBCUtils.getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERT_USERS_SQL)) {
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3,user.getEmail());
		ps.setString(4,user.getCountry());
		result=ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
return result;
}
}
