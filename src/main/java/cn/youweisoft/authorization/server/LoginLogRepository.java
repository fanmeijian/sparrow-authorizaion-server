package cn.youweisoft.authorization.server;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.youweisoft.authorization.server.model.SwdLoginLog;

public interface LoginLogRepository extends JpaRepository<SwdLoginLog, String> {

}
