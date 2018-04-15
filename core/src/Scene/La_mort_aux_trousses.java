package Scene;

public class La_mort_aux_trousses extends Scene{
	private static String sceneName = "La mort aux trousses";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 27, 60+55}, {1110, 98, 90, 26, 28, 120+3}};
	private static float[] audioInfo = {1.9F, 120+14.8F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public La_mort_aux_trousses () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
