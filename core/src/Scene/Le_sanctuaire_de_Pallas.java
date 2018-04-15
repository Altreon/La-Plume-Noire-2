package Scene;

public class Le_sanctuaire_de_Pallas extends Scene{
	private static String sceneName = "Le sanctuaire de Pallas";
	private static boolean asBoucle = false;
	private static int mouvement = 1;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 65, 90, 157, 12, 60+45}, {1110, 65, 90, 92, 16, 120+1}, {1110, 66, 90, 26, 13, 120+6}};
	private static float[] audioInfo = {1.9F, 120+15.4F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Le_sanctuaire_de_Pallas () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
