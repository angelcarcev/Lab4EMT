package mk.ukim.finki.emt.pizzacatalog.services;

import mk.ukim.finki.emt.pizzacatalog.domain.models.Pizza;
import mk.ukim.finki.emt.pizzacatalog.domain.models.PizzaId;
import mk.ukim.finki.emt.pizzacatalog.services.form.PizzaForm;

import java.util.List;

public interface PizzaService {
    Pizza findById(PizzaId id);
    Pizza createProduct(PizzaForm form);
    Pizza orderItemCreated(PizzaId productId, int quantity);
    Pizza orderItemRemoved(PizzaId productId, int quantity);
    List<Pizza> getAll();

}
