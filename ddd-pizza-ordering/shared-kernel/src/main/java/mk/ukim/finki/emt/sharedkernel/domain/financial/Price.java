package mk.ukim.finki.emt.sharedkernel.domain.financial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
@Embeddable
@Getter
public class Price implements ValueObject {
    @Enumerated(value = EnumType.STRING)
    private final Currency currency;

    private final double amount;

    protected Price(){
        this.amount = 0.0;
        this.currency = null;
    }

    public Price(@NonNull Currency currency, @NonNull double amount){
        this.currency=currency;
        this.amount=amount;
    }

    public static Price valueOf(Currency currency, int amount) {
        return new Price(currency,amount);
    }

    public Price add(Price money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Price(currency,amount + money.amount);
    }

    public Price subtract(Price money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Price(currency,amount - money.amount);
    }

    public Price multiply(int m)  {
        return new Price(currency,amount*m);
    }



}
