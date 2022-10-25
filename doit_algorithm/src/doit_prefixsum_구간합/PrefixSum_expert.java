package doit_prefixsum_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum_expert {

	public static void main(String[] args) throws IOException {
		// 백준 11660 번 구간합구하기 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄 읽어서 4 3 받아옴
		int N = Integer.parseInt(st.nextToken()); // 정사각형 배열의 한변의 길이
		int QNum = Integer.parseInt(st.nextToken()); // 질의의 개수 for문의 반복 횟수
		
		// 2차원 배열 생성
		int Rectangle[][] = new int [N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); // 2차원배열을 읽어옴
			for(int j=1; j<=N; j++) {
				Rectangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 구간합 공식으로 구간합 구하기
		int Sum[][] = new int [N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				Sum[i][j] = Sum[i][j-1]+Sum[i-1][j]-Sum[i-1][j-1]+Rectangle[i][j]; // 구간합 배열 만들기
			}
		}
		
		// 구간합 배열로 답 구하기
		for(int i=0; i<QNum; i++) {
			st = new StringTokenizer(br.readLine()); // 첫번째 질문 읽음
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = Sum[x2][y2] - Sum[x1-1][y2] - Sum[x2][y1-1] + Sum[x1-1][y1-1]; // 구간합 배열로 값 구하기
			System.out.println(result);
		}
		
		
	}

}
