package CommandHandler;

import Database.WorkWithDatabaseImpl;
import Model.Expenses;

public class ClearCommandHandler {

    Expenses expenses;

    WorkWithDatabaseImpl workWithDatabase;

    public ClearCommandHandler() {
        workWithDatabase = new WorkWithDatabaseImpl();
    }

    public void eventHandler(String typedText){

        String data[] = typedText.split(" ", 2);

        workWithDatabase.clearByData(data[1]);

        for(Expenses expenses: workWithDatabase.getAllExpenses()){
            System.out.println(expenses);
        }


    }
}
