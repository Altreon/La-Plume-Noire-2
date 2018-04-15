package Scene;

public class Le_crepuscule_des_dieux extends Scene{
	//N
	//SOUS
	//CHEMIN
	private static String sceneName = "Le crepuscule des dieux";
	private static boolean asBoucle = false;
	private static int mouvement = 2;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 16, 120+21-5}, {1110, 65, 90, 92, 13, 120+21}, {1110, 66, 90, 26, 10, 120+26}};
	private static float[] audioInfo = {1.85F, 120+33.3F};
	private static float[] coinTime =  {60+39.03F, 60+54.6F, 60+48, 60+45.46F, 60+51.32F};
	
	public Le_crepuscule_des_dieux () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
