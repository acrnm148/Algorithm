package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1228암호문1_prof {
	

	static int N, M;
	static List<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			//입력
			list.clear(); //연결리스트 이렇게 초기화
			N = Integer.parseInt(br.readLine()); //1. N입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { //2. list입력
				list.add(st.nextToken()); //연산이 아니라서 String으로 원소 받아도 됨
			}
			
			M = Integer.parseInt(br.readLine()); //3. 명령개수 입력
			st = new StringTokenizer(br.readLine());
			//바꾸기
			for (int i = 1; i <= M; i++) { //split해줄 필요가 없구나
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken()); //바꿔줄 시작 위치 
				int cnt = Integer.parseInt(st.nextToken()); //바꿀 개수
				int count = idx + cnt;
				for (int j = idx; j < count; j++) {
					list.add(j, st.nextToken());
				}
			}
			
			//출력이 많으니 빌더에 넣어주고 한번에 출력
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
