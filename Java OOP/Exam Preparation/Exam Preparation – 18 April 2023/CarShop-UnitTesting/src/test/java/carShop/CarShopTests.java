package carShop;

import org.junit.Assert;
import org.junit.Test;

public class CarShopTests {

    @Test
    public void testCtorCreatesObjectCorrectly(){
        CarShop shop = new CarShop();

        Assert.assertEquals(0, shop.getCars().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsIsUnmodifiable(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);

        shop.getCars().add(car);
    }

    @Test
    public void testGetCountWorksCorrectly(){
        CarShop shop = new CarShop();

        Assert.assertEquals(0, shop.getCount());
    }
    @Test
    public void testGetCarsWithMaxPowerWorksCorrectly(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);
        Car car1 = new Car("test1", 201, 1000);
        Car car2 = new Car("test2", 300, 1000);

        shop.add(car);
        shop.add(car1);
        shop.add(car2);

        Assert.assertEquals(2, shop.findAllCarsWithMaxHorsePower(200).size());
    }

    @Test
    public void testGetCarsWithMaxPowerWorksCorrectlyWithNoCars(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);
        Car car1 = new Car("test1", 201, 1000);
        Car car2 = new Car("test2", 300, 1000);

        shop.add(car);
        shop.add(car1);
        shop.add(car2);

        Assert.assertEquals(0, shop.findAllCarsWithMaxHorsePower(500).size());
    }

    @Test
    public void testAddWorksCorrectly(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);

        shop.add(car);

        Assert.assertEquals(1, shop.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testAddThrowsNullPointerException(){
        CarShop shop = new CarShop();

        shop.add(null);
    }

    @Test
    public void testRemoveWorksCorrectly(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);

        shop.add(car);
        Assert.assertTrue(shop.remove(car));

        Assert.assertEquals(0, shop.getCount());
    }

    @Test
    public void testRemoveWorksCorrectlyWithNoCar(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);

        shop.add(car);
        Assert.assertTrue(shop.remove(car));
        Assert.assertFalse(shop.remove(car));
    }

    @Test
    public void testLuxuryWorksCorrectly(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);
        Car car1 = new Car("test", 100, 2002);
        Car car2 = new Car("testLuxury", 100, 3000);

        shop.add(car);
        shop.add(car1);
        shop.add(car2);

        Assert.assertEquals("testLuxury", shop.getTheMostLuxuryCar().getModel());
    }

    @Test
    public void testFindByModelWorksCorrectly(){
        CarShop shop = new CarShop();
        Car car = new Car("test", 100, 1000);
        Car car1 = new Car("test", 100, 2002);
        Car car2 = new Car("testLuxury", 100, 3000);

        shop.add(car);
        shop.add(car1);
        shop.add(car2);

        Assert.assertEquals(2, shop.findAllCarByModel("test").size());
    }
}