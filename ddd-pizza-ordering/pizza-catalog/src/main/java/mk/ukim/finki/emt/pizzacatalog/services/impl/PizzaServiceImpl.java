package mk.ukim.finki.emt.pizzacatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.pizzacatalog.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.pizzacatalog.domain.models.Pizza;
import mk.ukim.finki.emt.pizzacatalog.domain.models.PizzaId;
import mk.ukim.finki.emt.pizzacatalog.domain.repository.PizzaRepository;
import mk.ukim.finki.emt.pizzacatalog.services.PizzaService;
import mk.ukim.finki.emt.pizzacatalog.services.form.PizzaForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza findById(PizzaId id) {
        return pizzaRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Pizza createProduct(PizzaForm form) {
        Pizza p = Pizza.build(form.getProductName(),form.getPrice(),form.getSales());
        pizzaRepository.save(p);
        return p;
    }

    @Override
    public Pizza orderItemCreated(PizzaId productId, int quantity) {
        Pizza p = pizzaRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        p.addSales(quantity);
        pizzaRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Pizza orderItemRemoved(PizzaId productId, int quantity) {
        Pizza p = pizzaRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        p.removeSales(quantity);
        pizzaRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }
}
