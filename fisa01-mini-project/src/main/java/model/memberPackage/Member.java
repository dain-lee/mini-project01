package model.memberPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private int id;
    private String username;
    private String password;
    private int tqqqQuantity;
    private int sqqqQuantity;
    private int cashBalance;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void save(Connection connection) throws SQLException {
        String sql = "INSERT INTO member (username, password, tqqq_quantity, sqqq_quantity, cash_balance) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setInt(3, tqqqQuantity);
        statement.setInt(4, sqqqQuantity);
        statement.setInt(5, cashBalance);
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
    }
}
