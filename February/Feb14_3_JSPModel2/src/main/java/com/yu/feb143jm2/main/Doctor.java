package com.yu.feb143jm2.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 멤버변수가 없다 -> 저장할 공간이 필요없다
// -> 램 굳이 써야하나? -> 객체를 안 만들어도 된다
// -> static method 기반 -> Doctor.test();

// 멤버변수가 있다 -> 저장할 공간이 필요
// -> 램을 써야한다 -> 객체를 만들어야 된다
// -> 일반 method
// static method에서 static이 아닌 거 못 씀

// -> Doctor가 여러개 필요하지는 않음 (계속 요청 들어올 때마다 생성하고 삭제하고 하면 난리남)
// -> singleton패턴 : only one객체
public class Doctor {
	private static final Doctor DOCTOR = new Doctor();

	private Doctor() {
	}

	public static Doctor getDoctor() {
		return DOCTOR;
	}

	public void calculate(HttpServletRequest req) {
		try {
			MultipartRequest mr = new MultipartRequest(req, req.getSession().getServletContext().getRealPath("img"),
					31457280, "euc-kr", new DefaultFileRenamePolicy());
			String n = mr.getParameter("name"); // req말고 mr로 받아야 하는 거 조심
			double h = Double.parseDouble(mr.getParameter("height"));
			double w = Double.parseDouble(mr.getParameter("weight"));
			String i = URLEncoder.encode(mr.getFilesystemName("img"), "euc-kr").replace("+", " "); // input name명
			double hToM = h / 100;
			double bmi = w / (hToM * hToM);
			String result = null;
			if (bmi >= 35) {
				result = "고도 비만";
			} else if (bmi >= 30) {
				result = "중도 비만";
			} else if (bmi >= 25) {
				result = "경도 비만";
			} else if (bmi >= 23) {
				result = "과체중";
			} else if (bmi >= 18.5) {
				result = "정상";
			} else {
				result = "저체중";
			}
			Guest g = new Guest(n, h, w, i, bmi, result); // 객체형태로 보냄
			req.setAttribute("gg", g);
		} catch (Exception e) {
			e.printStackTrace(); // 모든 
		}
	}
}
