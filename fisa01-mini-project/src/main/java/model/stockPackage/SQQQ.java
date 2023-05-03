package model.stockPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQQQ extends Stock {
    public SQQQ(int price) {
        super(price, -1);
    }

    @Override
    public void save(Connection connection) throws SQLException {
        super.save(connection);

        String sql = "INSERT INTO sqqq (id) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, getId());
        statement.executeUpdate();
    }
}
