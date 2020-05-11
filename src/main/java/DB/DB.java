package DB;

import com.mysql.cj.protocol.FullReadInputStream;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn;

    public static Connection getConnection () throws SQLException{

        Properties pros = getProperties();
        String url = pros.getProperty("dburl");
        conn = DriverManager.getConnection(url, pros);

        return conn;
    }

    private static Properties getProperties() {
        Properties pros = new Properties();
        try{
            pros.load(new FileReader("db.properties"));
        }catch (IOException e){
            throw new DBException(e.getMessage());
        }

        return pros;
    }

    public static void closeStatement (Statement st){
        try {
            st.close();
        } catch (SQLException e) {
            throw new  DBException(e.getMessage());
        }
    }

    public static void closeResultSet (ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new  DBException(e.getMessage());
        }
    }
    public static void closeConnection (){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new  DBException(e.getMessage());
        }
    }

}
