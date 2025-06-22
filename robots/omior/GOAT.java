package omior;
import robocode.*;


public class GOAT extends AdvancedRobot
{
	public void run() {
		
		//pega dados iniciais do campo de batalha e do GOAT
		double largura = getBattleFieldWidth();
		double altura = getBattleFieldHeight();
		double posYInicial = getY();
		double direcao = getHeading();
		
		//leva o GOAT para a parte da baixo do campo
		if (direcao<=180) {
			turnRight(180-direcao);
			ahead(posYInicial - 50);
			turnRight(135);
			while(getX() > 50 && getY() < altura - 50) {
				ahead(30);
			}	
		} else {
			turnLeft(direcao-180);
			ahead(posYInicial - 50);
			turnRight(135);
			while(getX() > 50 && getY() < altura - 50) {
				ahead(30);
			}				
		}
		
		//faz com que o GOAT mude de direcao quando chega perto da parede
		while (true) {
			turnRight(125);
			ahead(100);
			while (!GOAT.pertoDaParede(getX(), getY(), largura, altura)) {ahead(50);}
		}
	}

	//metodo para quando escanear um robo
	public void onScannedRobot(ScannedRobotEvent e) {
		
		//pega os dados do robo inimigo
		double distanciaInimigo = e.getDistance();
		double direcaoInimigoRelativa = e.getBearing();
		
		//segue o robo inimigo
		if(distanciaInimigo < 200){
			turnRight(direcaoInimigoRelativa);
			fire(3);
		}	
	}

	//metodo para verificar se esta perto da parede
	public static boolean pertoDaParede(double posX, double posY, double largura, double altura) {

		//logica para quando estiver a uma distancia menor que 80 da parede retorna um boolean
		if (posX <= 80 || posY <= 80 || posX >= largura - 80 || posY >= altura - 80) {
			return true;
		}
		else {return false;}
	}	
}