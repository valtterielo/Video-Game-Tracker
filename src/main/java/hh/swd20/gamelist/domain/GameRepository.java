package hh.swd20.gamelist.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    @Query(value = "select * from Game g where g.name like %:keyword% or g.releasedate like %:keyword%", nativeQuery = true)
    List<Game> findByKeyword(@Param("keyword") String keyword);

}
