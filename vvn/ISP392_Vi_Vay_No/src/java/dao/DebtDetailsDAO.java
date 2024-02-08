package dao;

import dal.DBContext;
import model.DebtDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DebtDetailsDAO {

    private DBContext db;

    public DebtDetailsDAO() {
        db = DBContext.getInstance();
    }

    public List<DebtDetail> getAllDebtDetails() {
        List<DebtDetail> debtDetails = new ArrayList<>();
        String query = "SELECT * FROM debtdetails";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                DebtDetail debtDetail = mapResultSetToDebtDetail(resultSet);
                debtDetails.add(debtDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debtDetails;
    }

    public DebtDetail getDebtDetailById(int debtDetailId) {
        String query = "SELECT * FROM debtdetails WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtDetailId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToDebtDetail(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<DebtDetail> getDebtDetailsByDebtorId(int debtorId) {
        List<DebtDetail> debtDetails = new ArrayList<>();
        String query = "SELECT * FROM debtdetails WHERE debtor_id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    DebtDetail debtDetail = mapResultSetToDebtDetail(resultSet);
                    debtDetails.add(debtDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debtDetails;
    }

    public boolean addDebtDetail(DebtDetail debtDetail) {
        String query = "INSERT INTO debtdetails (description, debtType, amount, image, createdAt, debtor_id, debtor_account_id, interest_rate_id) " +
                "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, debtDetail.getDescription());
            preparedStatement.setBoolean(2, debtDetail.isDeptType());
            preparedStatement.setDouble(3, debtDetail.getAmount());
            preparedStatement.setString(4, debtDetail.getImage());
            preparedStatement.setInt(5, debtDetail.getDebtor_IdDebtor());
            preparedStatement.setInt(6, debtDetail.getDebtor_account_id());
            preparedStatement.setInt(7, debtDetail.getInterest_rate_id());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDebtDetail(DebtDetail debtDetail) {
        String query = "UPDATE debtdetails SET description = ?, debtType = ?, amount = ?, image = ?, debtor_id = ?, debtor_account_id = ?, interest_rate_id = ? " +
                "WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, debtDetail.getDescription());
            preparedStatement.setBoolean(2, debtDetail.isDeptType());
            preparedStatement.setDouble(3, debtDetail.getAmount());
            preparedStatement.setString(4, debtDetail.getImage());
            preparedStatement.setInt(5, debtDetail.getDebtor_IdDebtor());
            preparedStatement.setInt(6, debtDetail.getDebtor_account_id());
            preparedStatement.setInt(7, debtDetail.getInterest_rate_id());
            preparedStatement.setInt(8, debtDetail.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDebtDetail(int debtDetailId) {
        String query = "DELETE FROM debtdetails WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtDetailId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private DebtDetail mapResultSetToDebtDetail(ResultSet resultSet) throws SQLException {
        DebtDetail debtDetail = new DebtDetail();
        debtDetail.setId(resultSet.getInt("id"));
        debtDetail.setDescription(resultSet.getString("description"));
        debtDetail.setDeptType(resultSet.getBoolean("debtType"));
        debtDetail.setAmount(resultSet.getDouble("amount"));
        debtDetail.setImage(resultSet.getString("image"));
        debtDetail.setCreatAt(resultSet.getTimestamp("createdAt"));
        debtDetail.setDebtor_IdDebtor(resultSet.getInt("debtor_id"));
        debtDetail.setDebtor_account_id(resultSet.getInt("debtor_account_id"));
        debtDetail.setInterest_rate_id(resultSet.getInt("interest_rate_id"));
        return debtDetail;
    }
    
}
