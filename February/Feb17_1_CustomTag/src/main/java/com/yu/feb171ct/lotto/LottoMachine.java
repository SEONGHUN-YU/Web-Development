package com.yu.feb171ct.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class LottoMachine {
	private Random core;
	private static final LottoMachine LOTTOMACHINE = new LottoMachine();

	// C : []밖에 없음
	// 번호들 : [], List, Set, Map

	private LottoMachine() {
		core = new Random();
	}

	public static LottoMachine getLM() {
		return LOTTOMACHINE;
	}

	public void pick(HttpServletRequest req) {
		HashSet<Integer> hs = new HashSet<>();
		while (hs.size() < 6) {
			hs.add(core.nextInt(45) + 1);
		}
		ArrayList<Integer> al = new ArrayList<>(hs);
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}); // al 정렬까지
		ArrayList<String> lotto = new ArrayList<>();
		for (Integer s : al) {
			lotto.add(String.format("img/lotto/ball_%d.png", s));
		} // al을 String으로 바꿔줌
		req.setAttribute("lottoResult", lotto);
	}
}
