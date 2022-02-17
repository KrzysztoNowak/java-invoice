package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) throws IllegalArgumentException{
            this.addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity>0){
       this.products.put(product, quantity);
        }else throw new IllegalArgumentException();
    }

    public BigDecimal getSubtotal() {
           BigDecimal sum = BigDecimal.ZERO;
            for (Product product : this.products.keySet()) {
                Integer quantity = this.products.get(product);
                final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
                sum = sum.add(product.getPrice().multiply(quantityAsBigDecimal));
            } return sum;

    }



    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        for (Product product : this.products.keySet()) {
                Integer taxPercent = this.products.get(product);
                Integer quantity = this.products.get(product);
                //final BigDecimal taxPercentAsBigDecimal = BigDecimal.valueOf(taxPercent);
                final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
                final BigDecimal taxPercentAsBigDecimal = product.getTaxPercent();
                tax = tax.add(product.getPrice().multiply(taxPercentAsBigDecimal).multiply(quantityAsBigDecimal));
             // return BigDecimal.ZERO;
        } return tax;
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(Product product: this.products.keySet()) {
            Integer quantity = this.products.get(product);
            final BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
            total = total.add(product.getPrice().multiply(quantityAsBigDecimal));
        }return total.add(getTax());
   }

}
