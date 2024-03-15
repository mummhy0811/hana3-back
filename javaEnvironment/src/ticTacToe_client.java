import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
//자바 종합 실습 - 2인1조
//TCP/IP(소켓) 통신을 이용한 게임만들기
//주제: 틱택토이 게임(OX게임)
//https://lagged.kr/p/1378/
//기능 및 설계 요구사항
//1. 2인용 통신을 이용한 온라인 게임
//2. 서버프로그램 1개 + 클라이언트 프로그램 1개
//   클라 <---> 서버
//3. 서버는 3x3 정수형 2차 배열에 바둑판의 정보를 static으로 가진다.
//4. 0은 빈 칸, 1은 O, 2는 X 이다.

//5. 입력 및 출력 예)
// 클라 : "c1,0,0,O"엔터
// 서버 : 클라1으로부터 정보가 수신되었습니다.
// O - -
// - - -
// - - -
// 클라 :
// O - -
// - - -
// - - -

// 클라 : "c2,0,1,X"
// 서버 : 클라2으로부터 정보가 수신되었습니다.
// O X -
// - - -
// - - -
// 클라 :
// O X -
// - - -
// - - -

// 클라 : "info"엔터
// 서버 : 클라로부터 정보가 수신되었습니다.
// O X -
// - - -
// - - -
// 클라 :
// O X -
// - - -
// - - -

//게임판정
//가로,세로,대각선 방향으로 O/X가 3개 연속되면, 승리하게 된다.

//개발순서
//서버 : int[][] map = new int[3][3];
//클라 : "c1,0,0,O" 문자열을 서버로 전송
//서버 : "c1,0,0,O"을 꼼마 단위로 문자열배열로 만들고, map 정수배열 값을 업데이트한다.
//서버 : "1,0,0,0,0,0,0,0,0" 문자열을 클라1에게 전송한다.
//클라 : "1,0,0,0,0,0,0,0,0" 문자열을 꼼마단위로 분석해서,map 정수배열 값을 업데이트한다.
//서버 : 게임판정을 해서 승리한 클라이언트 이름을 출력한다.

//클라 : "c2,0,1,X" 문자열을 서버로 전송
//서버 : "c2,0,1,X"을 꼼마 단위로 문자열배열로 만들고, map 정수배열 값을 업데이트한다.
//서버 : "1,2,0,0,0,0,0,0,0" 문자열을 클라에게 전송한다.
//클라 : "1,2,0,0,0,0,0,0,0" 문자열을 꼼마단위로 분석해서, map 정수배열 값을 업데이트한다.

//서버 : 게임판정을 해서 승리한 클라이언트 이름을 출력한다.

public class ticTacToe_client {
    public static int[][] map = new int[3][3];
    public static void main(String[] args) {
        Socket socket = null;
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", 5001));
            System.out.println("서버 접속 성공!");
            while(true){
                //서버에 문자열형으로 데이타를 보내보자.
                System.out.print("입력: ");
                Scanner sc = new Scanner(System.in);
                String message = sc.next();

                OutputStream os = socket.getOutputStream();
                byte[] bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush(); //버퍼에 데이타를 다 내보낸다.

                //서버로부터 데이터 받기
                InputStream is = socket.getInputStream();
                bytes = new byte[1024];
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                fill(message);
                print();


                os.close();
                is.close();
                if(socket.isClosed()) {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress("127.0.0.1", 5001));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("서버 접속 오류!");
        }
    }

    public static void fill(String s){
        System.out.println(s);
        String[] info = s.split(",");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map[i][j]=Integer.parseInt(info[i*3+j]);
            }
        }
    }
    public static void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]==0){
                    System.out.print("- ");
                    continue;
                }
                if(map[i][j]==1){
                    System.out.print("O ");
                    continue;
                }
                if(map[i][j]==2){
                    System.out.print("X ");

                }
            }
            System.out.println();
        }
    }
}
