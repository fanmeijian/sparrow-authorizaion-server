package cn.youweisoft.authorization.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import cn.youweisoft.authorization.server.model.SwdSysrole;
import cn.youweisoft.authorization.server.repository.UserRepository;
import net.minidev.json.JSONArray;

@Component
public class ClTokenEnhancer implements TokenEnhancer {

	
	@Autowired
	UserRepository userRepository;
	
	private ClientDetailsService clientDetailsService;

    public ClTokenEnhancer( MyClientDetailsService clientDetailsService ) {

        this.clientDetailsService = clientDetailsService;
    }
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		ClientDetails clientDetails = clientDetailsService.loadClientByClientId( authentication.getOAuth2Request().getClientId() );
		Map<String, Object> info = new HashMap<>();
		List<SwdSysrole> sysroles = userRepository.userSysroles(authentication.getName());
		
		JSONArray ja = new JSONArray();
		
		List<String> roles = new ArrayList<String>();
		sysroles.forEach(sysrole->{
//			roles.add(sysrole.getName()) ;
			ja.add(sysrole.getName());
		});
		Function<String,String> addQuotes = s -> "\"" + s + "\"";
//		String sroles = roles.toString();
		info.put("subject", authentication.getName());	
		info.put("roles", ja);
//		info.put("roles","["+roles.stream()
//				  .map(addQuotes)
//				  .collect(Collectors.joining(", "))+"]");
//		clientDetails.getAdditionalInformation() 
        ( (DefaultOAuth2AccessToken) accessToken ).setAdditionalInformation(info );

        return accessToken;
	}

}
