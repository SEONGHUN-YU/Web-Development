package com.yu.feb171ct.jstlc;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest req) {
		int x = new Random().nextInt(10);
		req.setAttribute("xxx", x);

		String[] str = { "1", "f", "v", "34" };
		req.setAttribute("str", str);

		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product("종이컵", 50));
		products.add(new Product("마이크", 50000));
		products.add(new Product("키보드", 150000));
		req.setAttribute("ps", products);
	}
}
