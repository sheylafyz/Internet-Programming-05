package my.utm.healthhub.jdbcdao;

import my.utm.healthhub.model.Person;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BmiRecordJdbcDao implements BmiRecordDao {

    // ✅ FIXED JDBC URL (WAJIB di Mac)
    private final String url =
            "jdbc:mysql://localhost:3306/healthhub_db" +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private final String user = "root";
    private final String pass = "Root12345!";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL JDBC driver registered");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC driver NOT found");
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT name, height_m, weight_kg, bmi_value, category FROM bmi_record";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Person p = new Person();
                p.setName(rs.getString("name"));
                p.setHeight(rs.getDouble("height_m"));
                p.setWeight(rs.getDouble("weight_kg"));
                p.setBmi(rs.getDouble("bmi_value"));
                p.setCategory(rs.getString("category"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ SELECT FAILED");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Person person) {
        String sql =
                "INSERT INTO bmi_record " +
                "(name, height_m, weight_kg, bmi_value, category) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, person.getName());
            ps.setDouble(2, person.getHeight());
            ps.setDouble(3, person.getWeight());
            ps.setDouble(4, person.getBmi());
            ps.setString(5, person.getCategory());

            System.out.println("ℹ️ Executing INSERT: name=" + person.getName() +
                    ", height=" + person.getHeight() +
                    ", weight=" + person.getWeight() +
                    ", bmi=" + person.getBmi() +
                    ", category=" + person.getCategory());

            int rows = ps.executeUpdate();
            System.out.println("✅ INSERT SUCCESS, rows affected = " + rows);

        } catch (SQLException e) {
            System.out.println("❌ INSERT FAILED");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bmi_record WHERE id = ?";

        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
