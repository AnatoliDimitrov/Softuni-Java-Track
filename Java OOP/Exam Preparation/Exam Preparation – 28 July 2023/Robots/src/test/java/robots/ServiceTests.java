package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

    @Test
    public void testCtorCreatesObjCorrectly() {
        Service service = new Service("test", 1);

        Assert.assertEquals("test", service.getName());
        Assert.assertEquals(1, service.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsNullPointerExceptionWithSpace() {
        Service service = new Service(" ", 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsNullPointerExceptionWithNull() {
        Service service = new Service(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsIllegalArgumentException() {
        Service service = new Service("test", -1);
    }

    @Test
    public void testGetCount() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);

        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotThrowsIllegalArgumentException() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.add(new Robot("test1"));
    }

    @Test
    public void testRemoveRobotWorks() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.remove("test");

        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotThrowsIllegalArgumentException() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.remove("testddd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleRobotThrowsIllegalArgumentException() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.forSale("testddd");
    }

    @Test
    public void testForSaleWorks() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.forSale("test");

       Assert.assertEquals(false, robot.isReadyForSale());
    }

    @Test
    public void testReport() {
        Service service = new Service("test", 1);
        Robot robot = new Robot("test");
        service.add(robot);
        service.forSale("test");

        Assert.assertEquals("The robot test is in the service test!", service.report());
    }
}