package Database;

import Model.Expenses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDatabaseImpl implements WorkWithDatabase{

    private Connection connection;

    public WorkWithDatabaseImpl(){

        this.connection = DatabaseConnection.getConnection();

    }

    public void addExpense(Expenses expense) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO expenses_management.expenses(Date, Price, Currency, Name) VALUES (?,?,?,?)");
            preparedStatement.setDate(1, Date.valueOf(expense.getDate()));
            preparedStatement.setDouble(2, expense.getPrice());
            preparedStatement.setString(3, expense.getCurrency());
            preparedStatement.setString(4, expense.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expenses> getAllExpenses() {
        List<Expenses> expenses = new ArrayList<Expenses>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses_management.expenses");
            while (resultSet.next()) {
                Expenses expense = new Expenses();
                expense.setDate(resultSet.getDate("Date").toString());
                expense.setPrice(resultSet.getDouble("Price"));
                expense.setCurrency(resultSet.getString("Currency"));
                expense.setName(resultSet.getString("Name"));
                expenses.add(expense);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public void clearByData(String date) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM expenses_management.expenses WHERE Date=?");
            preparedStatement.setDate(1, Date.valueOf(date));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
