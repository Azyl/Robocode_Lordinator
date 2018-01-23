package az13;

import java.awt.geom.Point2D;


/**
 *
 * Interface used to determine methods supported by an Enemy.
 *
 * @author Tataru Andrei-Emanuel
 * @version 1.0
 * @since 1.0
 *
 */
public interface Enemy{

    public String getName();
    public double getEnergy();
    public double getSpeed();
    public double getBearing();
    public double getAbsBearing();
    public double getHeading();
    public double getLatVelocity();
    public double getX();
    public double getY();
    public double getDistance();
    public double getChangedHeading();
    public Point2D.Double getGuessedPosition();
    public long getCtime();
    public boolean getAlive();

}