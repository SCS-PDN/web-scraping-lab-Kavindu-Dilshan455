import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        // TODO: Scrape a URL and print its title

        String url = "https://bbc.com";
    	
    	try {
    		Document doc = Jsoup.connect(url).get();
    		System.out.println("title:"+doc.title()+"\n");
    		
    		
    		System.out.println(" \nLinks ");
    		for(Element link : doc.select("a[href]")) {
    			System.out.println(link.text()+"--"+link.aatr("href"))
    		}
    	}catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public class newsItem{
    	String headline;
    	String date;
    	String author;
    	
    	NewsItem(String h, String d, String a){
    		headline = h;
    		date = d;
    		author = a;
    		
    	}
    	
    	public String toString() {
    		return "headline: " + headline+ "\ndate:"+date+"\nauthor:"+author+"\n";
    	}
    }
}
