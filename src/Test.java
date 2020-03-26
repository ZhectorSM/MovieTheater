import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.javafever.category.Category;
import com.javafever.category.CategoryActions;
import com.javafever.connection.DbConector;

public class Test {

	public static void main(String[] args) throws SQLException {

		Connection con = DbConector.getConnection();
		con.close();

		CategoryActions cat = new CategoryActions();
		List<Category> lstCategory = cat.read();
		System.out.println(lstCategory);
	}

}
