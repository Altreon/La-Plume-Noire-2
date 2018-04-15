package Scene;

public class Le_prisonnier extends Scene{
	private static String sceneName = "Le prisonnier";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 300};
	private static int[][] textInfo = {{1110, 65, 90, 157, 20, 120+15}, {1110, 65, 90, 92, 2, 120+34}, {1110, 66, 90, 26, 10, 120+46}};
	private static float[] audioInfo = {1.8F, 120+59F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_prisonnier () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
