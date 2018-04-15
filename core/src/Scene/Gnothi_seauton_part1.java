package Scene;

public class Gnothi_seauton_part1 extends Scene{
	private static String sceneName = "Gnothi seauton part1";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{0}};
	private static float[] audioInfo = {0};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public Gnothi_seauton_part1 () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
