package mk.ukim.finki.emt.pizzacatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Price;

@Data
public class PizzaForm {
    private String productName;
    private Price price;
    private int sales;

}
