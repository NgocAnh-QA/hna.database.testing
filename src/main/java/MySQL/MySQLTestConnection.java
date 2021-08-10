package MySQL;

import jdbcConnection.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection() {
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException {
        // Lấy ra đối tượng Connection kết nối vào database
        Connection conn = MySQLTestConnection.getMyConnection();

        String insertValue = "INSERT INTO branch (ADDRESS, CITY, NAME, STATE, ZIP_CODE) VALUES('100 Nguyen Trai', 'Ho Chi Minh', 'Sai Gon', 'Viet Nam', '700000')";
        String sql = "SELECT * FROM automationfc.branch";

        Statement statement = conn.createStatement();

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet
        // Hứng dữ liệu từ query trả về
        int rowCount = statement.executeUpdate(insertValue);

        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về
        while (rs.next()) {
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
