package com.yu.feb171ct.book;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BookSearchDAO {
	private static final BookSearchDAO BOOKSEARCHDAO = new BookSearchDAO();

	private BookSearchDAO() {
	}

	public static BookSearchDAO getBSDAO() {
		return BOOKSEARCHDAO;
	}

	public void search(HttpServletRequest req) {

		HttpsURLConnection huc = null;
		try {
			String name = req.getParameter("book");
			name = URLEncoder.encode(name, "utf-8"); // 한글처리 내가 해줘야지, Tomcat이 안 해줌

			URL u = new URL("https://dapi.kakao.com/v3/search/book?query=" + name);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK " + StudyKey.KAKAO_API);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			String data = br.readLine();
			JSONParser jp = new JSONParser();
			JSONObject allData = (JSONObject) jp.parse(data);
			JSONArray docs = (JSONArray) allData.get("documents");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ArrayList<Book> bs = new ArrayList<>();
			Book bk = null;
			JSONObject myTarget = null;
			for (int i = 0; i < docs.size(); i++) {
				myTarget = (JSONObject) docs.get(i);
				bk = new Book();
				bk.setTitle(String.valueOf(myTarget.get("title")));
				bk.setAuthors(((JSONArray) myTarget.get("authors")).toString().replaceAll("\"", "").replaceAll(",", " & "));
				bk.setDate(sdf.parse(myTarget.get("datetime").toString()));
				bk.setPrice(myTarget.get("price").toString());
				bk.setThumbnail(myTarget.get("thumbnail") + "");
				bs.add(bk);
			}
			req.setAttribute("books", bs);
			
//			Object p = myTarget.get("price"); <- JSON 오브젝트 to int (full 과정)
//			Integer pp = (Integer) p;
//			int ppp = pp.intValue();
//			bk.setPrice(ppp);
//			------------------------------
//			Object dt = myTarget.get("datetime"); <- JSON 오브젝트 to Date (full 과정)
//			String dtdt = (String) dt;
//			String dtdtdt = dtdt.split("T")[0];
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			bk.setDate(sdf.parse(dtdtdt));
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
