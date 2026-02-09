import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {

        try {

            String url = "https://timesofindia.indiatimes.com/rssfeedstopstories.cms";


            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();


            Elements headlines = document.select("item > title");

            System.out.println("Times of India Headlines:\n");

            int count = 1;
            for (Element headline : headlines) {
                System.out.println(count + ". " + headline.text());
                count++;

                if (count > 15) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
