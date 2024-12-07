package ma.hariti.asmaa.wrm.majesticcup.repository;

import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
