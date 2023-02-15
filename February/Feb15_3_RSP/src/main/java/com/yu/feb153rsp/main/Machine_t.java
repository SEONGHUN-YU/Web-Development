package com.yu.feb153rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Machine_t {
	private int w;
	private int l;
	private int d;

	private static final Machine_t MACHINE = new Machine_t();

	private Machine_t() {

	}

	public static Machine_t getMACHINE() {
		return MACHINE;
	}

	public void start(HttpServletRequest req) {
		req.setAttribute("userHand", "start.gif");
		req.setAttribute("comHand", "start.gif");
	}

	public void play(HttpServletRequest req) {
		int userHand = Integer.parseInt(req.getParameter("v"));
		int comHand = new Random().nextInt(3) + 1;

		int t = userHand - comHand;
		if (t == 0) {
			req.setAttribute("result", "비김");
			d++;
		} else if (t == -1 || t == 2) {
			req.setAttribute("result", "유저 패");
			l++;
		} else {
			req.setAttribute("result", "유저 승");
			w++;
		}
		
//		String score = String.format("%d승 %d무 %d패", w, d, l);
//		req.setAttribute("score", score); // 이런 방법도!
		req.setAttribute("w", w); // MVC에서 V영역을 침범하지 않으려면
		req.setAttribute("l", l); // 이런 방식이 더 나을지도 모른다
		req.setAttribute("d", d);
		req.setAttribute("userHand", userHand + ".jpg"); // file명을 1,2,3 으로 바꾸고 이런식으로 처리
		req.setAttribute("comHand", comHand + ".jpg");
	}
}
