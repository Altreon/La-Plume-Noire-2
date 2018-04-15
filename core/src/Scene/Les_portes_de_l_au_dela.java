package Scene;

public class Les_portes_de_l_au_dela extends Scene{
	private static String sceneName = "Les portes de l au-dela";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 24, 180+45}, {1110, 65, 90, 92, 22, 180+52}, {1110, 66, 90, 26, 20, 240+2}};
	private static float[] audioInfo = {1.8F, 240+8.7F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Les_portes_de_l_au_dela () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
