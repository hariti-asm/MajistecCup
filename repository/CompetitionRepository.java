package ma.hariti.asmaa.wrm.majesticcup.repository;

import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
