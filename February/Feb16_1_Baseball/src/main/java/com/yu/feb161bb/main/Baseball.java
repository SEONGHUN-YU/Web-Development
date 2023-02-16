package com.yu.feb161bb.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Baseball {
	private int com;
	private int inning;
	private int count;

	private static final Baseball BASEBALL = new Baseball();

	private Baseball() {
	}

	public static Baseball getBASEBALL() {
		return BASEBALL;
	}

	public void resetScore(HttpServletRequest req) {
		inning = 1;
		count = 0;
		req.setAttribute("i", inning);
		req.setAttribute("c", count);
	}

	public void start(HttpServletRequest req) {
		while (true) {
			com = new Random().nextInt(900) + 100; // (0+100) ~ (899+100)까지
			String[] str = (com + "").split("");
			if (str[0].equals(str[1]) || str[0].equals(str[2]) || str[1].equals(str[2])
					|| (com + "").indexOf("0") != -1) {
				continue;
			} else {
				break;
			}
		}
	}

	public void play(HttpServletRequest req) {
		int strike = 0;
		int ball = 0;

		String comtemp = String.valueOf(com);
		String usertemp = req.getParameter("v");
		for (int i = 0; i < 3; i++) {
			if (comtemp.indexOf(usertemp.substring(i, i + 1)) == i) {
				strike++;
			} else if (comtemp.indexOf(usertemp.substring(i, i + 1)) != -1) {
				ball++;
			}
		}

		count++;
		req.setAttribute("i", inning);
		req.setAttribute("s", strike);
		req.setAttribute("b", ball);
		req.setAttribute("c", count);
		inning = strike == 3 ? ++inning : inning;
		count = strike == 3 ? count = 0 : count;

		if (inning > 9) {
			resetScore(req);
			start(req);
		} else if (strike == 3) {
			start(req);
		}
	}
}
