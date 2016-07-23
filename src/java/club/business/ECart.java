/*  ECart.java
 *  Assignment 3
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.14: Created
 */

package club.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to model a cart
 * @author Zhenzhen Tang
 */
public class ECart implements Serializable {

    private ArrayList<Book> items;

    public ECart() {
        items = new ArrayList<Book>();
    }

    public ArrayList<Book> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(Book item) {
        boolean found = false;

        String code = item.getCode();
        Book lineItem = new Book();

        for (int i = 0; i < items.size(); i++) {
            lineItem = items.get(i);
            if (lineItem.getCode().equals(code)) {
                found = true;
                break;
            }
        }
        if (!found) {
            // create a new item with quantity of 1
            // do not use the method parameter "item"
            lineItem = new Book(item.getCode(),
                    item.getDescription(), 1);
            items.add(lineItem);
        } else {
            // add 1 to existing quantity
            int quantity = lineItem.getQuantity() + 1;
            lineItem.setQuantity(quantity);
        }
    }

    public void removeItem(Book item) {
        String code = item.getCode();
        for (int i = 0; i < items.size(); i++) {
            Book lineItem = items.get(i);
            if (lineItem.getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}