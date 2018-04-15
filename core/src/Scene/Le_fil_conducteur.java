package Scene;

public class Le_fil_conducteur extends Scene{
	private static String sceneName = "Le fil conducteur";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = true;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 34, 60+18-15}, {1110, 65, 90, 92, 28, 60+18-10}, {1110, 66, 90, 26, 31, 60+18-5}};
	private static float[] audioInfo = {2.1F, 60+18, 60+22};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_fil_conducteur () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
