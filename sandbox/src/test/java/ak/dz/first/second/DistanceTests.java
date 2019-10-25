package ak.dz.first.second;

import ak.dz.first.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ak.dz.first.Distance.distance;

public class DistanceTests {
    @Test
    public void pZeros () {
        Point p01 = new Point(0,0);
        Point p02 = new Point(0,0);
        Assert.assertEquals(distance(p01, p02), 0);
    }

    @Test
    public void pZerPosPosPos () {
        Point p01 = new Point(0,8);
        Point p02 = new Point(2,12);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 4.4721);
    }

    @Test
    public void pZerNegNegNeg () {
        Point p01 = new Point(0,-4);
        Point p02 = new Point(-3,-5);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 3.1623);
    }

    @Test
    public void pPosPosNegPos () {
        Point p01 = new Point(5,5);
        Point p02 = new Point(-1,0);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 7.8102);
    }

    @Test
    public void pPosNegZerPos () {
        Point p01 = new Point(13,-12);
        Point p02 = new Point(0,8);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 23.8537);
    }

    @Test
    public void pPosZerPosNeg () {
        Point p01 = new Point(9,0);
        Point p02 = new Point(4,-7);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 8.6023);
    }

    @Test
    public void pNegNegPosZer () {
        Point p01 = new Point(-4,-5);
        Point p02 = new Point(6,0);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 11.1803);
    }

    @Test
    public void pNegZerNegPos () {
        Point p01 = new Point(-16,0);
        Point p02 = new Point(-15,0);
        Assert.assertEquals(distance(p01, p02), 1);
    }

    @Test
    public void pNegPosZerNeg () {
        Point p01 = new Point(-10,10);
        Point p02 = new Point(0,-11);
        int precision = 10000; //keep 4 digits
        Assert.assertEquals(Math.floor(distance(p01, p02) * precision +.5)/precision, 23.2594);
    }
}
