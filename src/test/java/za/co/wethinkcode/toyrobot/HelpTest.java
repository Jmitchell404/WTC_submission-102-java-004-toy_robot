package za.co.wethinkcode.toyrobot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelpTest {
    @Test
    public void HelpTest(){
        Robot target = new Robot("Life");
        HelpCommand help = new HelpCommand();
        assertTrue(help.execute(target));
    }
}
