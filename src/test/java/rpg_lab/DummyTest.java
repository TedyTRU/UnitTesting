package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 13;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void SeUp() {
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test
    public void DummyLosesHealthWhenAttacked() {
        int attack = 3;
        aliveDummy.takeAttack(attack);
        assertEquals(HEALTH - attack, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void DeadDummyFailsWhenAttacked() {
        deadDummy.takeAttack(0);
    }

    @Test
    public void testDeadDummyGivesExperience() {
        int actualExperience = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actualExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoseNotGiveExperience() {
        aliveDummy.giveExperience();
    }


}