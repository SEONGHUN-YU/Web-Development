package com.yu.feb171ct.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherDAO {
	private static final WeatherDAO WEATHERDAO = new WeatherDAO();

	private WeatherDAO() {
	}

	public static WeatherDAO getDAO() {
		return WEATHERDAO;
	}

	public void getWeather(HttpServletRequest req) {
		// XML파싱해서
		// ArrayList<Weather>로 만들어 보내고
		// .jsp에서 EL+JSTL로 나오게 해보기

		HttpsURLConnection huc = null;
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
			xpp.setInput(isr);

			ArrayList<Weather> ws = new ArrayList<>();
			int type = xpp.getEventType();
			String t = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					t = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (t.equals("hour")) {
						xpp.getText();
					} else if (t.equals("temp")) {
						xpp.getText();
					} else if (t.equals("wfKor")) {
						xpp.getText();
					}
				} else if (type == XmlPullParser.END_TAG) {
					t = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
