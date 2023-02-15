package com.yu.feb153rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Machine {
	private int win;
	private int lose;
	private int draw;

	private static final Machine MACHINE = new Machine();

	private Machine() {
	}

	public static Machine getMACHINE() {
		return MACHINE;
	}

	public void start(HttpServletRequest req) {
		win = 0;
		lose = 0;
		draw = 0;
		req.setAttribute("user", "start.gif");
		req.setAttribute("com", "start.gif");
		req.setAttribute("result", "판정");
		req.setAttribute("win", win);
		req.setAttribute("lose", lose);
		req.setAttribute("draw", draw);
	}

	public void pickAndJudge(HttpServletRequest req) {
		int userPick = Integer.parseInt(req.getParameter("v"));
		int answer = new Random().nextInt(3) + 1;

		if (userPick == 1) {
			req.setAttribute("user", "s.jpg");
		} else if (userPick == 2) {
			req.setAttribute("user", "r.jpg");
		} else {
			req.setAttribute("user", "p.jpg");
		}

		if (answer == 1) {
			req.setAttribute("com", "s.jpg");
		} else if (answer == 2) {
			req.setAttribute("com", "r.jpg");
		} else {
			req.setAttribute("com", "p.jpg");
		}
		
		if (userPick - answer == 0) {
			draw++;
			req.setAttribute("result", "무승부");
		} else if (userPick - answer == -1 || answer - userPick == 2) {
			req.setAttribute("result", "패배");
			lose++;
		} else {
			req.setAttribute("result", "승리");
			win++;
		}
	}

	public void score(HttpServletRequest req) {
		req.setAttribute("win", win);
		req.setAttribute("lose", lose);
		req.setAttribute("draw", draw);
	}
}
