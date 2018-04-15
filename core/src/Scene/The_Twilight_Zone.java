package Scene;

public class The_Twilight_Zone extends Scene{
	private static String sceneName = "The Twilight Zone";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 196, 90, 26, 40, 120+22}};
	private static float[] audioInfo = {2.1F, 120+32};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public The_Twilight_Zone () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
