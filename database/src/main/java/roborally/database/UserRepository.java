package roborally.database;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import roborally.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
    // Optional<User> findByNameAndPassword(String name, String password);
    // Optional<User> findByEmail(String email);
    User save(User user);

    }

