package com.yu.feb151el.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Model {
	private static final Model MODEL = new Model();

	private Model() {
	}

	public static Model getMODEL() {
		return MODEL;
	}

	public void getInfo(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("euc-kr");
			String n = req.getParameter("nn");
			String b = req.getParameter("bb").substring(0, 4);

			Date year = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String now = sdf.format(year);

			int birthYear = Integer.parseInt(b);
			int nowYear = Integer.parseInt(now);

			int result = nowYear - birthYear + 1;

			Human d = new Human(n, result);
			req.setAttribute("dto", d);

			req.setAttribute("a", 10); // 연습용

			ArrayList<Human> humans = new ArrayList<>();
			humans.add(new Human("최길동", 10));
			humans.add(new Human("김길동", 20));
			humans.add(new Human("이길동", 30));
			req.setAttribute("humans", humans); // 연습용

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
