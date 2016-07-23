/*  DBUtil.java
 *  Assignment 4
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.26: Created
 */

package club.data;

import java.sql.*;

/**
 * Class to deal with SQL statement
 * @author Sydney Dele Enebeli
 */
public class DBUtil
{
    public static void closeStatement(Statement s)
    {
        try
        {
            if (s != null)
                s.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void closePreparedStatement(Statement ps)
    {
        try
        {
            if (ps != null)
                ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs)
    {
        try
        {
            if (rs != null)
                rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
