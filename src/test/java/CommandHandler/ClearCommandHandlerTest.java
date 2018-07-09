package CommandHandler;

import Database.WorkWithDatabaseImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ClearCommandHandlerTest {

    @Test
    void eventHandler() {

            ClearCommandHandler clearHandler = new ClearCommandHandler();
            clearHandler.eventHandler("clear 2017-04-06");

            WorkWithDatabaseImpl workWithDatabase = new WorkWithDatabaseImpl();
            int size = workWithDatabase.getAllExpenses().size();

            assertEquals(3, size);
    }
}