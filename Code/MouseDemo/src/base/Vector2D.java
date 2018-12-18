package base;

import java.util.Vector;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    /**
     * @return an other vector with same x & y
     */
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    /**
     *
     * @param x
     * @param y
     * @return return new vector = oldVector + passed arguments
     */
    public Vector2D add(float x, float y) {
        Vector2D result = new Vector2D(this.x + x, this.y + y);
        return result;
    }

    public Vector2D add(Vector2D other) {
        return this.add(other.x, other.y);
    }

    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addThis(Vector2D other) {
        return this.addThis(other.x, other.y);
    }

    public Vector2D substract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D substract(Vector2D other) {
        return this.substract(other.x, other.y);
    }


    public Vector2D substractThis(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D substractThis(Vector2D other) {
        return this.substractThis(other.x, other.y);
    }


    /**
     * return new Vector = oldVector * n
     * @param n
     * @return
     */
    public Vector2D scale(float n) {
        return new Vector2D(this.x * n, this.y * n);
    }
    public Vector2D scaleThis(float n) {
        this.x *= n;
        this.y *= n;
        return this;
    }

    /**
     *
     * @return vector's length
     */
    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public double angle() {
        double angle = -Math.atan(this.x / this.y);
        return this.y > 0 ? angle + Math.PI   : angle;
    }

    public void print() {
        System.out.println(x + "; " + y);
    }

    public double angleTo(Vector2D other) {
        return other.substract(this).angle();
    }

    @Override
    public String toString() {
        return "(x: " + x + "; y" + y + ")";
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1, 1);
        System.out.println(v1.angle());
        System.out.println(Math.PI / 4);

        System.out.println();

        Vector2D v2 = new Vector2D(-1, 1);
        System.out.println(v2.angle());
        System.out.println(Math.PI / 4);

        System.out.println();

        Vector2D v3 = new Vector2D(-1, -1);
        System.out.println(v3.angle());
        System.out.println(Math.PI / 4);

        System.out.println();

        Vector2D v4 = new Vector2D(1, -1);
        System.out.println(v4.angle());
        System.out.println(Math.PI / 4);
    }
}
