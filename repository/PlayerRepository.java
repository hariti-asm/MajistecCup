package ma.hariti.asmaa.wrm.majesticcup.repository;

import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    @Query(value = "{}", sort = "{ goals: -1 }")
    List<Player> findTopByGoalsOrderByGoalsDesc(Pageable pageable);

    @Query(value = "{}", sort = "{ assists: -1 }")
    List<Player> findTopByAssistsOrderByAssistsDesc(Pageable pageable);

    @Query(value = "{}", sort = "{ totalCards: -1 }")
    List<Player> findTopByTotalCardsOrderByTotalCardsDesc(Pageable pageable);
}