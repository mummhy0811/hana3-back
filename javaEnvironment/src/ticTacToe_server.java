import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//기능 및 설계 요구사항
//1. 2인용 통신을 이용한 온라인 게임
//2. 서버프로그램 1개 + 클라이언트 프로그램 2개
//   클라1 <---> 서버 <--> 클라2
//3. 서버는 3x3 정수형 2차 배열에 바둑판의 정보를 static으로 가진다.
//4. 0은 빈 칸, 1은 O, 2는 X 이다.

//5. 출력예)
// 클라1 "c1,0,0,O" 전송 후 서버는 "1,0,0,0,0,0,0,0,0"를 받는다.
// 서버 "c1,0,0,O" 수신 후 서버는 "1,0,0,0,0,0,0,0,0"을 보낸다.
// 클라2 "c2,0,1,X" 전송 후 서버는 "1,2,0,0,0,0,0,0,0"를 받는다.
// 서버 "c2,0,0,X" 수신 후 서버는 "1,2,0,0,0,0,0,0,0"을 보낸다.

//6. 클라1이나 클라2가 서버의 정보를 요청한다.
//  "info"라고 보내면, 서버는 현재의 정보를 보낸다.
//  "info" => "1,2,0,0,0,0,0,0,0"

//6. 게임판 출력 양식은
//- X -
//- X O
//- - -
//7. 게임판정
//가로,세로,대각선 방향으로 O/X가 3개 연속되면, 승리하게 된다.

//개발순서
//서버 : int[][] map = new int[3][3];
//클라1 : "c1,0,0,O" 문자열을 서버로 전송
//서버 : "c1,0,0,O"을 꼼마 단위로 문자열배열로 만들고,
//       map 정수배열 값을 업데이트한다.
//서버 : "1,0,0,0,0,0,0,0,0" 문자열을 클라1에게 전송한다.
//클라1 : "1,0,0,0,0,0,0,0,0" 문자열을 꼼마단위로 분석해서,
//       map 정수배열 값을 업데이트한다.
//서버 : 게임판정을 해서 승리한 클라이언트 이름을 출력한다.
public class ticTacToe_server {
    public static int[][] map = new int[3][3];
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(
                    new InetSocketAddress("127.0.0.1", 5001) ); //서버 포트를 열어둠

            while( true ){
                System.out.println("서버가 연결을 기다리는 중...");
                Socket socket = serverSocket.accept(); //Blocking..대기중..
                //------------------------클라이언트 데이타를 수신한다.-------------------------------------------
                byte[] bytes = null;
                String message = null;
                InputStream is = socket.getInputStream();
                bytes = new byte[1024];
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");

                fill(message);
                print();

                //서버에서 클라로 데이타 보내기
                OutputStream os = socket.getOutputStream();
                message = makeReturn();
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();


                if(checkEnd()){ //승리 판정
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("서버 초기화 에러!");
        }

    }
    public static void fill(String s){
        String[] info = s.split(",");
        int userId = info[0].equals("c1")?1:2;
        if(userId==1)System.out.println("클라1으로부터 정보가 수신되었습니다.");
        else System.out.println("클라2으로부터 정보가 수신되었습니다.");
        map[Integer.parseInt(info[1])][Integer.parseInt(info[2])]=userId;
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
    public static String makeReturn(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]==0){
                    sb.append("0");
                }
                else if(map[i][j]==1){
                    sb.append("1");
                }
                else{
                    sb.append("2");

                }
                if(i==2 && j==2)
                    continue;
                sb.append(",");
            }
        }
        return sb.toString();
    }
    public static boolean checkEnd(){
        //가로/세로 체크
        for(int i=0;i<3;i++){
           if(map[i][0]==map[i][1] && map[i][1]==map[i][2]){
               if(map[i][0]==1){
                   System.out.println("C1 승리!");
                   return true;
               }else if(map[i][0]==2){
                   System.out.println("C2 승리!");
                   return true;
               }

           }

           if(map[0][i]==map[1][i] && map[1][i]==map[2][i]){
                if(map[0][i]==1){
                    System.out.println("C1 승리!!");
                    return true;
                }else if(map[0][i]==2){
                    System.out.println("C2 승리!!");
                    return true;
                }

            }
        }

        //대각선 체크
        if((map[0][0]==map[1][1] && map[2][2]==map[1][1])
                || map[0][2]==map[1][1] && map[1][1]==map[2][1]){
            if(map[1][1]==1){
                System.out.println("C1 승리!!!");
                return true;
            }else if(map[1][1]==2){
                System.out.println("C2 승리!!!");
                return true;
            }

        }

        return false;
    }
}
