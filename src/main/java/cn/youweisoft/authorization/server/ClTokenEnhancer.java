package cn.youweisoft.authorization.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import cn.youweisoft.authorization.server.model.SwdSysrole;
import cn.youweisoft.authorization.server.repository.UserRepository;
import net.minidev.json.JSONArray;

/**
 * 保存在token里面的roles域，主要用来其他的应用系统控制的。
 * 
 * @author fanmj
 *
 */
@Component
public class ClTokenEnhancer implements TokenEnhancer {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SwdLogService logService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Map<String, Object> info = new HashMap<>();
		List<SwdSysrole> sysroles = userRepository.userSysroles(authentication.getName());

		JSONArray jaSysrole = new JSONArray();
		sysroles.forEach(sysrole -> {
			jaSysrole.add(sysrole.getName());
		});
		
		info.put("subject", authentication.getName());
		info.put("roles", jaSysrole);
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		logService.loginLog(authentication.getName(), "");
		return accessToken;
	}

}
