package FitURJC.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
	
	User findByNickname(String nickname);
	
	User findByName(String name);

}