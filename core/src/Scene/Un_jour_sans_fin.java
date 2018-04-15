package Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import la.plume.noire2.LaPlumeNoire2;

public class Un_jour_sans_fin extends Scene{
	private static String sceneName = "Un jour sans fin";
	private static boolean asBoucle = false;
	private static int mouvement = 0;
	private static boolean asEnd = false;
	private static boolean asCoin = false;
	private static int[] boucleInfo = {0, 0};
	private static int[][] textInfo = {{1110, 98, 90, 124, 38, 120+52}, {1110, 98, 90, 26, 39, 180}};
	private static float[] audioInfo = {1.9F, 180+22};
	private static float[] coinTime = {0, 0, 0, 0, 0};
	
	private int switchStat = 0;
	private int[] switchScreenID = {20, 21, 26, 30, 28, 29};
	private float[] switchScreenTime = {60+11, 60+17.6F, 60+26.2F, 60+49.9F, 120+20, 120+43.9F};
	
	public Un_jour_sans_fin () {
		super(sceneName, asBoucle, mouvement, asEnd, asCoin, boucleInfo, textInfo, audioInfo, coinTime);
		if(Gdx.app.getType().name().equals("Desktop")) {
			endBeginFile = Gdx.files.internal("bin/endBegin.jpg");
			endEndFile = Gdx.files.internal("bin/" + sceneName + "/endEnd.jpg");
		}else if(Gdx.app.getType().name().equals("Android")) {
			endBeginFile = Gdx.files.internal("endBegin.jpg");
			endEndFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/endEnd.jpg");
		}
	}
	
	@Override
	public void load () {
		audio = Gdx.audio.newMusic(audioFile);
		introBegin = new Pixmap(introBeginFile);
		textBegin = new Pixmap(textBeginFile);
		if(passAudio){
			introEnd = new Pixmap(introEndFile);
		}else{
			introEnd = new Pixmap(LaPlumeNoire2.getScene(switchScreenID[0]).introEndFile);
			boucle = LaPlumeNoire2.getScene(switchScreenID[0]).boucle;
			boucleInfo = LaPlumeNoire2.getScene(switchScreenID[0]).boucleInfo;
		}
		textEnd = new Pixmap(textEndFile);
		if(!isPause){
			img = new Texture(introBegin);
		}else{
			if(passAudio){
				img = new Texture(introEndFile);
			}else{
				switchStat = 0;
				Pixmap pixmap = new Pixmap(boucle[0]);
				img = new Texture(pixmap);
				pixmap.dispose();
			}
		}
		imgText = new Texture(textBegin);
		singleDraw = false;
	}
	
