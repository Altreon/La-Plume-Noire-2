package Scene;

public class Ungoliant extends Scene{
	private static String sceneName = "Ungoliant";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 34, 60+21}, {1110, 65, 90, 92, 27, 60+32}, {1110, 66, 90, 26, 36, 60+53}};
	private static float[] audioInfo = {2.05F, 120+2.3F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Ungoliant () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
