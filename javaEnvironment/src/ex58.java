import java.io.FileWriter;
import java.io.IOException;

public class ex58 {
    //방법1
    //try-with-resource: try문을 벗어나면 자동으로 close()를 해줌.
    //AutoCloseable 인터페이스를 구현한 메소드만 가능.
    public static void main(String[] args) throws IOException {
        try(FileWriter fileWriter = new FileWriter("data.txt")){
            fileWriter.write("Hello World!");
        }catch (IOException e){
            e.printStackTrace();
        }
        //여기서 자동으로 close


        //방법2 - finally 안에 try-catch 중첩 구현
        FileWriter fw = null;
        try{
            fw = new FileWriter("data2.txt");
            fw.write("Hello Java");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        //방법3 - main에 IOException
        FileWriter fw2 = null;
        try{
            fw2 = new FileWriter("data2.txt");
            fw2.write("Hello Java");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fw2.close();
        }
    }
}
