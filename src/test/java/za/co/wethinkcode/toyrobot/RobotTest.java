package za.co.wethinkcode.toyrobot;


import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.world.AbstractWorld;
import za.co.wethinkcode.toyrobot.world.IWorld;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
AbstractWorld abstractWorld;

    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
//        assertEquals(Robot.CENTRE, abstractWorld.getPosition());
        assertEquals(Direction.UP, robot.getCurrentDirection());
    }

    @Test
    void dump() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals("[0,0] CrashTestDummy> Ready", robot.toString());
    }

    @Test
    void shutdown() {
        Robot robot = new Robot("CrashTestDummy");
        ShutdownCommand command = new ShutdownCommand();
        assertFalse(robot.handleCommand(command));
    }

    @Test
    void forward() {
        Robot robot = new Robot("CrashTestDummy");
        ForwardCommand command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
//        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
//        assertEquals(expectedPosition, abstractWorld.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void forwardforward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(new ForwardCommand("10")));
        assertTrue(robot.handleCommand(new ForwardCommand("5")));
        assertEquals("Moved forward by 5 steps.", robot.getStatus());
    }

    @Test
    void tooFarForward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(new ForwardCommand("1000")));
//        assertEquals(Robot.CENTRE, abstractWorld.getPosition());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void help() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new HelpCommand();
        assertTrue(robot.handleCommand(command));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+
                "LEFT - turns left\n"+
                "RIGHT - turns right\n"+
                "SPRINT - moves forward multiple steps at a time, e.g. 'SPRINT 2'\n+" +
                "REPLAY - replays previous commands", robot.getStatus());
    }
}