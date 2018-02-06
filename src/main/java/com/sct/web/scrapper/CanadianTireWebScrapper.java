package com.sct.web.scrapper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scrapes items on CanadianTire website.
 * @author alviny
 *
 */
public class CanadianTireWebScrapper {
	private static final Logger logger = Logger.getLogger(CanadianTireWebScrapper.class);
	private static final String url = "http://canadiantire.ca";
	
	public void scrape() throws IOException {
		logger.info("Scrapping CanadianTire..");
		String toolUrl = "http://www.canadiantire.ca/en/tools-hardware/power-tools/drills-drivers/cordless-drills.html";
		Document doc = Jsoup.connect(toolUrl).get();

		Elements items = doc.select("div.temporary-grid-item");
		for (Element item : items) {
			logger.info("Item:" + item);
		  
		}
		logger.info("Scrapping CanadianTire..done");


	}
	
	public static void main(String[] args) throws Exception {
		CanadianTireWebScrapper scrapper = new CanadianTireWebScrapper();
		scrapper.scrape();
	}

}
