package Scene;

public class L_horreur_dans_le_cimetiere extends Scene{
	private static String sceneName = "L horreur dans le cimetiere";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 18, 180+9}, {1110, 65, 90, 92, 19, 180+18}, {1110, 66, 90, 26, 11, 180+24}};
	private static float[] audioInfo = {1.85F, 180+29F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public L_horreur_dans_le_cimetiere () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
