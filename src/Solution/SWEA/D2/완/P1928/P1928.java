package Solution.SWEA.D2.완.P1928;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

// https://injunech.tistory.com/257
public class P1928 {
    static int T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1928/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            
            // Base64 디코딩
            Base64.Decoder decoder = Base64.getDecoder();
            
            // Decoder#decode(bytes[] src)
            byte[] decode = decoder.decode(str);
            
            //디코딩한 문자열을 표시
            String decodedString = new String(decode, "UTF-8");

            System.out.println("#"+(i+1)+" "+decodedString);
        }
    }
}
