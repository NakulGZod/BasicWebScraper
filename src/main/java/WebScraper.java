import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {

        try {
        
            String url = "https://www.bbc.com/news";


            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();


            Elements headlines = document.select("h2");

            System.out.println("BBC News Headlines:\n");

            int count = 1;
            for (Element headline : headlines) {
                String text = headline.text();


                if (!text.isEmpty()) {
                    System.out.println(count + ". " + text);
                    count++;
                }


                if (count > 15) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred while scraping: " + e.getMessage());
        }
    }
}
