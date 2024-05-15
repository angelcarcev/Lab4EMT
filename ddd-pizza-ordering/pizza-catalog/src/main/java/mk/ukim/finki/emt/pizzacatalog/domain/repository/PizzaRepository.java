package mk.ukim.finki.emt.pizzacatalog.domain.repository;

import mk.ukim.finki.emt.pizzacatalog.domain.models.Pizza;
import mk.ukim.finki.emt.pizzacatalog.domain.models.PizzaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, PizzaId> {
}
