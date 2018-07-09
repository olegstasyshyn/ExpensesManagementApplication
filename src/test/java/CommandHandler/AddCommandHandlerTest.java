package CommandHandler;

import Model.Expenses;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandHandlerTest {

    @Test
    void eventHandler() {
        try {
            Expenses expense = new Expenses("2017-08-09", 13, "EUR", "beer");
            AddCommandHandler addCommandHandler = new AddCommandHandler();

            addCommandHandler.eventHandler("add 2017-08-09 13 EUR beer");
            Field expenseField = addCommandHandler.getClass().getDeclaredField("expenses");
            Expenses result = (Expenses) expenseField.get(addCommandHandler);

            assertEquals(expense.toString(), result.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}