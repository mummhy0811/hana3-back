package DBMS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    //데이터베이스 접속 객체
    Connection conn = null;
    //SQL 쿼리를 구현하는 객체
    Statement stmt = null;
    //쿼리에 대한 응답인 ResultSet을 가져오는 객체
    ResultSet rs = null;

    public MemberDAO(){
        try {
            //MariaDB 드라이버 로드
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

    public int insert(MemberVO vo){
        int result = 0;
        try{
            //"INSERT INTO member (memberno, id, name) VALUES (1, 'hong', '홍길동')"
            String sql = "INSERT INTO member (memberno, id, name) "+
                    "VALUES ("+vo.getMemberno()+", '"+vo.getId()+"', '"+
                    vo.getName()+"')"; //세미콜론은 넣지 않는다!
            stmt = conn.createStatement();
            //정상수행되면 1을 리턴함.
            //insert,update,delete SQL문은 영향을 줄(ROW) 갯수를 반환함.
            result = stmt.executeUpdate(sql); //쿼리 수행!
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public MemberVO selectOne(int memberno){
        MemberVO vo = new MemberVO();

        try{
            String sql = "SELECT * FROM member WHERE memberno="+memberno;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if( rs.next() ) {
                vo.setMemberno(rs.getInt("memberno"));
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
            }
        }
        catch (Exception e){ e.printStackTrace(); }
        return vo;
    }
    public int update(MemberVO vo){
        int result = 0;
        try {
            String sql = "UPDATE member SET id='" +
                    vo.getId()+"', name='"+vo.getName()+"'"+
                    " WHERE memberno="+vo.getMemberno();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }
    public int delete(int memberno){
        int result = 0;
        try{
            String sql = "DELETE FROM member WHERE memberno="+memberno;
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }
    public List<MemberVO> list(){
        List<MemberVO> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM member";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                MemberVO vo = new MemberVO();
                vo.setMemberno(rs.getInt("memberno"));
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
                list.add(vo);
            }
        }
        catch (Exception e){ e.printStackTrace(); }
        return list;
    }
    public void close(){
        if(conn != null ){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}