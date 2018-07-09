package Main;

import CommandHandler.AddCommandHandler;
import CommandHandler.ClearCommandHandler;
import CommandHandler.ListCommandHandler;
import CommandHandler.TotalCommandHandler;
import Database.WorkWithDatabaseImpl;

import java.util.Scanner;

public class Menu {

    AddCommandHandler addCommandHandler;
    ClearCommandHandler clearCommandHandler;
    ListCommandHandler listCommandHandler;
    TotalCommandHandler totalCommandHandler;
    WorkWithDatabaseImpl workWithDatabase;

    public Menu(){
        addCommandHandler = new AddCommandHandler();
        clearCommandHandler = new ClearCommandHandler();
        listCommandHandler = new ListCommandHandler();
        totalCommandHandler = new TotalCommandHandler();
        workWithDatabase = new WorkWithDatabaseImpl();
    }

    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print(">>>");
            String choice = scanner.nextLine();
            if(choice.startsWith("add")){
                addCommandHandler.eventHandler(choice);
            }
            if(choice.startsWith("list")){
                listCommandHandler.eventHandler();
            }
            if(choice.startsWith("clear")){
                clearCommandHandler.eventHandler(choice);
            }
            if(choice.startsWith("total")){
                totalCommandHandler.eventHandler(choice);
            }
        }
    }

}
