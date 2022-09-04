package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 자기자신이 숫자인데 자식이 있으면 안된다
 * 2. 맨 끝까지 확인했을 때 리프가 숫자가 아니면 안된다
 * */
public class SW_1233사칙연산유효성검사 {
	
	static boolean state;
	static int ans;
	static int op;
	static int cnt, idx, left, right; // 노드개수, 왼쪽자식번호, 오른쪽자식번호
	static int[] tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int i = 0;
			ans = 1;
			cnt = Integer.parseInt(br.readLine());
			tree = new int[cnt+1];
			state = false;

			for (i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				op = st.nextToken().charAt(0);
				tree[idx] = op;
			}
			
			for (i = 1; i <= cnt; i++) {
				if (!(tree[i] == '+' || tree[i] == '-' ||tree[i] == '*' ||tree[i] == '/')) { //본인이 숫자면
					if (i * 2 <= cnt) {
						check(i*2);
					}
					else if (i * 2 + 1 <= cnt) {
						check(i*2+1);
					}
					if (state == true) {
						ans = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	/* 
	 * 마지막노드가 숫자인지
	 * */
	static void check(int node) { //마지막원소 확인
			switch(tree[node]) {
			case '+': break;
			case '-': break;
			case '*': break;
			case '/': break;
			default:
				state = true;
				return;
			}
		
	}

}
