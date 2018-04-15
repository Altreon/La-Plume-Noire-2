package Scene;

public class Le_manoir_de_l_enfer extends Scene{
	private static String sceneName = "Le manoir de l enfer";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 3, 60+4}, {1110, 65, 90, 92, 5, 60+14}, {1110, 66, 90, 26, 20, 60+34}};
	private static float[] audioInfo = {1.7F, 60+43.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_manoir_de_l_enfer () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
