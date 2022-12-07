package be.thomasmore.bookserver.repositories;

import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;


public interface SerieRepository extends CrudRepository<Serie, Integer> {

    Optional<Serie> findByName(String name);

    @NonNull
    List<Serie> findAll();


}