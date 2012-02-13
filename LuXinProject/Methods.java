import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Methods {
	public int size=0;
	public static String user;
	public static boolean admin;
	public Connection c;
	public GettersnSetters criminals[] = new GettersnSetters[100];
	public Connection con() 
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");}
		catch (ClassNotFoundException c)
		{System.out.println("unable to load database driver");}
		try
		{ c=DriverManager.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ= Database.mdb");
		// System.out.println("Connection done");
		}
		catch(Exception e)
		{System.out.println("No Connection to dataBASE");}
		return c;
	}
	public void updateTable (String update) throws SQLException
	{
		con();	
		Statement stmt = c.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
	}
	public void fillArray(){
		con();
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Info ORDER BY Reward_USD DESC");
			size = 0;
			
			while (rs.next()){
				String Name = rs.getString(1);
				String DOB = rs.getString(2);
				String Height = rs.getString(3);
				int Weight = rs.getInt(4);
				String Hair = rs.getString(5);
				String Eyes = rs.getString(6);
				String Sex = rs.getString(7);
				String Nationality = rs.getString(8);
				String Scars = rs.getString(9);
				String Crime = rs.getString(10);
				int Reward = rs.getInt(11);
				criminals [size] = new GettersnSetters(Name, DOB, Height, Hair, Eyes, Sex, Nationality, Scars, Crime, Weight, Reward); 
				size++;
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public boolean test(String num){
		boolean right=true;
		for (int i=0;i<num.length();i++){
			if ((num.charAt(i)<=57&&num.charAt(i)>=48)||num.charAt(i)==46)
			{}			
			else{
				right = false;
			}
		}
		
		if (right)
			return true;
		
		else
			return false;
	}
	public void setUser(String Login)
	{
		user = Login;
		
	}
	public void setAdmin(boolean authority)
	{
		admin = authority;
		
	}
}


