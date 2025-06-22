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
		double posYInicial = getY();
		double direcao = getHeading();
		if (direcao<=180)
		{
		turnRight(180-direcao);
		ahead(posYInicial - 50);
		turnRight(135);
		while(getX() > 50 && getY() < altura - 50) {
		ahead(30);
		}	
		}
		else
		{
		turnLeft(direcao-180);
		ahead(posYInicial - 50);
		turnRight(135);
		while(getX() > 50 && getY() < altura - 50) {
		ahead(30);
		}				
		}
		
		while (true) {
				turnRight(125);
				ahead(100);
			while (!GOAT.pertoDaParede(getX(), getY(), largura, altura)){ahead(50);}
		}
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
		double distanciaInimigo = e.getDistance();
		double direcaoInimigoRelativa = e.getBearing();
		
		if(distanciaInimigo < 200){
			turnRight(direcaoInimigoRelativa);
			fire(3);
		}
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public static boolean pertoDaParede(double posX, double posY, double largura, double altura) {
		// Replace the next line with any behavior you would like;
		
		if (posX <= 80 || posY <= 80 || posX >= largura - 80 || posY >= altura - 80)
		{
			return true;
		}
		else {return false;}
	}	
}
