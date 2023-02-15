package com.yu.feb152ud.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

// 답을 뽑아서 Machine에 저장해 놓아야되니 -> static기반 탈락
// 답 뽑을 때 머신, 판정할 때 머신이 다르면 안 되지 -> singleton

public class Machine {
	private int answer;
	private int count;
	private static final Machine MACHINE = new Machine();

	private Machine() {
	}

	public static Machine getMACHINE() {
		return MACHINE;
	}

	public void pick() {
		count = 0;
		answer = new Random().nextInt(10000) + 1;
	}

	public void judge(HttpServletRequest req) {
		count++;
		int userAnswer = Integer.parseInt(req.getParameter("v"));
		if (userAnswer == answer) {
			req.setAttribute("uv", count + "번 만에 정답");
			pick();
		} else if (userAnswer > answer) {
			req.setAttribute("uv", "Up");
		} else {
			req.setAttribute("uv", "Down");
		}
	}
}
