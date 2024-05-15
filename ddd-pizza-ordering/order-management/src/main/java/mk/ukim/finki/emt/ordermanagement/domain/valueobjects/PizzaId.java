package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class PizzaId extends DomainObjectId {

    private PizzaId() {
        super(PizzaId.randomId(PizzaId.class).getId());
    }

    public PizzaId(String uuid) {
        super(uuid);
    }

}
