package CommandHandler;

import Conversion.CurrencyConvertor;
import Database.WorkWithDatabaseImpl;
import Model.Expenses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TotalCommandHandler {


    WorkWithDatabaseImpl workWithDatabase;
    CurrencyConvertor currencyConvertor;

    public TotalCommandHandler(){
        workWithDatabase = new WorkWithDatabaseImpl();
    }
    public double eventHandler(String typedText){
        List<Expenses> expensesList = workWithDatabase.getAllExpenses();

        String data[] = typedText.split(" ", 2);

        double amount = 0;

        for(int i = 0; i < expensesList.size();i++){
            amount+=expensesList.get(i).getPrice()/currencyConvertor.convert(expensesList.get(i).getCurrency(),data[1]);
        }
        System.out.printf("%.2f", amount);
        System.out.println(data[1]);
        return new BigDecimal(amount).setScale(2, RoundingMode.UP).doubleValue();
    }

}
