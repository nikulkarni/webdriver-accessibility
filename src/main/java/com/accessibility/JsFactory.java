package com.accessibility;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

/**
 * @author nikulkarni
 *         Singleton, package protected class;
 *         could have used Guice but want to keep it DI library agnostic so that others can use this library
 */
class JsFactory {

    ApplicationProperties applicationProperties;

    private static JsFactory INSTANCE = null;
    private String accessibility_content = null;
    private Logger log = Logger.getLogger(JsFactory.class);

    private String jquery_content = null;

    private JsFactory() {
        try {
            this.applicationProperties = new ApplicationProperties("application.properties");
        } catch (IOException e) {
            log.warn(e);
        }
    }

    synchronized static JsFactory getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new JsFactory();
            INSTANCE.load();
        }
        return INSTANCE;
    }

    private void load() throws IOException {
        jquery_content = Jsoup.connect(applicationProperties.getProperty("jquerycdnurl")).ignoreContentType(true).execute().body();
        accessibility_content = Jsoup.connect(applicationProperties.getProperty("applicationcdnurl")).ignoreContentType(true).execute().body();
    }

    String getAccessibility_content() {
        return accessibility_content;
    }

    String getJquery_content() {
        return jquery_content;
    }

}
