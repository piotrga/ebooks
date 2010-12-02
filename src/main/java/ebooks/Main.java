package ebooks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class Main extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = request.getRequestURI();
        if (url.matches("/buy/[1-9]+")){
            Pattern pattern = Pattern.compile("/buy/([1-9]+)");
            buy(Integer.valueOf(pattern.matcher(url).group(1)));
        };
    }

    private void buy(Integer bookId) {
        try {
            URL url = new URL("_type=checkout-shopping-cart" +
                    "&item_name_1=Super%20Software%205000" +
                    "&item_description_1=Improves%20download%20speeds!" +
                    "&item_price_1=1.00" +
                    "&item_currency_1=GBP" +
                    "&item_quantity_1=1\n" +
                    "&shopping-cart.items.item-1.digital-content.display-disposition=OPTIMISTIC\n" +
                    "&shopping-cart.items.item-1.digital-content.description=Please%20go%20to%20&lt;a%20href=&quot;http://supersoft.example.com&quot;&gt;our%20website&lt;/a&gt;,\n" +
                    "%20%20and%20enter%20your%20access%20key%20so%20that%20you%20can%20download%20our%20software.\n" +
                    "&shopping-cart.items.item-1.digital-content.key=1456-1514-3657-2198\n" +
                    "&shopping-cart.items.item-1.digital-content.url=http://supersoft.example.com\n" +
                    "&_charset_");
            url.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
