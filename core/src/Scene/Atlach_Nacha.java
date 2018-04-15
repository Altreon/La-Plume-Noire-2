package Scene;

public class Atlach_Nacha extends Scene{
	private static String sceneName = "Atlach-Nacha";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 90};
	private static int[][] textInfo = {{1110, 98, 90, 124, 28, 120+1}, {1110, 98, 90, 26, 25, 120+7}};
	private static float[] audioInfo = {2.05F, 120+18.3F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Atlach_Nacha () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
