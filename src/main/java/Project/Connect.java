package Project;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Connect {
    public String[] ArrTitle;
    public Document document;

    public Connect(String url) {
        try {
            this.document = Jsoup.connect(url).get();
            String title = this.document.text();
            Document doc = Jsoup.parse(title);
            title = doc.text();
            this.ArrTitle = title.split(" ");
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}