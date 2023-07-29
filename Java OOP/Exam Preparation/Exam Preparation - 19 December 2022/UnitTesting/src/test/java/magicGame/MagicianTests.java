package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {

    @Test
    public void testCtorCreatesObject(){
        Magician mag = new Magician("test", 100);

        Assert.assertEquals("test", mag.getUsername());
        Assert.assertEquals(100, mag.getHealth());
        Assert.assertEquals(0, mag.getMagics().size());
    }

    @Test
    public void testGetUsernae(){
        Magician mag = new Magician("test", 100);

        Assert.assertEquals("test", mag.getUsername());
    }

    @Test
    public void testGetHealth(){
        Magician mag = new Magician("test", 100);

        Assert.assertEquals(100, mag.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthThrowsIllegalArgumentException(){
        Magician mag = new Magician("test", -100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameThrowsNullPointerException(){
        Magician mag = new Magician(" ", 100);
    }

    @Test
    public void testGetMagics(){
        Magician mag = new Magician("teste", 100);
        Magic magic = new Magic("test", 100);

        mag.addMagic(magic);

        Assert.assertEquals(1, mag.getMagics().size());
    }

    @Test
    public void testTakeDamage(){
        Magician mag = new Magician("teste", 100);

        mag.takeDamage(50);

        Assert.assertEquals(50, mag.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsIllegalStateException(){
        Magician mag = new Magician("teste", 100);

        mag.takeDamage(100);
        mag.takeDamage(100);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicThrowsNullPointerException(){
        Magician mag = new Magician("teste", 100);

        mag.addMagic(null);
    }

    @Test
    public void testREmoveMagic(){
        Magician mag = new Magician("teste", 100);
        Magic magic = new Magic("test", 100);

        mag.addMagic(magic);

        Assert.assertTrue(mag.removeMagic(magic));
        Assert.assertFalse(mag.removeMagic(magic));
    }

    @Test
    public void testGetMagic(){
        Magician mag = new Magician("teste", 100);
        Magic magic = new Magic("test", 100);

        mag.addMagic(magic);

        Assert.assertEquals(magic, mag.getMagic("test"));
        Assert.assertNull(mag.getMagic("iii"));
    }
}