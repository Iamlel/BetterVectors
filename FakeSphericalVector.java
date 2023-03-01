package me.lel.bettervectors;

public class FakeSphericalVector extends CartesianVector {

    public FakeSphericalVector() {
        super();
    }

    public FakeSphericalVector(double yaw, double pitch, double radius) {
        this.toCartesian(yaw, pitch, radius);
    }

    public FakeSphericalVector(int yaw, int pitch, int radius) {
        this.toCartesian(yaw, pitch, radius);
    }

    public FakeSphericalVector(float yaw, float pitch, float radius) {
        this.toCartesian(yaw, pitch, radius);
    }

    public double getYaw() {
        return Math.toDegrees(Math.atan2(this.x, this.z)) * -1;
    }

    public CartesianVector setYaw(double yaw) {
        return this.toCartesian(yaw, getPitch(), this.length());
    }

    public CartesianVector setYaw(int yaw) {
        return this.toCartesian(yaw, getPitch(), this.length());
    }

    public CartesianVector setYaw(float yaw) {
        return this.toCartesian(yaw, getPitch(), this.length());
    }

    public double getPitch() {
        return Math.toDegrees(Math.atan2(Math.sqrt(this.z * this.z + this.x * this.x), this.y)) - 90;
    }

    public CartesianVector setPitch(double pitch) {
        return this.toCartesian(getYaw(), pitch, this.length());
    }

    public CartesianVector setPitch(int pitch) {
        return this.toCartesian(getYaw(), pitch, this.length());
    }

    public CartesianVector setPitch(float pitch) {
        return this.toCartesian(getYaw(), pitch, this.length());
    }

    public double getRadius() {
        return this.length();
    }

    public CartesianVector setRadius(double radius) {
        return this.normalize().multiply(radius);
    }

    public CartesianVector setRadius(int radius) {
        return this.normalize().multiply(radius);
    }

    public CartesianVector setRadius(float radius) {
        return this.normalize().multiply(radius);
    }

    protected CartesianVector toCartesian(double yaw, double pitch, double radius) { // i think the math works but not sure
        return super.setAll(Math.sin(pitch) * Math.sin(yaw), Math.cos(pitch), -1 * Math.sin(pitch) * Math.cos(yaw)).multiply(radius);
    }
}
