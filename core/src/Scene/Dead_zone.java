package Scene;

public class Dead_zone extends Scene{
	private static String sceneName = "Dead zone";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 196, 90, 26, 39, 180+24}};
	private static float[] audioInfo = {2, 180+31.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Dead_zone () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
