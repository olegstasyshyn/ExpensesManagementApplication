package Database;

import Model.Expenses;

import java.util.List;

public interface WorkWithDatabase {
     void addExpense(Expenses expense);

     List<Expenses> getAllExpenses();

     void clearByData(String data);
}
