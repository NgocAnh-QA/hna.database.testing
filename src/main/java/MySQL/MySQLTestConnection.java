package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection(){
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException {
        // Lấy ra đối tượng Connection kết nối vào database
        Connection conn = MySQLTestConnection.getMyConnection();

        Statement statement = conn.createStatement();

        String sql = "SELECT * FROM automationfc.branch";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về
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
        System.out.println("======= Closed connection ========");

    }
}
