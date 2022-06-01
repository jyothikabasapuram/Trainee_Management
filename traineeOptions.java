package Revature.com.MINIPROJECT1;
import java.sql.*;
import java.util.Scanner;

public class traineeOptions {
public Connection getMysqlConnection() {
Connection con= null;
try {
String url = "jdbc:mysql://localhost:3308/MINIPROJECT1";
String username = "root";
String password = "mANI@7272";

    con=DriverManager.getConnection(url,username,password);
}catch(Exception e) {
    e.printStackTrace();
   }
return con;
}

public void admin() throws SQLException {
// TODO Auto-generated method stub

Scanner ss=new Scanner(System.in);
System.out.println("Enter Username");
String username = ss.next();

System.out.println("Enter password");
String password = ss.next();

Connection con =getMysqlConnection();
Statement stmt= con.createStatement();
ResultSet rs=stmt.executeQuery("select username,password from admin");



if (rs.next()) {

if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
int a =0;
for(a=0;a<4;a++) {

System.out.println("*******welcome to admin page:"+" "+ username+"********");

System.out.println("1. Sign up as Trainer");
System.out.println("2. Sign up as Trainee");
System.out.println("3. Exit");


Scanner sc=new Scanner(System.in);
   a =sc.nextInt();
   if (a==1){
    signupAsTrainers();
   
   }
   else if (a==2) {
    traineeSignup();
   
   }
   else if(a==3) {
    System.out.println(" ");
   }
   else {
    System.out.println("Enter valid choice...");
   }
}


 
}
else{

System.out.println("Wrong Username And Password");

}}



}

public void traineeSignup() {
   
     try {
Connection conn =getMysqlConnection();
String createAcount = "insert into trainee(Id,contactno,username,password) values(?,?,?,?) ";

PreparedStatement ps=  conn.prepareStatement(createAcount);

Scanner sc=new Scanner(System.in);

System.out.println("Enter Id");
int Id = sc.nextInt();

System.out.println("Enter your contact no");
int contactno = sc.nextInt();

System.out.println("Enter your Username");
String username = sc.next();

System.out.println("Enter your Password ");
String password = sc.next();

ps.setInt(1, Id);
ps.setInt(2, contactno);
ps.setString(3, username);
ps.setString(4, password);

ps.executeUpdate();
System.out.println("***  Account created  ****");


conn.close();

     }catch(Exception e) {
     System.out.println(e);
     }
   

}

public void loginasuser()  {
// TODO Auto-generated method stub

Scanner ss=new Scanner(System.in);
System.out.println("Enter UserName");
String usernames = ss.next();

System.out.println("Enter password");
String password = ss.next();

Connection connn =getMysqlConnection();
String sql=  "select username,password from trainees where username= ?";
PreparedStatement stmt;
try {
stmt = connn.prepareStatement(sql);
stmt.setString(1, usernames);
ResultSet rs=stmt.executeQuery( );
       


if (rs.next()) {

if (rs.getString(1).equals(usernames) && rs.getString(2) == password) {

System.out.println(" ******* WELCOME DEAR TRAINE :"+" "+ usernames + "******");

}
else{

System.out.println("!!!!!!!!!!!!! Wrong Username And Password  !!!!!!!!!!!!!!" );

}}
}



catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


}

public void signupAsTrainers() {
// TODO Auto-generated method stub
  try {
Connection conn =getMysqlConnection();
String createAcount = "insert into trainer( id,username,password,course) values(?,?,?,?) ";

PreparedStatement ps=  conn.prepareStatement(createAcount);

Scanner sc=new Scanner(System.in);
System.out.println("Enter your id");
int id = sc.nextInt();

System.out.println("Enter your Username");
String username = sc.next();

System.out.println("Enter your Password ");
String password = sc.next();

System.out.println("Enter Trainer course");
   String course= sc.next();
ps.setInt(1, id);
ps.setString(2, username);
ps.setString(3 ,password);
ps.setString(4, course);

ps.executeUpdate();
System.out.println("***  TRAINER ACCOUNT CREATED  ****");

conn.close();

     }catch(Exception e) {
     System.out.println(e);
     }

}

public void loginAsTrainer()  {
// TODO Auto-generated method stub

Scanner ss=new Scanner(System.in);
System.out.println("Enter UserName");
String usernames = ss.next();

System.out.println("Enter password");
String password = ss.next();

Connection connn =getMysqlConnection();
String sql=  "select username,password from trainers where username= ?";
PreparedStatement stmt;
try {
stmt = connn.prepareStatement(sql);
stmt.setString(1, usernames);
ResultSet rs=stmt.executeQuery( );
   


if (rs.next()) {

if (rs.getString(1).equals(usernames) && rs.getString(2) == password) {

System.out.println(" ******* WELCOME DEAR TRAINER :"+" "+ usernames + "******");



}
else{

System.out.println("!!!!!!!!!!!!! Wrong Username And Password  !!!!!!!!!!!!!!" );

}}
}



catch (SQLException e) {

e.printStackTrace();
}



}}

