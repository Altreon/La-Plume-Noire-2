package Scene;

public class Le_trou_noir extends Scene{
	private static String sceneName = "Le trou noir";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 21, 120+15}, {1110, 65, 90, 92, 2, 120+32-10}, {1110, 66, 90, 26, 10, 120+32-5}};
	private static float[] audioInfo = {1.9F, 120+32F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_trou_noir () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
