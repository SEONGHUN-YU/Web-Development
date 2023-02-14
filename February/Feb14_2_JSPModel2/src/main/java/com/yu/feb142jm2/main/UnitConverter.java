package com.yu.feb142jm2.main;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class UnitConverter {
	private HashMap<String, String[]> units;
	private static final UnitConverter UC = new UnitConverter();

	private UnitConverter() {
		units = new HashMap<>();
		units.put("len", new String[] { "cm", "inch" });
		units.put("size", new String[] { "㎡", "평" });
		units.put("temp", new String[] { "℃", "℉" });
		units.put("spd", new String[] { "km/h", "mi/h" });
	}

	public static UnitConverter getUC() {
		return UC;
	}

	public void convert(HttpServletRequest request) {
		double num = Double.parseDouble(request.getParameter("changevalue"));
		String what = request.getParameter("changeresult");

		double result = 0;
		if (what.equals("len")) {
			result = num * 0.393701;
		} else if (what.equals("size")) {
			result = num * 0.3025;
		} else if (what.equals("temp")) {
			result = num * 1.8 + 32;
		} else {
			result = num * 0.621371;
		}
		
		UCResult ucr = new UCResult(num, what, units.get(what)[0], result, units.get(what)[1]);
		request.setAttribute("ucr", ucr);
	}

	private String changeUnit(double num) {
		return String.format("%.1f", num);
	}
}
