/*  ConnectionPool.java
 *  Assignment 4
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.26: Created
 */

package club.data;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/**
 * Class to connect database
 * @author Sydney Dele Enebeli
 */
public class ConnectionPool
{
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
 
    private ConnectionPool()
    {
        try
        {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/memberdb");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance()
    {
        if (pool == null)
        {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection()
    {
        try
        {
            return dataSource.getConnection();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
    }
    
    public void freeConnection(Connection c)
    {
        try
        {
            c.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}