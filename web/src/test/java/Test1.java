import java.io.*;

public class Test1 {
    public static void main(String[] args) {
        File file = new File("D:\\source\\dream");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true){
                String str = bufferedReader.readLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
