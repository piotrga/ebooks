package ebooks;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends javax.servlet.http.HttpServlet {
    private BookStore bookStore = new BookStore();
    private String googleCheckoutAPIUrl = "http://localhost:8080/rediectme?";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Request: "+ request.getQueryString());
        response.sendRedirect("http://localhost:8080/redirectedTo");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = request.getRequestURI();

        if (url.matches("/buy/[1-9]+")){
            Matcher matcher = matcher(url, "/buy/([1-9]+)");
            buy(BookId.Of(matcher.group(1)), response);
        }
    }

    private Matcher matcher(String url, String regex) {
        Pattern buyPattern = Pattern.compile(regex);
        Matcher matcher = buyPattern.matcher(url);
        matcher.matches();
        return matcher;
    }

    private void buy(BookId bookId, HttpServletResponse response) {
        Book book = bookStore.find(bookId);
        try {
            URL url = new URL(googleCheckoutAPIUrl + book.toBuyNowQueryString() );
            URL redirect = postExpectedRedirect(url);
            response.sendRedirect(redirect.toExternalForm());
        } catch (Exception e) {
            throw new RuntimeException("Can not redirect to google checkout", e);
        }
    }

    private URL postExpectedRedirect(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.connect();
        System.out.println("Response code: " + connection.getResponseCode());
        if (connection.getResponseCode() != 302) throw new RuntimeException("Expected redirect but server returned "+connection.toString());
        return new URL(connection.getHeaderField("Location"));
    }
}
