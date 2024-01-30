package dao;

import dal.DBContext;
import model.Salt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SaltDAO {

    private DBContext db;

    public SaltDAO() {
        db = DBContext.getInstance();
    }

    public boolean InsertSalt(Salt salt) {
        String sql = "INSERT INTO salt (id, salt) VALUES (?, ?)"; 
        try (Connection conn = db.getConnection(); 
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, salt.getId());
            pstmt.setString(2, salt.getSalt());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSalt(Salt salt) {
        String sql = "UPDATE salt SET salt = ? WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, salt.getSalt());

            pstmt.setInt(4, salt.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getSaltByUserId(int id) {
        String sql = "SELECT salt FROM salt WHERE user_id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("salt");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
