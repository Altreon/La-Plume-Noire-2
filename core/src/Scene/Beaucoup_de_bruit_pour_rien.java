package Scene;

public class Beaucoup_de_bruit_pour_rien extends Scene{
	private static String sceneName = "Beaucoup de bruit pour rien";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 20, 60+53-10}, {1110, 98, 90, 26, 21, 60+53-5}};
	private static float[] audioInfo = {1.9F, 60+53};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Beaucoup_de_bruit_pour_rien () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
