package jdbc_emp;
import java.sql.*;
import java.util.*;


public class employeeclass {

	public static void main(String[] args) throws Exception{
		
		Scanner sc= new Scanner(System.in);
		int eid=Integer.parseInt(sc.nextLine());
		String name=sc.nextLine();
		float sal=Float.parseFloat(sc.nextLine());
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javax","root","root");
		
		String query ="insert into salary values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,eid);
		ps.setString(2, name);
		ps.setFloat(3, sal);
		
		int i=ps.executeUpdate();
		
		
		
		
		
		ps=con.prepareStatement("select * from salary");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("emp id is"+rs.getInt("eid"));
			System.out.println("emp name is"+rs.getString("name"));
			System.out.println("emp salary is"+rs.getFloat("sal"));
			
		}
	}

}
