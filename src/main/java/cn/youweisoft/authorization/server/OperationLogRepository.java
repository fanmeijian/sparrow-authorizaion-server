package cn.youweisoft.authorization.server;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.youweisoft.authorization.server.model.SwdOperationLog;

/***
 * 
 * @author fanmj
 * 
 * 不能放repository包里面，因为会出现日志类循环调用的死循环。因此只能放根包里
 *
 */

public interface OperationLogRepository extends JpaRepository<SwdOperationLog, String> {

}
