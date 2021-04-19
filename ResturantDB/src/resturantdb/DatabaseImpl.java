package resturantdb;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseImpl implements Database {
	
	private Connection connection;
	private final String diverName;
	private String databaseConnectionLink;
	private String databaseUser;
	private String databasePassword;
	
	public DatabaseImpl() {
		this.diverName = "com.mysql.jdbc.Driver";
		this.databaseConnectionLink = "jdbc:mysql://localhost:3306/resturant_db?characterEncoding=latin1&useConfigs=maxPerformance";
		this.databaseUser = "saassignment01";
		this.databasePassword = "sa1998";
	}

	@SuppressWarnings("finally")
	@Override
	public Connection getDatabaseConnection() {
		try {
			Class.forName(diverName);
			connection = (Connection) DriverManager.getConnection(databaseConnectionLink, databaseUser, databasePassword);
			System.out.println("DB Connection Successfull");
		} catch (ClassNotFoundException exc) {
			System.out.println("Class not found");
			System.out.println(exc.getMessage());
		} catch (SQLException exc) {
			System.out.println("SQL Error");
			System.out.println(exc.getMessage());
		} finally {
			return connection;
		}
	}
	

}
