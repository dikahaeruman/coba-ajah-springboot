package ist.challenge.dika_haeruman.repository;

import ist.challenge.dika_haeruman.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
