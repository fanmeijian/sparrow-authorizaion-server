package cn.youweisoft.authorization.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.youweisoft.authorization.server.model.SwdAuthority;
import cn.youweisoft.authorization.server.model.SwdSysrole;
import cn.youweisoft.authorization.server.model.SwdUser;

public interface UserRepository extends JpaRepository<SwdUser, String> {
	@Query("SELECT s.swdAuthorities FROM SwdUser s WHERE s.username = ?1")
	List<SwdAuthority> userAuthorities(String username);

	@Query("SELECT s.swdSysroles FROM SwdUser s WHERE s.username = ?1")
	List<SwdSysrole> userSysroles(String username);
}
