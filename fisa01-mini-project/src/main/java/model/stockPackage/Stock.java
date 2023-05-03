package model.stockPackage;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
public class Stock {
    private int id;
    private int price;
    private int opposite;

    public Stock(int price, int opposite) {
        this.price = price;
        this.opposite = opposite;
    }

    public void save(Connection connection) throws SQLException {
        String sql = "INSERT INTO stock (price, opposite) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, price);
        statement.setInt(2, opposite);
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
    }
}
