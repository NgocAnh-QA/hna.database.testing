package SQLServer;

import jdbcConnection.SQLServerJTDSConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTestConnection {
    public static Connection getMyConnection(){
        return SQLServerJTDSConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = SQLServerJTDSTestConnection.getMyConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM [automationfc].[dbo].[BRANCH]";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            int branchID = rs.getInt(1);
            String address = rs.getString(2);
            String city = rs.getString(3);
            String name = rs.getString(4);
            String state = rs.getString(5);
            String zipCode = rs.getString(6);

            System.out.println("===================");
            System.out.println(branchID);
            System.out.println(address);
            System.out.println(city);
            System.out.println(name);
            System.out.println(state);
            System.out.println(zipCode);
        }
        conn.close();
        System.out.println("======= Closed connection =======");
    }
}
