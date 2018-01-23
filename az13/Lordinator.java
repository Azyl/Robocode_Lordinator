package az13;

import robocode.*;


/**
 * Main Robot class
 *
 * @author Tataru Andrei-Emanuel
 * @version 1.0
 * @since 1.0
 * @see AdvancedRobot
 *
 */
public class Lordinator extends AdvancedRobot {

    private static final double PI = Math.PI;
    int direction = 1;				//direction we are heading... 1 = forward, -1 = backwards
    double firePower;				//the power of the shot we will be using

    EnemyManager EMinstance =  EnemyManager.getInstance();

    /**
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void run(){
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);

        do {
            turnRadarRightRadians(Double.POSITIVE_INFINITY);
        } while (true);
    }

    /**
     *
     * Callback method called when an enemy is hit by out bullet.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void onBulletHit(BulletHitEvent e){

    }

    /**
     *
     * Callback method called when the robot is hit by a bullet.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void onHitByBullet(HitByBulletEvent e){

    }

    /**
     *
     * Callback method called when the robot has hit an enemy.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void onHitRobot(HitRobotEvent e){

    }

    /**
     *
     * Callback method called when an enemy robot has been killed.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void onRobotDeath(RobotDeathEvent e){

    }

    /**
     *
     * Callback method called when an enemy robot has been scanned.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void onScannedRobot(ScannedRobotEvent e){

        EMinstance.log(e);
        //EMinstance.

    }

    /**
     *
     * Method called to determine the way the robot moves.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void moving(){

    }

    /**
     *
     * Method called to reverse the direction of the robot.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void reverseDirection(){

    }


    /**
     *
     * Method called to get the correction needed to avoid a wall.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     * @return double
     *
     */
    private double adjustHeadingforWalls(){

        return Double.parseDouble(null);
    }


    /**
     *
     * Method called to get the shortest angle.
     * if a bearing is not within the -pi to pi range, alters it to provide the shortest angle
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public double normaliseBearing(double ang) {
        if (ang > PI)
            ang -= 2*PI;
        if (ang < -PI)
            ang += 2*PI;
        return ang;
    }


    /**
     *
     * Method called to get the shortest heading.
     * if a heading is not within the 0 to 2pi range, alters it to provide the shortest angle
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    double normaliseHeading(double ang) {
        if (ang > 2*PI)
            ang -= 2*PI;
        if (ang < 0)
            ang += 2*PI;
        return ang;
    }


    /**
     *
     * Method called to get the distance between two coordinates
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     * @return returns the distance between two x,y coordinates
     *
     */
    public double getRange( double x1,double y1, double x2,double y2 )
    {
        double xo = x2-x1;
        double yo = y2-y1;
        double h = Math.sqrt( xo*xo + yo*yo );
        return h;
    }



    /**
     *
     * Method called to get the the absolute bearing between to x,y coordinates
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     * @return returns the absolute angle/bearing between two x,y coordinates
     *
     */
    public double absbearing( double x1,double y1, double x2,double y2 )
    {
        double xo = x2-x1;
        double yo = y2-y1;
        double h = getRange( x1,y1, x2,y2 );
        if( xo > 0 && yo > 0 )
        {
            return Math.asin( xo / h );
        }
        if( xo > 0 && yo < 0 )
        {
            return Math.PI - Math.asin( xo / h );
        }
        if( xo < 0 && yo < 0 )
        {
            return Math.PI + Math.asin( -xo / h );
        }
        if( xo < 0 && yo > 0 )
        {
            return 2.0*Math.PI - Math.asin( -xo / h );
        }
        return 0;
    }


    /**
     *
     * Method called to determine the way the robot fires.
     *
     * @author Tataru Andrei-Emanuel
     * @version 1.0
     * @since 1.0
     *
     */
    public void aiming(){

    }












}
