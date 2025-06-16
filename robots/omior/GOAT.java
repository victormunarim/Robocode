package omior;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * GOAT - a robot by (your name here)
 */
public class GOAT extends AdvancedRobot
{
	/**
	 * run: GOAT's default behaviorss
	 */
	public void run() {
		//leitor de medidas do campo de batalha
		double largura = getBattleFieldWidth();
		double altura = getBattleFieldHeight();
		double posX = getX();
		double posY = getY();
		double direcao = getHeading();
				if (direcao<=180)
					{turnRight(180-direcao);}
				else {turnLeft(direcao-180);}
		double alturaRobo = getHeight();
  		ahead(posY-alturaRobo/2);
						turnRight(135);
	while (true) { ahead(1000); }	
	

							// execute();
		
		
		
}

// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop

			// Replace the next 4 lines with any behavior you would like


	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(50);
		turnRight(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like

	turnRight(90);
		
	
	}	
}
