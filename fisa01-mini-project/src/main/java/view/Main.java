package view;

import model.stockPackage.SQQQ;
import model.stockPackage.Stock;
import model.stockPackage.TQQQ;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            String url = "jdbc:mysql://localhost:3306/fisa01";
            String user = "root";
            String password = "whfdjqakfuqek!96";
            Connection connection = DriverManager.getConnection(url, user, password);

            // Stock 객체 저장
            Stock stock = new Stock(100, 1);
            stock.save(connection);

            // TQQQ 객체 저장
            TQQQ tqqq = new TQQQ(200);
            tqqq.save(connection);

            // SQQQ 객체 저장
            SQQQ sqqq = new SQQQ(300);
            sqqq.save(connection);

            // Member 객체 저장
            Member member = new Member("memberA", "1111");
            member.save(connection);

            // 연결 종료
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
