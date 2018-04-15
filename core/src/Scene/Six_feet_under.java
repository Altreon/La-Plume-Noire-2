package Scene;

public class Six_feet_under extends Scene{
	private static String sceneName = "Six feet under";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 23, 60+45}, {1110, 65, 90, 92, 22, 60+52}, {1110, 66, 90, 26, 20, 120+6}};
	private static float[] audioInfo = {2F, 120+12.4F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Six_feet_under () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
