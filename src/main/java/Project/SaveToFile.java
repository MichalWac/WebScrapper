package Project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveToFile {
    public SaveToFile(String URL, Integer position) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("data.txt");
        zapis.println(URL);
        zapis.println(position);
        zapis.close();
    }
}
