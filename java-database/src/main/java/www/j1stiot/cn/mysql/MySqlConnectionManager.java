package www.j1stiot.cn.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.configuration.AbstractConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * MySQL Connection Manager
 *
 */
public class MySqlConnectionManager {

    // SLF4J logger
    private static final Logger logger = LoggerFactory.getLogger(MySqlConnectionManager.class);

    // connection manager
    private static MySqlConnectionManager connectionManagerInstance;

    // c3p0 connect pool
    public ComboPooledDataSource comboPooledDataSource;

    // construct
    public MySqlConnectionManager() { }

    /**
     * Init connection pool
     *
     * @param params    params of mysql
     * @throws Exception   exception of connection
     *
     */
    public void init(AbstractConfiguration params) throws Exception {
        logger.debug("Init mysql data source pool ... ");
        comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(params.getString("mysql.username"));
        comboPooledDataSource.setPassword(params.getString("mysql.password"));
        comboPooledDataSource.setJdbcUrl(params.getString("mysql.url"));
        comboPooledDataSource.setDriverClass(params.getString("mysql.driverClass"));
        comboPooledDataSource.setInitialPoolSize(Integer.parseInt(params.getString("mysql.initialPoolSize")));
        comboPooledDataSource.setMinPoolSize(Integer.parseInt(params.getString("mysql.minPoolSize")));
        comboPooledDataSource.setMaxPoolSize(Integer.parseInt(params.getString("mysql.maxPoolSize")));
        comboPooledDataSource.setMaxStatements(Integer.parseInt(params.getString("mysql.maxStatements")));
        comboPooledDataSource.setMaxIdleTime(Integer.parseInt(params.getString("mysql.maxIdleTime")));
        logger.debug("Init mysql data source success! ");
    }

    /**
     * Get instance of connection manager
     *
     * @return  instance of MySqlConnectionManager
     *
     */
    public static MySqlConnectionManager getInstance() {
        if (connectionManagerInstance == null) {
            try {
                connectionManagerInstance = new MySqlConnectionManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connectionManagerInstance;
    }

    /**
     * 从连接池中获取一个连接
     *
     * @return Connection instance
     *
     */
    public synchronized final Connection getConnection() {
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接释放资源
     *
     * @param connection    Instance of Connection
     *
     */
    public synchronized final void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接池
     *
     * @throws Throwable    exception of destroy
     */
    public void destroy() throws Throwable {
        // destroy
        DataSources.destroy(comboPooledDataSource);
    }

}
