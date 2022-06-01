package Revature.com.MINIPROJECT1;
import java.sql.*;
import java.util.Scanner;
public class TrainerManagement {

public static void main(String[] args) throws SQLException {
   
String s="y";
while(s.equals("y")) {
System.out.println("********Trainee Management Center version 1.0*********");
System.out.println("press 1 to Admin Signin");
//System.out.println("press 2 to Login");
System.out.println("press 2 to Login as Tainee");
//System.out.println("press 4 to signupAsTrainers");
System.out.println("press 3 to Login as Trainers");


Scanner scan=new Scanner(System.in);
System.out.println("Enter your choice :");
int c=scan.nextInt();
traineeOptions to=new traineeOptions();
switch(c) {
case 1:to.admin();
     break;
//case 2:to.login();
//    break;
case 2:to.loginasuser();  
     break;
/* case 4:to.signupAsTrainers();
     break; */
case 3:to.loginAsTrainer();
             break;
default:System.out.println("wrong choice");
}


System.out.println("do u want to continue press y/n");
s=scan.next();

}
}
}