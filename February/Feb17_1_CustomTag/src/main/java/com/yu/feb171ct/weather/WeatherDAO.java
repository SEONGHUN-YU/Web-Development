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
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
			xpp.setInput(isr);

			ArrayList<Weather> ws = new ArrayList<>();
			Weather w = null;
			int type = xpp.getEventType();
			String t = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("data")) {
						w = new Weather();
					}
				} else if (type == XmlPullParser.TEXT) {
					if (t.equals("hour")) {
						w.setHour(xpp.getText());
					} else if (t.equals("temp")) {
						w.setTemp(xpp.getText());
					} else if (t.equals("wfKor")) {
						w.setWfKor(xpp.getText());
						if (xpp.getText().equals("맑음")) {
							w.setImg("sun.png");
						} else if (xpp.getText().equals("흐림") || xpp.getText().equals("구름 많음")) {
							w.setImg("cloud.png");
						} else if (xpp.getText().equals("눈")) {
							w.setImg("snow.png");
						} else {
							w.setImg("rain.png");
						}
					}
				} else if (type == XmlPullParser.END_TAG) {
					t = "";
					if (xpp.getName().equals("data")) {
						ws.add(w);
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}
			req.setAttribute("ws", ws); // ArrayList채로 보내기
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
