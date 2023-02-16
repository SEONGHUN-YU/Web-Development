package com.yu.feb161bb.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Baseball_t {
	private String gameAns;
	private int turn;
	private static final Baseball_t BASEBALL_T = new Baseball_t();

	private Baseball_t() {
	}

	public static Baseball_t getBB() {
		return BASEBALL_T;
	}

	public void pickAns() {
		// String : 참조형인 객체
		// 연산자는 stack영역이 대상
		// 문자열.charAt(인덱스) : 그 위치의 글자를 char로 리턴
		// char : 기본형
		int r = new Random().nextInt(976) + 12; // 0 ~ 999 X (12 ~ 987) <- 이게 사실 맞음
		gameAns = String.format("%03d", r); //
		if (gameAns.charAt(0) == gameAns.charAt(1) || gameAns.charAt(1) == gameAns.charAt(2)
				|| gameAns.charAt(2) == gameAns.charAt(0)) {
			pickAns();
		}
	}

	public void judge(HttpServletRequest req) {
		int s = 0;
		int b = 0;
		String userAns = req.getParameter("v");

		// 예시
		// userAns = 1 4 9
		// gameAns = 1 3 4
		for (int i = 0; i < 3; i++) { // userAns.length()
			for (int j = 0; j < 3; j++) { // gameAns.length()
				if (userAns.charAt(i) == gameAns.charAt(j)) {
					if (i == j) {
						s++;
					} else {
						b++;
					}
					break;
				}
			}
		}
		req.setAttribute("s", s);
		req.setAttribute("b", b);
		turn++;
		req.setAttribute("t", turn);
		if (s == 3) {
			turn = 0;
			pickAns();
		}
	}
}
