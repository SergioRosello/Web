package videoclub;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long>{
	
	Film findByTitle(String Title);
}