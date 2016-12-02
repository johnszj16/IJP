

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IJPMain {
	public static void main(String[] args){
		final String QUERY = "SELECT * FROM Players";
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost/UtdRoster","river","some_pass");
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			System.out.println(stmt.toString());
			
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while(rs.next()){
				System.out.println(rs.getInt("ID") +", "+rs.getString("FNAME")+", "+rs.getString("LNAME")+", "+rs.getInt("AGE")+", "+rs.getInt("NUMBER"));
			}
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

}
