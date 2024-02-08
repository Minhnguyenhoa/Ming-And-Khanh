package dao;

import dal.DBContext;
import model.Debtor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DebtorDAO {

    private DBContext db;

    public DebtorDAO() {
        db = DBContext.getInstance();
    }

    public List<Debtor> getAllDebtors() {
        List<Debtor> debtors = new ArrayList<>();
        String query = "SELECT * FROM debtor";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Debtor debtor = mapResultSetToDebtor(resultSet);
                debtors.add(debtor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debtors;
    }

    public List<Debtor> getDebtorsByCreditorId(int creditorId, int pageSize, int pageNumber) {
        List<Debtor> debtors = new ArrayList<>();
        String query = "SELECT * FROM debtor WHERE creditor_account_id = ? LIMIT ? OFFSET ?";
        int offset = (pageNumber - 1) * pageSize;
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, creditorId);
            preparedStatement.setInt(2, pageSize);
            preparedStatement.setInt(3, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Debtor debtor = mapResultSetToDebtor(resultSet);
                    debtors.add(debtor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debtors;
    }

    public Debtor getDebtorById(int debtorId) {
        String query = "SELECT * FROM debtor WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToDebtor(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public double getDebtorTotalById(int debtorId) {
        String query = "SELECT SUM(CASE WHEN debtType = 1 THEN amount ELSE -amount END) AS total_amount FROM debtdetails WHERE debtor_id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("total_amount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean addDebtor(Debtor debtor) {
        String query = "INSERT INTO debtor (name, address, phone, email, totalDebt, createdAt, updatedAt, account_id, creditor_account_id) "
                + "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?)";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, debtor.getName());
            preparedStatement.setString(2, debtor.getAddress());
            preparedStatement.setString(3, debtor.getPhone());
            preparedStatement.setString(4, debtor.getEmail());
            preparedStatement.setDouble(5, debtor.getTotalDebt());
            preparedStatement.setInt(6, debtor.getAccountId());
            preparedStatement.setInt(7, debtor.getCreditorAccountId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDebtor(Debtor debtor) {
        String query = "UPDATE debtor SET name = ?, address = ?, phone = ?, email = ?, totalDebt = ?, updatedAt = CURRENT_TIMESTAMP, "
                + "account_id = ?, creditor_account_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, debtor.getName());
            preparedStatement.setString(2, debtor.getAddress());
            preparedStatement.setString(3, debtor.getPhone());
            preparedStatement.setString(4, debtor.getEmail());
            preparedStatement.setDouble(5, debtor.getTotalDebt());
            preparedStatement.setInt(6, debtor.getAccountId());
            preparedStatement.setInt(7, debtor.getCreditorAccountId());
            preparedStatement.setInt(8, debtor.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDebtor(int debtorId) {
        String query = "DELETE FROM debtor WHERE id = ?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, debtorId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Debtor mapResultSetToDebtor(ResultSet resultSet) throws SQLException {
        Debtor debtor = new Debtor();
        debtor.setId(resultSet.getInt("id"));
        debtor.setName(resultSet.getString("name"));
        debtor.setAddress(resultSet.getString("address"));
        debtor.setPhone(resultSet.getString("phone"));
        debtor.setEmail(resultSet.getString("email"));
//        debtor.setTotalDebt(resultSet.getDouble("totalDebt"));
        debtor.setTotalDebt(getDebtorTotalById(debtor.getId()));
        debtor.setCreatedAt(resultSet.getTimestamp("createdAt"));
        debtor.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
        debtor.setAccountId(resultSet.getInt("account_id"));
        debtor.setCreditorAccountId(resultSet.getInt("creditor_account_id"));
        return debtor;
    }

}
