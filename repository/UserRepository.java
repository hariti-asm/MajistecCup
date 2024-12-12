package ma.hariti.asmaa.wrm.majesticcup.repository;

import ma.hariti.asmaa.wrm.majesticcup.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User, String> {
    Optional <User> findByUsername(String username);

}
