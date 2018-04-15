package Scene;

public class Mon_nom_est_personne extends Scene{
	private static String sceneName = "Mon nom est personne";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 98, 90, 124, 10, 120+5}, {1110, 98, 90, 26, 20, 120+10}};
	private static float[] audioInfo = {2, 120+15};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Mon_nom_est_personne () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
