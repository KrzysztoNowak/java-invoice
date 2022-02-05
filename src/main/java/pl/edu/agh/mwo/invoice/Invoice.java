package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public void addProduct(Product product) {
        this.addProduct(product,1);
    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for(Product product: this.products.keySet()) {
            Integer quantity = this.products.get(product);
            final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
            sum = sum.add(product.getPrice().multiply(quantityAsBigDecimal));
        }return sum;
    }


    public BigDecimal getTax() {
//        BigDecimal tax = BigDecimal.ZERO;
//        for(Product product: this.products.keySet()) {
//            Integer quantity = this.products.get(product);
//            final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
//            tax = tax.add(product.getPrice().multiply(quantityAsBigDecimal));
//        }return tax;
        return BigDecimal.ZERO;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for(Product product: this.products.keySet()) {
            Integer quantity = this.products.get(product);
            final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
            total = total.add(product.getPrice().multiply(quantityAsBigDecimal));
        }return total;


    }
}
