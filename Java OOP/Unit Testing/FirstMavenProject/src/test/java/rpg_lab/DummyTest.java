package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void testCtorCreatesValidObject() {
        Dummy dummy = new Dummy(10, 10);

        Assert.assertEquals(10, dummy.getHealth());
    }

    @Test
    public void testDummyIsDead() {
        Dummy dummy = new Dummy(0, 10);

        Assert.assertTrue(dummy.isDead());
    }
    @Test
    public void testDummyIsNotDead() {
        Dummy dummy = new Dummy(1, 10);

        Assert.assertFalse(dummy.isDead());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyTakeAttackThrowsIllegalStateException() {
        Dummy dummy = new Dummy(0, 10);

        dummy.takeAttack(1);
    }

    @Test
    public void testDummyTakesAttackCorrectly() {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(1);

        Assert.assertEquals(9, dummy.getHealth());
    }
}