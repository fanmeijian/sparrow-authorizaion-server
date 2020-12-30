package cn.youweisoft.authorization.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.youweisoft.authorization.server.model.SwdAuthority;
import cn.youweisoft.authorization.server.model.SwdUser;
import cn.youweisoft.authorization.server.repository.AuthorityRepository;
import cn.youweisoft.authorization.server.repository.UserRepository;

/***
 * 获取用户的调用url的权限，保存在token里面的authorities
 * @author fanmj
 *
 */

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SwdUser swdUser = userRepository.findById(username).orElse(null);
		List<SwdAuthority> authorities = new ArrayList<SwdAuthority>();
		
		//授权给个人的所有权限
		authorities.addAll(swdUser.getSwdAuthorities());
		
		//授权给个人拥有角色的所有权限
		swdUser.getSwdSysroles().forEach(sysrole -> {
			authorities.addAll(sysrole.getSwdAuthorities());
		});
		
		String[] allAuthorities = new String[authorities.size()];
		authorities.forEach(authority -> {
			allAuthorities[authorities.indexOf(authority)] = authority.getId();
		});

		return User.withUsername(username).password(swdUser.getPassword()).authorities(allAuthorities).build();
	}
}
