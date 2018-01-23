package az13;

import robocode.ScannedRobotEvent;

import java.awt.geom.Point2D;

/**
 *
 * Class used as a cache of EnemyRobots.
 *
 * @author Tataru Andrei-Emanuel
 * @version 1.0
 * @since 1.0
 *
 *
 * #MAX_STACK_SIZE constant which holds our maximum stack size - the number of Enemy information objects to maintain
 *
 */
class EnemyCollection implements Enemy {


    protected static final int MAX_STACK_SIZE = 500;
    private Enemy[] m_information  = new Enemy[ MAX_STACK_SIZE ];
    private int next               = 0;
    private int size               = 0;

    /** our constructor, which takes in the first object in
     *  our collection, this ensures that any collection always
     *  has at least one entry.
     *  */
    public EnemyCollection( Enemy in_newEnemy ) {
        add( in_newEnemy );
    }
    // Adds an Enemy to our stack of objects.
    public void add( Enemy in_new ) {
        size = (size == MAX_STACK_SIZE) ? size : size + 1;
        m_information[next] = in_new;
        next = (next + 1) % MAX_STACK_SIZE;
    }
    // Method used to get a enemy represented by an index,
    // where 0 is the last element inserted.
    public Enemy get( int in_index ) {
        int index = next - in_index - 1;
        if( index < 0 ) index += MAX_STACK_SIZE;
        return m_information[ index ];
    }
    // Method that returns the number of Enemy object
    // that we currently are storing.
    public int size() { return size; }
    // Enemy interface methods
    /* NOTE: By having this class implement enemy, we can use it
     * as an enemy object and be ensured that whenever it is
     * updated, we always have the most recent information */


    public String getName() {
        return get(0).getName();
    }

    public double getEnergy() {
        return get(0).getEnergy();
    }

    public double getSpeed() {
        return get(0).getSpeed();
    }

    public double getBearing() {
        return get(0).getBearing();
    }

    public double getAbsBearing() {
        return 0;
    }

    public double getHeading() {
        return get(0).getHeading();
    }

    public double getLatVelocity() {
        return 0;
    }

    public double getX() {
        return get(0).getX();
    }

    public double getY() {
        return get(0).getY();
    }

    public double getDistance() {
        return get(0).getDistance();
    }

    public double getChangedHeading() {
        return get(0).getChangedHeading();
    }

    public Point2D.Double getGuessedPosition(long when) {
        return get(0).getGuessedPosition(when);
    }

    public long getCtime() {
        return get(0).getCtime();
    }

    public boolean getAlive() {
        return get(0).getAlive();
    }


    // Method used to create an instance of an enemy impl object.
    public static final Enemy createEnemy(ScannedRobotEvent in_event ) {
        EnemyRobot out_enemy = new EnemyRobot();
        out_enemy.setName( in_event.getName() );
        out_enemy.setEnergy( in_event.getEnergy() );
        out_enemy.setSpeed( in_event.getVelocity() );
        return out_enemy;
    }
}

