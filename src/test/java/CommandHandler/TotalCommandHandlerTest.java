package CommandHandler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalCommandHandlerTest {

    @Test
    void eventHandler() {

        TotalCommandHandler totalCommandHandler = new TotalCommandHandler();

        double actual = totalCommandHandler.eventHandler("total EUR");
        double expected = 43.03;

        assertEquals(actual,expected);

    }
}