	@Override
	public void update () {
		if(isPause){
			unPause();
		}
		
		if(stat == 0){
			if(LaPlumeNoire2.getLanch().isPlaying()){
				if(firstScene){
					if(System.currentTimeMillis() - time >= 20){
						imgApear(true, true);
						time += 20;
					}
				}else{
					if(System.currentTimeMillis() - time >= 10){
						imgApear(false, true);
						time += 10;
					}
				}
			}else{
				introBegin.dispose();
				introEnd.dispose();
				if(passAudio){
					introBegin = new Pixmap(introEndFile);
					introEnd = new Pixmap(introBeginFile);
				}else{
					introBegin = new Pixmap(LaPlumeNoire2.getScene(switchScreenID[switchStat]).introEndFile);
					introEnd = new Pixmap(endBeginFile);
				}
				
				stat++;
				LaPlumeNoire2.getLanch().stop();
				preS = new int[55];
				frameText = new int[textInfo.length];
				startTimeText = new float[textInfo.length];
				timeText = System.currentTimeMillis();
				startText = new boolean[textInfo.length];
				endText = new boolean[textInfo.length];
				for(int i=0; i < textInfo.length; i++){
					startText[i] = true;
					endText[i] = false;
				}
				audio.play();
				if((passAudio || isAudioFinish) && !LaPlumeNoire2.isLastScenes()){
					audio.setPosition(audioInfo[1]);
					switchStat = switchScreenID.length;
				}
			}
			
		}else if(stat == 1){
			if(!audio.isPlaying() && !LaPlumeNoire2.isLastScenes()){
				audio.play();
				audio.setPosition(audioInfo[1]);
			}
			
			if(switchStat < switchScreenID.length){
				if(switchStat == 0){
					if(System.currentTimeMillis() - time > 33){
						if(frame < boucleInfo[1]-1){
							frame++;
						}else{
							frame = boucleInfo[0];
						}
						img.dispose();
						Pixmap pixmap = new Pixmap(boucle[frame]);
						img = new Texture(pixmap);
						pixmap.dispose();
						time += 33;
					}
					
				}else{
					if(!singleDraw){
						img = new Texture(LaPlumeNoire2.getScene(switchScreenID[switchStat]).introEndFile);
						singleDraw = true;
					}
				}
				if(switchScreenTime[switchStat] <= audio.getPosition()){
					singleDraw = false;
					stat++;
				}
			}else{
				if(!singleDraw){
					img = new Texture(introEndFile);
					singleDraw = true;
				}
				if(System.currentTimeMillis() - timeText >= 40){
					for(int i=0; i < textInfo.length; i++){
						if(isText(i)){
							textApear(i, false);
						}
					}
					timeText += 40;
				}
			}
			
		}else if(stat == 2){
			if(switchScreenTime[switchStat] + 2 > audio.getPosition()){
				if(System.currentTimeMillis() - time >= 20){
					imgEndApear(true);
					time += 20;
				}
			}else{
				img.dispose();
				img = new Texture(introEnd);
				introBegin.dispose();
				introBegin = new Pixmap(endBeginFile);
				introEnd.dispose();
				if(switchStat < switchScreenID.length-1){
					introEnd = new Pixmap(LaPlumeNoire2.getScene(switchScreenID[switchStat+1]).introEndFile);
				}else{
					introEnd = new Pixmap(introEndFile);
				}
				stat++;
			}
			
		}else if(stat == 3){
			if(switchScreenTime[switchStat] + 4 > audio.getPosition()){
				if(System.currentTimeMillis() - time >= 20){
					imgEndApear(false);
					time += 20;
				}
			}else{
				preS = new int[55];
				img.dispose();
				img = new Texture(introEnd);
				introBegin.dispose();
				introEnd.dispose();
				if(switchStat < switchScreenID.length-1){
					introBegin = new Pixmap(LaPlumeNoire2.getScene(switchScreenID[switchStat+1]).introEndFile);
					introEnd = new Pixmap(endBeginFile);
				}else{
					introBegin = new Pixmap(introEndFile);
					introEnd = new Pixmap(introBeginFile);
				}
				switchStat++;
				stat = 1;
			}
			
		}else if(stat == 4){
			if(LaPlumeNoire2.getLanch().getPosition() < 1.5F){
				if(System.currentTimeMillis() - time >= 10){
					imgApear(false, false);
					if(asText){
						for(int i=0; i < textInfo.length; i++){
							textApear(i, true);
						}
					}
					time += 10;
				}
			}else{
				if(asText){
					textBegin.drawPixmap(textEnd, 0, 0);
					imgText.dispose();
					imgText = new Texture(textBegin);
				}
				stat = 0;
				preS = new int[25];
				preTextS = new int[85];
				firstScene = false;
				if(!LaPlumeNoire2.isLastScenes()){
					passAudio = true;
				}
				LaPlumeNoire2.change();
			}
		}
	}
	
	@Override
	public void imgEndApear (boolean intro) {
		int s = 0;
		if(intro){
			s = 28 - (int)(((2f - (audio.getPosition() - switchScreenTime[switchStat]))/2f) * 28);
		}else{
			s = 29 - (int)(((2f - (audio.getPosition() - switchScreenTime[switchStat] - 2))/2f) * 29);
		}
		if(frame < 6-1){
			frame ++;
		}else{
			frame = 0;
		}
		for(int x=frame; x <= 54; x+=6){
			for(int f=0; f < s-preS[x]; f++){
				if(x%2 == 0){
					for(int y=0; y <= 318/2; y+=8){
						for(int a=y; a < y+8; a++){
							introBegin.drawPixel(((x*14)+s-f) - 14, y+a, introEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}else{
					for(int y=4; y <= 318/2; y+=8){
						for(int a=y; a < y+8; a++){
							introBegin.drawPixel(((x*14)+s-f) - 14, y+a, introEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}
			}
			preS[x] = s;
		}
		img.dispose();
		img = new Texture(introBegin);
	}
	
	@Override
	public void close(boolean back) {
		if(mouvement == 1){
			mouvementPos = 0;
		}else if(mouvement == 2){
			mouvementPos = mouvementSave;
		}
		audio.stop();
		isAudioFinish = false;
		textBegin.dispose();
		textBegin = new Pixmap(textEndFile);
		if(asText){
			textEnd.dispose();
			textEnd = new Pixmap(textBeginFile);
		}
		if(coin != null){
			LaPlumeNoire2.destroyCoin();
			coinStat = 0;
			isCoin = false;
			coin = null;
		}
		if(back){
			stat = 0;
		}else{
			stat = 4;
			if(!LaPlumeNoire2.isLastScenes()){
				System.out.println("ok");
				passAudio = true;
			}
		}
		time = System.currentTimeMillis();
	}
}
