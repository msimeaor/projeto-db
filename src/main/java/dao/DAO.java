package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private final String URL_CONNECTION = "jdbc:mysql://localhost:3306/ex12";
	private final String USER_CONNECTION = "root";
	private final String PWD_CONNECTION = "root";

	Connection conn;

	protected Connection getConnection() throws DAOException {

		try {
			if(conn == null) {
				conn = DriverManager.getConnection(URL_CONNECTION, USER_CONNECTION, PWD_CONNECTION);
			}
			
			return conn;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (Exception i) {
			throw new DAOException(i);
		}

	}

	protected void closeConnection() throws DAOException {
		
		try {
			if(conn != null) { 		
				conn.close();
				conn = null;
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
