package Project;

import javafx.scene.control.TextField;

public class NewThread extends Thread {
    private TextField showText;
    private String URL;
    private int position;
    private Connect toConnect;
    private String[] toShow;

    public NewThread(TextField showText, String URL, int position) {
        this.showText = showText;
        this.URL = URL;
        this.position = position;
    }

    public void run() {
        while(true) {
            this.toConnect = new Connect(this.URL);
            this.toShow = this.toConnect.ArrTitle;
            this.showText.setText(this.toShow[this.position]);

            try {
                Thread.sleep(1800000L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
    }
}
