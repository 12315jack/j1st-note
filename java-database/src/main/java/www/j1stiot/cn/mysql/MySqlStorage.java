package www.j1stiot.cn.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Database of MySQL storage
 */
public class MysqlStorage {

    // SLF4J logger
    private static final Logger logger = LoggerFactory.getLogger(MysqlStorage.class);

    // mysql连接池
    private MySqlConnectionManager connectionPool;

    // pass parameter
    public void init(MySqlConnectionManager connectionPool){
        this.connectionPool=connectionPool;
    }

    /**
     * 关闭连接池
     *
     */
    public void destroy() {
        try {
            this.connectionPool.destroy();
            logger.debug("destroy mysql storage connection pool success!");
        } catch (Throwable throwable) {
            logger.debug("destroy mysql storage connection pool failed!");
            throwable.printStackTrace();
        }
    }

}
