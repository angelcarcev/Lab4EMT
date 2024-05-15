package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PizzaId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Price;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Price itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name="id", column = @Column(name="product_id", nullable = false))
    private PizzaId pizzaId;

    protected OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }
    public OrderItem(@NonNull PizzaId pizzaId, @NonNull Price itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.pizzaId = pizzaId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Price subtotal(){
        return itemPrice.multiply(quantity);
    }
}
