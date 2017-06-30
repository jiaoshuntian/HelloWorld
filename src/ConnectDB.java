import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by JiaoShuntian on 2017/6/12.
 * 功能描述： 连接数据库-MySQL/Oracle/SQL Server
 */
public class ConnectDB {

    private static final String MYSQL = "jdbc:mysql://";

    private static final String ORACLE = "jdbc:oracle:thin:@";

    private static final String SQLSERVER = "jdbc:microsoft:sqlserver://";

    private ConnectDB() {

    }

    public static Connection getConnection(String DBType, String url,
        String user, String password) throws SQLException {
            if ("mysql".equalsIgnoreCase(DBType))
                return getMysqlConn(url, user, password);
            if ("oracle".equalsIgnoreCase(DBType))
                return getOracleConn(url, user, password);
            if ("sqlserver".equalsIgnoreCase(DBType)) {
                return getSqlServerConn(url, user, password);
            }
            return null;
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection getMysqlConn(String url, String user, String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载MySQL驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(MYSQL + url, user, password);

        return conn;
    }

    private static Connection getOracleConn(String url, String user, String passwoed) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.dricer.oracleDricer");//加载Oracle驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection(ORACLE + url, user, passwoed);

        return conn;
    }

    private static Connection getSqlServerConn(String url, String user, String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");//加载SQLServer驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(SQLSERVER + url, user, password);

        return  conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection("mysql", "127.0.0.1", "root", "123456");
                if (conn == null) {
                    System.out.println("Connection the database is failed!");
                } else {
                    System.out.println(conn.toString());
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
