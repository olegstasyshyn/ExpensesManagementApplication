package CommandHandler;

import Database.WorkWithDatabaseImpl;
import Model.Expenses;

public class AddCommandHandler {

    Expenses expenses;
    WorkWithDatabaseImpl workWithDatabase;

    public AddCommandHandler(){
        workWithDatabase = new WorkWithDatabaseImpl();
    }

    public void eventHandler(String typedText){

        String data[] = typedText.split(" ", 5);

        expenses = new Expenses(data[1] , Double.parseDouble(data[2]), data[3] , data[4]);
        workWithDatabase.addExpense(expenses);
        System.out.println(expenses);

    }


}
