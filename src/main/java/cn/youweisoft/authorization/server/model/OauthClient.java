package cn.youweisoft.authorization.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oauth_client database table.
 * 
 */
@Entity
@Table(name="oauth_client")
@NamedQuery(name="OauthClient.findAll", query="SELECT o FROM OauthClient o")
public class OauthClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLIENT_ID")
	private String clientId;

	@Column(name="ACCESS_TOKEN_VALIDITY")
	private int accessTokenValidity;

	private byte autoapprove;

	@Column(name="CLIENT_SECRET")
	private String clientSecret;

	@Column(name="GRANT_TYPE")
	private String grantType;

	@Column(name="REDIRECT_URI")
	private String redirectUri;

	@Column(name="REFRESH_TOKEN_VALIDITY")
	private int refreshTokenValidity;

	public OauthClient() {
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getAccessTokenValidity() {
		return this.accessTokenValidity;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public byte getAutoapprove() {
		return this.autoapprove;
	}

	public void setAutoapprove(byte autoapprove) {
		this.autoapprove = autoapprove;
	}

	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantType() {
		return this.grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getRedirectUri() {
		return this.redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public int getRefreshTokenValidity() {
		return this.refreshTokenValidity;
	}

	public void setRefreshTokenValidity(int refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

}