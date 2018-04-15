package Scene;

public class N_est_pas_mort_ce_qui_a_jamais_dort extends Scene{
	private static String sceneName = "N est pas mort ce qui a jamais dort";
	private static boolean asBoucle = true;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 30};
	private static int[][] textInfo = {{1110, 98, 90, 124, 11, 120+33}, {1110, 98, 90, 26, 20, 120+40}};
	private static float[] audioInfo = {2.05F, 120+45.5F};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	public N_est_pas_mort_ce_qui_a_jamais_dort () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
	}
}
