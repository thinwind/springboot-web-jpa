package win.shangyh.demo.sbwebjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import win.shangyh.demo.sbwebjpa.domain.entity.User;

/**
 * UserRepo
 */
public interface UserRepo extends JpaRepository<User,Long>{

    
}