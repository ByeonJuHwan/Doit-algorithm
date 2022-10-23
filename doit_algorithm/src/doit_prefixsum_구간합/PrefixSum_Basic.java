package doit_prefixsum_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum_Basic {

    public static void main(String[] args) throws IOException {
        // 백준 11659번 구간합 구하기
        
        // 0. 필요한 도구들 선언해 놓기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (br.readLine()); // 이미 한줄 읽은 상태
        
        // 1. 데이터의개수, 질의 개수 받기
        int dataNum = Integer.parseInt(st.nextToken()); // 5 가 들어감
        int QNum = Integer.parseInt(st.nextToken()); // 3이 들어감
        long S[] = new long [dataNum+1];
        // 2. 구간합을 구할 배열 데이터 받기
        st = new StringTokenizer (br.readLine());
       
        // 3. 합 배열 미리 만들어 놓기
        for(int i =1; i<= dataNum; i++) {
            // 1부터 5까지 반복하는 반복문으로 합배열 생성
            S[i] = S[i-1]+Integer.parseInt(st.nextToken());
        }
        // 4. 질의 개수에 맞춰서 구간합 출력하기
        for(int q=0; q<QNum ; q++) {
            st = new StringTokenizer (br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j]-S[i-1]);
        }
    }

}
