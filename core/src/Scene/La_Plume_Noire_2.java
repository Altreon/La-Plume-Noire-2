package Scene;

public class La_Plume_Noire_2 extends Scene{
	private static String sceneName = "La Plume Noire 2";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {65, 365};
	private static int[][] textInfo = {{1110, 196, 90, 26, 1, 12}};
	private static float[] audioInfo = {2.2F, 60+23F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public La_Plume_Noire_2 () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
