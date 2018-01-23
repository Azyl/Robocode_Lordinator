package az13;

import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.geom.Point2D;

import static java.lang.Math.PI;

/**
 *
 * Class used to implement the #Enemy interface.
 *
 * @author Tataru Andrei-Emanuel
 * @version 1.0
 * @since 1.0
 *
 */
public class EnemyRobot extends Object implements Enemy {

    //declaration
    private String Name;
    private double Bearing;
    private double AbsBearing;
    private double Heading;
    private double Speed;
    private double Energy;
    private double LatVelocity;
    private Point2D.Double GuessedPosition;
    private double X;
    private double Y;
    private double Distance;
    private double ChangedHeading;
    private long Ctime; //game time that the scan was produced
    private boolean alive;


    // Constructor
    EnemyRobot() {}

    //setters
    public void setName(String name) {
        this.Name = name;
    }

    public void setBearing(double bearing) {
        this.Bearing = bearing;
    }

    public void setAbsBearing(double absBearing) {
        AbsBearing = absBearing;
    }

    public void setHeading(double heading) {
        this.Heading = heading;
    }

    public void setSpeed(double speed) {
        this.Speed = speed;
    }

    public void setEnergy(double energy) {
        this.Energy = energy;
    }

    public void setX(double x) {
        this.X = x;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public void setDistance(double distance) {
        this.Distance = distance;
    }

    public void setChangedHeading(double changedHeading) {
        this.ChangedHeading = changedHeading;
    }

    public void setCtime(long ctime) {
        this.Ctime = ctime;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setLatVelocity(double LatVelocity){
        this.LatVelocity = LatVelocity;
    }


    public void setGuessedPosition(Point2D position){
        this.GuessedPosition = (Point2D.Double) position;
    }



    //getters
    public String getName() {
        return this.Name;
    }

    public double getEnergy() {
        return this.Energy;
    }

    public double getSpeed() {
        return this.Speed;
    }

    public double getBearing() {
        return this.Bearing;
    }

    public double getAbsBearing() {
        return this.AbsBearing;
    }

    public double getHeading() {
        return this.Heading;
    }

    public double getX() {
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public double getDistance() {
        return this.Distance;
    }

    public double getChangedHeading() {
        return this.ChangedHeading;
    }

    public Point2D.Double getGuessedPosition() {
        return GuessedPosition;
    }

    public long getCtime() {
        return this.Ctime;
    }

    public boolean getAlive() {
        return alive;
    }

    public double getLatVelocity() {
        return LatVelocity;
    }


    public Point2D.Double guessPosition(long when) {
        double diff = when - this.Ctime;
        double newY = this.Y + Math.cos(this.Heading) * this.Speed * diff;
        double newX = this.X + Math.sin(this.Heading) * this.Speed * diff;
        return new Point2D.Double(newX, newY);
    }


    // Method used to create an instance of an enemy impl object.
    public final static Enemy createEnemy(ScannedRobotEvent in_event ,long time, double X,double Y ) {
        EnemyRobot out_enemy = new EnemyRobot();

        out_enemy.setName( in_event.getName() );
        out_enemy.setEnergy(in_event.getEnergy());
        out_enemy.setSpeed(in_event.getVelocity());
        out_enemy.setAlive(true);
        out_enemy.setBearing(in_event.getBearing());
        out_enemy.setDistance(in_event.getDistance());
        out_enemy.setHeading(in_event.getHeading());
        out_enemy.setX(in_event.getVelocity()*Math.sin(in_event.getBearingRadians()));
        out_enemy.setAbsBearing((in_event.getBearingRadians()+in_event.getHeadingRadians())%(2*PI));
        out_enemy.setGuessedPosition(out_enemy.guessPosition(out_enemy.getCtime()));
        out_enemy.setX(X+Math.sin(out_enemy.AbsBearing)*in_event.getDistance()); //getX()+
        out_enemy.setY(Y+Math.cos(out_enemy.AbsBearing)*in_event.getDistance()); //getY()+ add them when making the calculations
        out_enemy.setCtime(time);


        return out_enemy;
    }



}
