package CommandHandler;

import Database.WorkWithDatabaseImpl;
import Model.Expenses;

public class ListCommandHandler {

    WorkWithDatabaseImpl workWithDatabase;

    public ListCommandHandler(){
        workWithDatabase = new WorkWithDatabaseImpl();
    }

    public void eventHandler(){

        for(Expenses expenses: workWithDatabase.getAllExpenses()){
            System.out.println(expenses);
        }

    }


}
