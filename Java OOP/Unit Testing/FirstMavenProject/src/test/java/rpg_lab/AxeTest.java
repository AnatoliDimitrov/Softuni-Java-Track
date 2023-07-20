package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void testCtorCreatesValidObject() {
        Axe axe = new Axe(1, 1);

        Assert.assertEquals(1, axe.getAttackPoints());
        Assert.assertEquals(1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackThrowsIllegalStateException() {
        Axe axe = new Axe(1, 0);
        Dummy dummy = new Dummy(100, 100);

        axe.attack(dummy);
    }

    @Test
    public void testAttackWorksCorrectly() {
        Axe axe = new Axe(1, 2);
        Dummy dummy = new Dummy(100, 100);

        axe.attack(dummy);
        Assert.assertEquals(1, axe.getDurabilityPoints());
    }
}