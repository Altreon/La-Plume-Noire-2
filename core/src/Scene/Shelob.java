package Scene;

public class Shelob extends Scene{
	private static String sceneName = "Shelob";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 90};
	private static int[][] textInfo = {{1110, 98, 90, 124, 25, 120+7}, {1110, 98, 90, 26, 20, 120+12}};
	private static float[] audioInfo = {2.05F, 120+19.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Shelob () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
