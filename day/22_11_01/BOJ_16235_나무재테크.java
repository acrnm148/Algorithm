package a22_11_01;

import java.io.*;
import java.util.*;

public class BOJ_16235_나무재테크 {
	
	static int ans, N,M,K;
	static int[][] nutrient, regularNut; //총 양분, 정기양분
	static List<Tree> trees; //나무
	static Queue<Tree> dead; //죽은 나무
	
	static int[] dy = {-1,-1,-1, 0, 0,  1, 1, 1};
	static int[] dx = {-1, 0, 1, -1,1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		regularNut = new int[N][N];
		nutrient = new int[N][N];
		trees = new ArrayList<> ();
		dead = new ArrayDeque<> ();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				regularNut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int y= Integer.parseInt(st.nextToken());
			int x= Integer.parseInt(st.nextToken());
			int age= Integer.parseInt(st.nextToken());
			trees.add(new Tree(y-1, x-1, age)); 
		} //입력 끝
		
		ans = 0;
		solution();
		System.out.println(ans);
	}
	
	static void solution() {
		for (int year=0; year<K; year++) {
			spring();
			summer();
			autumn();
			winter();
		}
		ans = trees.size();
	}
	
	static void spring() { //양분 먹음
		for (int i=0; i<trees.size(); i++) {
			int y = trees.get(i).y;
			int x = trees.get(i).x;
			int age = trees.get(i).age;
			// 나무가 양분을 먹음
			if ( nutrient[y][x] >= trees.get(i).age ) {
				nutrient[y][x] -= trees.get(i).age;
				trees.get(i).age += 1; // 나무 나이 1 증가
				
			} else { // 양분 부족할 때 나무 죽음
				dead.offer(trees.remove(i));
			}
		}
	}
	
	static void summer() { // 나무 죽고 양분
		while (!dead.isEmpty()) {
			Tree cur = dead.poll();
			nutrient[cur.y][cur.x] += cur.age/2;
		}
	}

	static void autumn() { //나무 추가
		Queue<Tree> temp = new ArrayDeque<> ();
		int size = trees.size();
		for (Tree tree : trees) {
			for (int d=0; d<8; d++) {
				int ny= tree.y+dy[d];
				int nx= tree.x+dx[d];
				if (ny<0 || ny>=N || nx<0 || nx>=N) continue;
				temp.offer(new Tree(ny,nx,1));
			}
		}
		while (!temp.isEmpty()) {
			trees.add(temp.poll());
		}
	}

	static void winter() { //양분 추가
		for (int y=0; y<N; y++) {
			for (int x=0; x<N; x++) {
				nutrient[y][x] += regularNut[y][x];
			}
		}
	}
	
	//리스트도 이걸로 정렬이 되나?
	static class Tree implements Comparable<Tree> {
		int y, x, age;
		Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}
}
