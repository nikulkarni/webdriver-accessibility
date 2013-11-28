package com.accessibility;

import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * 
 * @author nikulkarni
 *         Singleton, package protected class; could have used Guice but want to keep it DI library agnostic so that
 *         others can use this library
 */
class JsFactory {

	private static JsFactory INSTANCE = null;
	private static final String ACCESIBILITY_CDN_URL = "https://raw.github.com/GoogleChrome/accessibility-developer-tools/stable/dist/js/axs_testing.js";
	private static final String JQUERY_CDN_URL = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js";
	private String accessibility_content = null;

	private String jquery_content = null;

	private JsFactory() {

	}

	synchronized static JsFactory getInstance() throws IOException {
		if (INSTANCE == null) {
			INSTANCE = new JsFactory();
			INSTANCE.load();
		}
		return INSTANCE;
	}

	private void load() throws IOException {
		jquery_content = Jsoup.connect(JQUERY_CDN_URL).execute().body();
		accessibility_content = Jsoup.connect(ACCESIBILITY_CDN_URL).execute()
				.body();
	}

	String getAccessibility_content() {
		return accessibility_content;
	}

	String getJquery_content() {
		return jquery_content;
	}

}
