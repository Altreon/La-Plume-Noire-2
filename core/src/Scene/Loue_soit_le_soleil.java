package Scene;

public class Loue_soit_le_soleil extends Scene{
	//I
	//LA
	//LE
	private static String sceneName = "Loue soit le soleil";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = true;
	private static int[] boucleInfo = {0, 750};
	private static int[][] textInfo = {{1110, 98, 90, 124, 10, 120+31}, {1110, 98, 90, 26, 20, 120+39}};
	private static float[] audioInfo = {2.1F, 120+45.8F};
	private static float[] coinTime =  {120+10.25F, 120+27.3F, 120+18, 120+15.65F, 120+19.22F};
	public Loue_soit_le_soleil () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
