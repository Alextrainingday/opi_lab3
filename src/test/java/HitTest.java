import beans.Result;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class HitTest {
    private final Result result = new Result();

    @Test
    public void hitCircle() {
        result.setX(new BigDecimal("-0.58"));
        result.setY(new BigDecimal("0.625"));
        result.setR(new BigDecimal("2.5"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitCircleLowBorder() {
        result.setX(new BigDecimal("-1.0"));
        result.setY(BigDecimal.ZERO);
        result.setR(new BigDecimal("3.25"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitCircleArchBorder() {
        result.setX(new BigDecimal("-0.707"));
        result.setY(new BigDecimal("0.707"));
        result.setR(new BigDecimal("2.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void missCircle() {
        result.setX(new BigDecimal("-1.0"));
        result.setY(new BigDecimal("1.0"));
        result.setR(new BigDecimal("1.25"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missCircleLowBorder() {
        result.setX(new BigDecimal("-0.145"));
        result.setY(new BigDecimal("0.647"));
        result.setR(new BigDecimal("1.25"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missCircleArchBorder() {
        result.setX(new BigDecimal("-0.708"));
        result.setY(new BigDecimal("0.708"));
        result.setR(new BigDecimal("2.0"));
        assertFalse(result.checkHit());
    }

    @Test
    public void hitTriangle() {
        result.setX(new BigDecimal("0.509"));
        result.setY(new BigDecimal("0.964"));
        result.setR(new BigDecimal("3.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitTriangleLowBorder() {
        result.setY(new BigDecimal("0.0"));
        result.setX(new BigDecimal("1.8"));
        result.setR(new BigDecimal("3.75"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitTriangleTopBorder() {
        result.setX(new BigDecimal("0.75"));
        result.setY(new BigDecimal("1.5"));
        result.setR(new BigDecimal("3.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitTriangleHBorder() {
        result.setX(new BigDecimal("0.0"));
        result.setY(new BigDecimal("1.0"));
        result.setR(new BigDecimal("1.25"));
        assertTrue(result.checkHit());
    }

    @Test
    public void missTriangle() {
        result.setX(new BigDecimal("1.0"));
        result.setY(new BigDecimal("1.0"));
        result.setR(new BigDecimal("1.75"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missTriangleHBorder() {
        result.setY(new BigDecimal("-0.5"));
        result.setX(new BigDecimal("1.0"));
        result.setR(new BigDecimal("1.75"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missTriangleTopBorder() {
        result.setX(new BigDecimal("1.25"));
        result.setY(new BigDecimal("1.25"));
        result.setR(new BigDecimal("2.5"));
        assertFalse(result.checkHit());
    }

    @Test
    public void hitRectangle() {
        result.setX(new BigDecimal("1.8"));
        result.setY(new BigDecimal("-1.8"));
        result.setR(new BigDecimal("3.75"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitRectangleLowBorder() {
        result.setX(new BigDecimal("0.5"));
        result.setY(new BigDecimal("-2.0"));
        result.setR(new BigDecimal("2.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitRectangleLeftBorder() {
        result.setX(BigDecimal.ZERO);
        result.setY(new BigDecimal("-1.0"));
        result.setR(new BigDecimal("2.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void hitRectangleRightBorder() {
        result.setX(new BigDecimal("1.5"));
        result.setY(new BigDecimal("-1.0"));
        result.setR(new BigDecimal("3.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void missRectangle() {
        result.setX(new BigDecimal("2.0"));
        result.setY(new BigDecimal("-2.0"));
        result.setR(new BigDecimal("3.0"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missRectangleLowBorder() {
        result.setX(new BigDecimal("-1"));
        result.setY(new BigDecimal("-3.001"));
        result.setR(new BigDecimal("2.0"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missRectangleLeftBorder() {
        result.setX(new BigDecimal("-0.001"));
        result.setY(new BigDecimal("-2.001"));
        result.setR(new BigDecimal("3.0"));
        assertFalse(result.checkHit());
    }

    @Test
    public void missRectangleRightBorder() {
        result.setX(new BigDecimal("1.501"));
        result.setY(new BigDecimal("-2.001"));
        result.setR(new BigDecimal("3.0"));
        assertFalse(result.checkHit());
    }

    @Test
    public void hitEmptySector() {
        result.setX(new BigDecimal("-0.5"));
        result.setY(new BigDecimal("-0.5"));
        result.setR(new BigDecimal("1.25"));
        assertFalse(result.checkHit());
    }

    @Test
    public void hitZero() {
        result.setX(new BigDecimal("0.0"));
        result.setY(new BigDecimal("0.0"));
        result.setR(new BigDecimal("2.0"));
        assertTrue(result.checkHit());
    }

    @Test
    public void rSwitch() {
        result.setX(new BigDecimal("-1.0"));
        result.setY(new BigDecimal("2.0"));
        result.setR(new BigDecimal("1.25"));
        assertFalse(result.checkHit());
        result.setR(new BigDecimal("2.5"));
        assertFalse(result.checkHit());
        result.setR(new BigDecimal("3.0"));
        assertFalse(result.checkHit());
    }
}