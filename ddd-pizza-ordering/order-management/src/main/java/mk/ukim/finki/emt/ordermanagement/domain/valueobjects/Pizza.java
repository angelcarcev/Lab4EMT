package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Price;

@Getter
public class Pizza implements ValueObject {

    private final PizzaId id;
    private final String name;
    private final Price price;

    public Pizza(){
        this.id=PizzaId.randomId(PizzaId.class);
        this.name= "";
        this.price = Price.valueOf(Currency.MKD,0);

    }
    @JsonCreator
    public Pizza(PizzaId id, String name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
