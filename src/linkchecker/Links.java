package linkchecker;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Links {
	
	private int i = 0;

	public String[] getLinks(String link) throws IOException {

    	Document mainPage = Jsoup.connect(link).get();
        Elements links = mainPage.select("a[href]");
        System.err.println("Links: " + links.size() + "\nMAIN PAGE: " + link);
        String[] pages = new String[links.size()];

        links.forEach(page -> {
        	pages[i] = page.attr("abs:href");

            i++;

        });
        return pages;
    }

}