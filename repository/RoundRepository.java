package ma.hariti.asmaa.wrm.majesticcup.repository;

import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoundRepository extends MongoRepository <Round, String>{
    List<Round> findByCompetitionId(String competitionId);

}
