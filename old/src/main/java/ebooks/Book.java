package ebooks;

public class Book {
    public String toBuyNowQueryString() {
           return "_type=checkout-shopping-cart" +
                    "&item_name_1=Super%20Software%205000" +
                    "&item_description_1=Improves%20download%20speeds!" +
                    "&item_price_1=1.00" +
                    "&item_currency_1=GBP" +
                    "&item_quantity_1=1" +
                    "&shopping-cart.items.item-1.digital-content.display-disposition=OPTIMISTIC" +
                    "&shopping-cart.items.item-1.digital-content.description=Please%20go%20to%20&lt;a%20href=&quot;http://supersoft.example.com&quot;&gt;our%20website&lt;/a&gt;," +
                    "%20%20and%20enter%20your%20access%20key%20so%20that%20you%20can%20download%20our%20software." +
                    "&shopping-cart.items.item-1.digital-content.key=1456-1514-3657-2198" +
                    "&shopping-cart.items.item-1.digital-content.url=http://supersoft.example.com" +
                    "&_charset_";
    }
}
