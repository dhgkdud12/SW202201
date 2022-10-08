package DAY05.P1837;

import java.util.*;
import java.io.*;

// 질문 복사
public class Main {
    static ArrayList<Integer> primes = new ArrayList<>();

    static void prime(int k){
        boolean[] isPrime = new boolean[k];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i*i<k;i++){
            if(isPrime[i]){
                for(int j = i*i;j<k;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 0;i<k;i++){
            if(isPrime[i]) primes.add(i);
        }
    }

    static boolean isDivided(String p, int n){
        int r = 0;
        for(int i = 0;i<p.length();i++){
            r = (r * 10 + (p.charAt(i) - '0')) % n;
        }
        if(r==0) return true;
        else return false;
    }

    static void isGood(String p){
        for(int i = 0;i<primes.size();i++){
            if(isDivided(p, primes.get(i))){
                System.out.println("BAD" + " " + primes.get(i));
                return;
            }
        }
        System.out.println("GOOD");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String p = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        prime(k);

        isGood(p);
    }
}
