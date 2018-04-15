package Scene;

public class L_autre extends Scene{
	private static String sceneName = "L autre";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 90};
	private static int[][] textInfo = {{1110, 196, 90, 26, 37, 180+10}};
	private static float[] audioInfo = {2.1F, 180+22.6F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public L_autre () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
