package mk.ukim.finki.emt.pizzacatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.pizzacatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Price;

import java.util.List;

@Entity
@Table(name="pizza")
public class Pizza extends AbstractEntity<PizzaId> {

    private String PizzaName;

    private int sales = 0;

    private Price price;

    //private List<String> ingredients;

    protected Pizza(){
        super(PizzaId.randomId(PizzaId.class));
    }

    public static Pizza build(String productName, Price price, int sales) {
        Pizza p = new Pizza();
        p.price = price;
        p.PizzaName = productName;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }


}
