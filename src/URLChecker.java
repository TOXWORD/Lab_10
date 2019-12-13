import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class URLChecker {

    private static final String pathIn = "input.html";

    public void checkHTML() throws Exception {

        try (Scanner sc = new Scanner(new File(pathIn))) {
            String sLink;
            URL link;

            while (sc.hasNextLine()) {

                sLink = sc.nextLine();
                link = new URL(sLink);

                try (InputStream is = link.openStream()) {
                    Scanner scanner = new Scanner(is);
                    String responseBody = scanner.useDelimiter("\\A").next();

                    if (!responseBody.contains("<title>") || !responseBody.contains("</title>")) {
                        return;
                    }
                    String res = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
                    if (!res.equals("")) {
                        System.out.println(res);
                    }
                }
            }
        }
    }

    public void checkFile() throws IOException {
        try (Scanner sc = new Scanner(new File(pathIn))) {
            String sLink;
            URL link;

            while (sc.hasNextLine()) {

                sLink = sc.nextLine();
                link = new URL(sLink);

                HttpURLConnection c = (HttpURLConnection) link.openConnection();
                c.setRequestMethod("HEAD");

                if (c.getContentLength() != -1) {
                    System.out.println(c.getContentLength());
                }
                else {
                    System.out.println("none");
                }
                c.disconnect();
            }
        }
    }
}


