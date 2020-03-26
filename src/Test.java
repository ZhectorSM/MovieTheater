import java.sql.Connection;
import java.sql.SQLException;

import com.javafever.connection.DbConector;

public class Test {

	public static void main(String[] args) throws SQLException {

		Connection con = DbConector.getConnection();
		con.close();

	}

}
