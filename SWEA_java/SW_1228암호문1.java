package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1228암호문1 {
	
	static String[] cmd;
	static int[] num;
	static LinkedList<Integer> list; //링크드리스트
	static int N, cmdCnt; //입력받는 수들 개수, 명령개수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader는 맨 처음 한번만 선언!!!!!!!!!
		
		for (int tc = 1; tc <= 10; tc++) {
			//입력
			list = new LinkedList<>();
			N = Integer.parseInt(br.readLine()); //1. N입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { //2. list입력
				int tmp = Integer.parseInt(st.nextToken());
				list.add(tmp);
			}
			cmdCnt = Integer.parseInt(br.readLine()); //3. 명령개수 입력
			String str = br.readLine(); //4. 명령 입력
			cmd = new String[cmdCnt + 1];
			cmd = str.split("I ");
			
			//바꾸기
			for (int i = 1; i <= cmdCnt; i++) {
				st = new StringTokenizer(cmd[i]);
				int idx = Integer.parseInt(st.nextToken()); //바꿔줄 시작 위치 
				int cnt = Integer.parseInt(st.nextToken()); //바꿀 개수
				num = new int[cnt];
				for (int j = 0; j < cnt; j++) {
					num[j] = Integer.parseInt(st.nextToken());
					list.add(idx + j, num[j]);
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
			

	}

}
