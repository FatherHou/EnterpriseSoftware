package lesson.j2ee.ex6.model;

//����ʹ��JDBC����Access���ݿ�Ĺ�����
import java.sql.*;

public class AccessJDBCUtil {
	private static final String url = "jdbc:mysql://localhost:3306/ex6?useUnicode=true&characterEncoding=UTF-8";
	public static String username = "root";
	public static String password = "root";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    /** ������Access���ݿ�����Ӷ��� */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}