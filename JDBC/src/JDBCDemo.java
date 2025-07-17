import java.sql.*;
public class JDBCDemo {
public static void main(String args[]) throws SQLException
{
	sp ();
}
public static void readRecords()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
    String query="Select * from Employee";
    Connection con = DriverManager.getConnection(url,userName,password);
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(query);
   while( rs.next()) {
    System.out.println("Id is " + rs.getInt(1));
    System.out.println("Name is "+ rs.getString(2));
    System.out.println("Salary is "+ rs.getInt(3));}
    con.close();
}
public static void insertRecords()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
    int id=5;
    String name="varun";
    int salary=230404;
    String query="Insert into Employee values("+id + ",'" +name+"',"+salary+");";
    Connection con = DriverManager.getConnection(url,userName,password);
    Statement st=con.createStatement();
    int rows=st.executeUpdate(query);
    System.out.println("Number of rows affected: "+rows);
    con.close();
}
public static void insertUsingPst()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
    int id=6;
    String name="raina";
    int salary=2300004;
    String query="Insert into Employee values(?,?,?);";
    Connection con = DriverManager.getConnection(url,userName,password);
    PreparedStatement pst=con.prepareStatement(query);
    pst.setInt(1,id);
    pst.setString(2,name);
    pst.setInt(3,salary);
   int rows =  pst.executeUpdate();
   System.out.println("Number of rows affected: "+rows);
    con.close();
}
public static void delete()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
    int id=5;
    
    String query="Delete from Employee where empId = " + id;
    Connection con = DriverManager.getConnection(url,userName,password);
    Statement st=con.createStatement();
    int rows=st.executeUpdate(query);
    System.out.println("Number of rows affected: "+rows);
    con.close();
}
public static void update()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
   
    
    String query="update Employee set salary = 1500000 where empId =1";
    Connection con = DriverManager.getConnection(url,userName,password);
    Statement st=con.createStatement();
    int rows=st.executeUpdate(query);
    System.out.println("Number of rows affected: "+rows);
    con.close();
}
public static void sp()throws SQLException{
	String url= "jdbc:mysql://localhost:3306/jdbcdemo";
    String userName= "root";
    String password = "sithik29";
    
    
    
    Connection con = DriverManager.getConnection(url,userName,password);
    CallableStatement cst=con.prepareCall("{call GetEmp()}");
    ResultSet rs=cst.executeQuery();
    while( rs.next()) {
        System.out.println("Id is " + rs.getInt(1));
        System.out.println("Name is "+ rs.getString(2));
        System.out.println("Salary is "+ rs.getInt(3));}
    con.close();
}
}
