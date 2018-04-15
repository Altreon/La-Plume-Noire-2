package Scene;

public class Simetierre extends Scene{
	private static String sceneName = "Simetierre";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 17, 120+12}, {1110, 65, 90, 92, 11, 120+18}, {1110, 66, 90, 26, 20, 120+24}};
	private static float[] audioInfo = {1.8F, 120+29.4F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Simetierre () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
