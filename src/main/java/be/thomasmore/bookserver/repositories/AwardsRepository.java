package be.thomasmore.bookserver.repositories;
import be.thomasmore.bookserver.model.Awards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;


public interface AwardsRepository extends CrudRepository<Awards, Integer> {
    @NonNull
    List<Awards> findAll();
    List<Awards> findByTitleContainingIgnoreCase(String titleKeyWord);
}