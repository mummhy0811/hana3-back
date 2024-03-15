package DBMS;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static void main(String[] args) {
        //데이터베이스 접속 객체
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //데이터베이스 접속
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", //Host
                    "root", //사용자
                    "mysql123" //암호
            );
        }catch (Exception e){
            e.printStackTrace();
            try {
                conn.close();
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        if( conn != null) {
            System.out.println("데이터베이스 접속 성공!!");
        }
    }
}