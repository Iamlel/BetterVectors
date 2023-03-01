package me.lel.bettervectors;

import java.util.Random;

public class CartesianVector {
    private static Random random = new Random();

    protected double x;
    protected double y;
    protected double z;

    public CartesianVector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public CartesianVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianVector add(CartesianVector vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
        return this;
    }

    public CartesianVector subtract(CartesianVector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
        this.z -= vector.z;
        return this;
    }

    public CartesianVector multiply(CartesianVector vector) {
        this.x *= vector.x;
        this.y *= vector.y;
        this.z *= vector.z;
        return this;
    }

    public CartesianVector multiply(int m) {
        this.x *= m;
        this.y *= m;
        this.z *= m;
        return this;
    }

    public CartesianVector multiply(double m) {
        this.x *= m;
        this.y *= m;
        this.z *= m;
        return this;
    }

    public CartesianVector multiply(float m) {
        this.x *= m;
        this.y *= m;
        this.z *= m;
        return this;
    }

    public CartesianVector divide(CartesianVector vector) {
        this.x /= vector.x;
        this.y /= vector.y;
        this.z /= vector.z;
        return this;
    }

    public CartesianVector divide(int m) {
        this.x /= m;
        this.y /= m;
        this.z /= m;
        return this;
    }

    public CartesianVector divide(double m) {
        this.x /= m;
        this.y /= m;
        this.z /= m;
        return this;
    }

    public CartesianVector divide(float m) {
        this.x /= m;
        this.y /= m;
        this.z /= m;
        return this;
    }

    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double distance(CartesianVector vector) {
        return this.subtract(vector).length();
    }

    public double angle(CartesianVector vector) {
        return Math.acos(dot(vector) / (this.length() * vector.length()));
    }

    public CartesianVector midpoint(CartesianVector vector) {
        return this.add(vector).multiply(0.5);
    }

    public double dot(CartesianVector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public CartesianVector crossproduct(CartesianVector vector) {
        return this.setAll(this.y * vector.z - vector.y * this.z, this.z * vector.x - vector.z * this.x, this.x * vector.y - vector.x * this.y);
    }

    public CartesianVector normalize() {
        return this.divide(this.length());
    }

    public CartesianVector setAll(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public CartesianVector setAll(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public CartesianVector setAll(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public CartesianVector zero() {
        return this.setAll(0, 0, 0);
    }

    public boolean isInAABB(CartesianVector min, CartesianVector max) {
        return x >= min.x && x <= max.x && y >= min.y && y <= max.y && z >= min.z && z <= max.z;
    }

    public boolean isInSphere(CartesianVector origin, double radius) {
        return origin.subtract(this).lengthSquared() <= radius * radius;
    }

    public CartesianVector minimum(CartesianVector vector) {
        return this.setAll(Math.min(this.x, vector.x), Math.min(this.y, vector.y), Math.min(this.z, vector.z));
    }

    public CartesianVector maximum(CartesianVector vector) {
        return this.setAll(Math.max(this.x, vector.x), Math.max(this.y, vector.y), Math.max(this.z, vector.z));
    }

    public CartesianVector random() {
        return this.setAll(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }

    public double getX() {
        return x;
    }

    public CartesianVector setX(double x) {
        this.x = x;
        return this;
    }

    public CartesianVector setX(int x) {
        this.x = x;
        return this;
    }

    public CartesianVector setX(float x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public CartesianVector setY(double y) {
        this.y = y;
        return this;
    }

    public CartesianVector setY(int y) {
        this.y = y;
        return this;
    }

    public CartesianVector setY(float y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public CartesianVector setZ(double z) {
        this.z = z;
        return this;
    }

    public CartesianVector setZ(int z) {
        this.z = z;
        return this;
    }

    public CartesianVector setZ(float z) {
        this.z = z;
        return this;
    }
}
