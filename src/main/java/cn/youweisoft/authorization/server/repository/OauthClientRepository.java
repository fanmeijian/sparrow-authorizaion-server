package cn.youweisoft.authorization.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.youweisoft.authorization.server.model.OauthClient;

public interface OauthClientRepository extends JpaRepository<OauthClient, String> {

}
