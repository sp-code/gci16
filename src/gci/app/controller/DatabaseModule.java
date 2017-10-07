package gci.app.controller;

import java.sql.*;

public final class DatabaseModule{
    private final static String HOST    = "sql526.your-server.de";
    private final static int    PORT    = 3306;
    private final static String USER_DB = "stzullo_dbu";
    private final static String PASS_DB = "jFdvnGpb17tu7p9z";
    
    protected final static String DB      = "stzullo_dbd";
    protected static Connection   defaultConnection = null;
  
    protected static Connection getDefaultConnection() throws SQLException{
        if( defaultConnection == null || defaultConnection.isClosed() )
            defaultConnection = newConnection();
        return defaultConnection;
    }
    
    protected static Connection newConnection() throws SQLException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(
                "jdbc:mysql://"+HOST+":"+PORT+"?autoReconnect=true&useSSL=false",
                USER_DB,
                PASS_DB
            );
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Connection not available.");
        }
        return connection;
    }
  
    protected static void showSQLError(SQLException e, String query, int contesto) {
      String msg;
      if ((e.getErrorCode() == 17068 | e.getErrorCode() == 17011) & 
              contesto == 0) {
         return; //questo errore non mi interessa
      }
      msg = "ErrorCode= " + e.getErrorCode() + "\n";
      msg += "Message= " + e.getMessage() + "\n";
      msg += "SQLState= " + e.getSQLState() + "\n";
      System.out.println(msg);
   }
    
   protected static void showSQLError(SQLException e){
       showSQLError(e,"",0);
   }

}
