package Scene;

import com.badlogic.gdx.Gdx;
//Import for DebugMode :
//import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import la.plume.noire2.Coin;
import la.plume.noire2.LaPlumeNoire2;

public class Scene{
	protected FileHandle[] boucle;
	protected FileHandle introBeginFile;
	protected FileHandle introEndFile;
	protected FileHandle textBeginFile;
	protected FileHandle textEndFile;
	protected FileHandle endBeginFile;
	protected FileHandle endEndFile;
	protected FileHandle coinFile1;
	protected FileHandle coinFile2;
	
	protected Texture img;
	protected Pixmap introBegin;
	protected Pixmap introEnd;
	
	protected Texture imgText;
	protected Pixmap textBegin;
	protected Pixmap textEnd;
	
	protected FileHandle audioFile;
	protected Music audio;
	private boolean asBoucle;
	private int mouvement;
	protected boolean asEnd;
	private boolean asCoin;
	protected boolean isEnd = false;
	protected boolean isCoin = false;
	protected Coin coin;
	
	protected int[] boucleInfo;
	protected boolean speBoucle = false;
	protected float mouvementPos = 0;
	protected int mouvementSave = 0;
	protected boolean mouv = false;
	protected float mouvSt = 0;
	private int[][] textInfo;
	private float[] audioInfo;
	private float[] coinTime;
	protected int coinStat = 0;
	protected float coinStart;
	protected boolean coinTurn;
	
	protected int[] preS = new int[25];
	protected int[] preTextS = new int[85];
	
	protected int frame = 0;
	protected long time;
	
	protected boolean singleDraw = false;
	
	protected int[] frameText;
	protected float[] startTimeText;
	protected long timeText;
	protected boolean[] startText;
	protected boolean[] endText;
	
	protected boolean firstScene = false;
	protected boolean passAudio = false;
	protected int stat = 0;
	
	protected boolean asText = true;
	protected boolean isLastScene = false;
	
	protected static boolean isPause = false;
	protected static boolean isAudioFinish = false;
	
	private boolean enigma = false;
	private FileHandle textEndEnigmaFile;
	private int frameTextEnigma = 0;
	private float startTimeEnigma;
	private float preventDuration;
		
	public Scene (String sceneName, boolean asBoucle, int mouvement, boolean asEnd, boolean asCoin, int[] boucleInfo, int[][] textInfo, float[] audioInfo, float[] coinTime) {
		this.asBoucle = asBoucle;
		this.mouvement = mouvement;
		this.asEnd = asEnd;
		this.asCoin = asCoin;
		
		if(Gdx.app.getType().name().equals("Desktop")) {
			loadFile("bin/" + sceneName + "/boucle");
			introBeginFile = Gdx.files.internal("bin/introBegin.jpg");
			textBeginFile = Gdx.files.internal("bin/textBegin.jpg");
			if(asBoucle){
				introEndFile = Gdx.files.internal("bin/" + sceneName + "/boucle/img-0001.jpg");
			}else{
				introEndFile = Gdx.files.internal("bin/" + sceneName + "/introEnd.jpg");
			}
			if(!sceneName.equals("Gnothi seauton part1")){
				textEndFile = Gdx.files.internal("bin/" + sceneName + "/textEnd.jpg");
			}else{
				asText = false;
			}
			if(asEnd){
				endBeginFile = Gdx.files.internal("bin/endBegin.jpg");
				endEndFile = Gdx.files.internal("bin/" + sceneName + "/endEnd.jpg");
			}
			if(asCoin){
				coinFile1 = Gdx.files.internal("bin/" + sceneName + "/coin1.png");
				coinFile2 = Gdx.files.internal("bin/" + sceneName + "/coin2.png");
			}
			if(sceneName.equals("La vie des hauts")){
				textEndEnigmaFile = Gdx.files.internal("bin/" + sceneName + "/textEndEnigma.jpg");
			}
			this.audioFile = Gdx.files.internal("bin/" + sceneName + "/audio.ogg");
		}else if(Gdx.app.getType().name().equals("Android")) {
			loadFile(LaPlumeNoire2.data + "/" + sceneName + "/boucle");
			introBeginFile = Gdx.files.internal("introBegin.jpg");
			textBeginFile = Gdx.files.internal("textBegin.jpg");
			if(asBoucle){
				introEndFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/boucle/img-0001.jpg");
			}else{
				introEndFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/introEnd.jpg");
			}
			if(!sceneName.equals("Gnothi seauton part1")){
				textEndFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/textEnd.jpg");
			}else{
				asText = false;
			}
			if(asEnd){
				endBeginFile = Gdx.files.internal("endBegin.jpg");
				endEndFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/endEnd.jpg");
			}
			if(asCoin){
				coinFile1 = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/coin1.png");
				coinFile2 = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/coin2.png");
			}
			if(sceneName.equals("La vie des hauts")){
				textEndEnigmaFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/textEndEnigma.jpg");
			}
			this.audioFile = Gdx.files.absolute(LaPlumeNoire2.data + "/" + sceneName + "/audio.ogg");
		}
		
		if(sceneName.equals("Gnothi seauton part2")){
			isLastScene = true;
			speBoucle = true;
		}else if(sceneName.equals("Loue soit le soleil")){
			speBoucle = true;
		}

		this.boucleInfo = boucleInfo;
		this.textInfo = textInfo;
		this.audioInfo = audioInfo;
		this.coinTime = coinTime;
	}
	
	public void pause(){
		preS = new int[25];
		preTextS = new int[85];
		
		frame = 0;
		
		stat = 0;
		if(!LaPlumeNoire2.isLastScenes() && canRepeat()){
			isAudioFinish = true;
		}
		audio.stop();
		unload();
		isPause = true;
	}
	
	public void unPause () {
		load();
		if(isEnd){
			audio.play();
			audio.setPosition(audioInfo[2]);
		}
		isPause = false;
		time = System.currentTimeMillis();
	}
	
	public void load () {
		audio = Gdx.audio.newMusic(audioFile);
		introBegin = new Pixmap(introBeginFile);
		textBegin = new Pixmap(textBeginFile);
		introEnd = new Pixmap(introEndFile);
		if(mouvement == 1){
			mouvementSave = introEnd.getWidth()-742;
		}else if(mouvement == 2){
			mouvementSave = introEnd.getHeight()-318;
			
		}
		if(asText){
			textEnd = new Pixmap(textEndFile);
		}
		if(!isPause){
			img = new Texture(introBegin);
		}else{
			if(asBoucle){
				Pixmap pixmap = new Pixmap(boucle[0]);
				img = new Texture(pixmap);
				pixmap.dispose();
			}else{
				img = new Texture(introEndFile);
			}
		}
		imgText = new Texture(textBegin);
		singleDraw = false;
	}
	
	public void unload () {
		introBegin.dispose();
		if(asText){
			textBegin.dispose();
			textEnd.dispose();
		}
		if(coin != null){
			coinStat = 0;
			coinStart = 0;
			LaPlumeNoire2.destroyCoin();
			isCoin = false;
			coin = null;
		}
		introEnd.dispose();
		img.dispose();
		imgText.dispose();
		audio.dispose();
		mouvementPos = 0;
		mouvementSave = 0;
		mouv = false;
		mouvSt = 0;
		enigma = false;
	}
	
	private void loadFile (String folderPath) {
		FileHandle folder = Gdx.files.absolute(folderPath);
		boucle = new FileHandle[folder.list().length];
		int i=0;
		for (FileHandle file : folder.list()) {
			boucle[i] = file;
			i++;
		}
	}
	
	public FileHandle[] getBoucle () {
		return boucle;
	}
	
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
				if(!speBoucle){
					introBegin = new Pixmap(introEndFile);
				}else{
					introBegin = new Pixmap(boucle[boucleInfo[1]-1]);
				}
				introEnd.dispose();
				introEnd = new Pixmap(introBeginFile);
				
				stat++;
				LaPlumeNoire2.getLanch().stop();
				preS = new int[25];
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
				}
				if(mouvement != 0){
					mouvSt = audio.getPosition();
				}
			}
			
		}else if(stat == 1){
			if(mouvement != 0 && !mouv){
				if(mouvement == 1){
					mouvementPos = mouvementSave;
				}else{
					mouvementPos = 0;
				}
				mouv = true;
			}
			if(!audio.isPlaying() && !LaPlumeNoire2.isLastScenes()){
				if(enigma){
					startTimeEnigma = audioInfo[1]-(preventDuration-startTimeEnigma);
				}
				audio.play();
				audio.setPosition(audioInfo[1]);
			}
			
			//DebugMode :
			/*if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
				if(LaPlumeNoire2.isLastScenes()){
					audio.stop();
				}else if(audioInfo[1] > audio.getPosition()){
					audio.setPosition(audioInfo[1]);
					if(asText){
						textBegin.drawPixmap(textEnd, 0, 0);
						for(int i=0; i < endText.length; i++){
							endText[0] = true;
						}
				
						imgText.dispose();
						imgText = new Texture(textBegin);
					}
					if(!passAudio && asItem && !isItem && itemTime <= audio.getPosition()){
						LaPlumeNoire2.addItem(itemName);
						isItem = true;
					}
				}
			}*/
			
			if(asBoucle){
				if(!speBoucle){
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
				}else if(frame < boucleInfo[1]-1 && System.currentTimeMillis() - time > 33){
					frame++;
					img.dispose();
					Pixmap pixmap = new Pixmap(boucle[frame]);
					img = new Texture(pixmap);
					pixmap.dispose();
					time += 33;
				}
				
			}else{
				if(!singleDraw){
					img = new Texture(introEndFile);
					singleDraw = true;
				}
			}
			
			if(mouvement == 1 && mouvementPos > 0){
				if(audio.getPosition() - mouvSt >= 0.05){
					float i;
					if(passAudio){
						i = mouvementSave-(mouvementSave*((audio.getPosition()-audioInfo[1])/25F));
						if(((audio.getPosition()-audioInfo[1])/25F) < 1){
							mouvementPos = i*(i/mouvementSave);
						}else{
							mouvementPos = 0;
						}
					}else{
						i = mouvementSave-(mouvementSave*(audio.getPosition()/25F));
						if((audio.getPosition()/25F) < 1){
							mouvementPos = i*(i/mouvementSave);
						}else{
							mouvementPos = 0;
						}
					}
					mouvSt += 0.05;
				}
			}else if(mouvement == 2 && mouvementPos < mouvementSave){
				if(audio.getPosition() - mouvSt >= 0.05){
					float i;
					if(passAudio){
						i = mouvementSave-(mouvementSave*((audio.getPosition()-audioInfo[1])/25F));
						if(((audio.getPosition()-audioInfo[1])/25F) < 1){
							mouvementPos = mouvementSave-(i*(i/mouvementSave));
						}else{
							mouvementPos = mouvementSave;
						}
					}else{
						i = mouvementSave-(mouvementSave*(audio.getPosition()/25F));
						if((audio.getPosition()/25F) < 1){
							mouvementPos = mouvementSave-(i*(i/mouvementSave));
						}else{
							mouvementPos = mouvementSave;
						}
					}
					mouvSt += 0.05;
				}
			}
			
			if(asText && !isLastScene){
				if(passAudio){
					if(System.currentTimeMillis() - timeText >= 20){
						for(int i=0; i < textInfo.length; i++){
							if(isText(i)){
								textApear(i, false);
							}
						}
						timeText += 20;
					}
				}else{
					if(System.currentTimeMillis() - timeText >= 40){
						for(int i=0; i < textInfo.length; i++){
							if(isText(i)){
								textApear(i, false);
							}
						}
						timeText += 40;
					}
				}
			}else{
				if(!isLastScene){
					if(!audio.isPlaying()){
						close(false);
						System.out.println("changeScene : " + 41);
						LaPlumeNoire2.changeScene(41);
					}
				}else{
					if(System.currentTimeMillis() - timeText >= 40){
						for(int i=0; i < textInfo.length; i++){
							if(isText(i)){
								textApear(i, false);
							}
						}
						timeText += 40;
					}
					if(!audio.isPlaying()){
						close(false);
						unload();
						stat = 0;
						LaPlumeNoire2.ending();
					}
				}
			}
			if(asCoin && !isCoin && coinTime[0] <= audio.getPosition() && coinTime[1] > audio.getPosition()){
				coin = new Coin(new Texture(coinFile1));
				LaPlumeNoire2.addCoin(coin);
				isCoin = true;
				coinTurn = true;
				coinStat = 0;
				coinStart = audio.getPosition();
			}else if(isCoin){
				if(coinStat == 0){
					if(audio.getPosition() - coinStart >= 0.2){
						LaPlumeNoire2.playCoinSound();
						coin.setY(330);
						coinStat++;
					}else{
						coin.setY(720 - (int)(((audio.getPosition() - coinStart) / 0.2) * 390));
					}
				}else if(coinStat == 1){
					if(coinTime[2] <= audio.getPosition()){
						if(coinTurn){
							coin.setScale(coin.getScaleX()-0.025f, 1);
							if(coin.getScaleX() <= 0){
								coin.getTexture().dispose();
								coin.setTexture(new Texture(coinFile2));
								coinTurn = false;
							}
						}else{
							coin.setScale(coin.getScaleX()+0.025f, 1);
							if(coin.getScaleX() >= 1){
								coinTurn = true;
								coinStat++;
							}
						}
					}
				}else if(coinStat == 2){
					if(coinTime[1] <= audio.getPosition()){
						LaPlumeNoire2.playCoinSound();
						coinStat++;
						coinStart = audio.getPosition();
					}
				}else if(coinStat == 3){
					if(audio.getPosition() - coinStart >= 0.2){
						coin.setY(0);
						coinStat++;
					}else{
						coin.setY(330 - (int)(((audio.getPosition() - coinStart) / 0.2) * 390));
					}
				}else if(coinStat == 4){
					//if(audio.getPosition() - coinStart >= 0.2){
						LaPlumeNoire2.destroyCoin();
						coinStat = 0;
						isCoin = false;
						coin = null;
					/*}else{
						coin.setY(330 - (int)(((audio.getPosition() - coinStart) / 0.2) * 330));
					}*/
				}
			}
			
			if(enigma){
				textApearEnigma();
				preventDuration = audio.getPosition();
			}
			
			if(asEnd && audioInfo[2] <= audio.getPosition()){
				LaPlumeNoire2.startEnd();
				isEnd = true;
				preS = new int[55];
				introEnd.dispose();
				introEnd = new Pixmap(endBeginFile);
				textBegin.dispose();
				if(asText){
					textBegin = new Pixmap(textEndFile);
				}
				textEnd.dispose();
				textEnd = new Pixmap(textBeginFile);
				for(int i=0; i < textInfo.length; i++){
					startText[i] = true;
				}
				stat++;
			}
			
		}else if(stat == 2){
			if(audioInfo[2] + 2 > audio.getPosition()){
				if(System.currentTimeMillis() - time >= 20){
					imgEndApear(true);
					if(asText){
						for(int i=0; i < textInfo.length; i++){
							textEndApear(true);
						}
					}
					time += 20;
				}
			}else{
				img.dispose();
				img = new Texture(introEnd);
				imgText.dispose();
				imgText = new Texture(textEnd);
				introBegin.dispose();
				introBegin = new Pixmap(endBeginFile);
				textBegin.dispose();
				textBegin = new Pixmap(textBeginFile);
				introEnd.dispose();
				introEnd = new Pixmap(LaPlumeNoire2.getIntroDeath());
				textEnd.dispose();
				textEnd = new Pixmap(endEndFile);
				stat++;
			}
			
		}else if(stat == 3){
			if(audioInfo[2] + 4 > audio.getPosition()){
				if(System.currentTimeMillis() - time >= 20){
					imgEndApear(false);
					for(int i=0; i < textInfo.length; i++){
						textEndApear(false);
					}
					time += 20;
				}
			}else{
				preS = new int[25];
				preTextS = new int[85];
				img.dispose();
				img = new Texture(introEnd);
				imgText.dispose();
				imgText = new Texture(textEnd);
				introBegin.dispose();
				introBegin = new Pixmap(LaPlumeNoire2.getIntroDeath());
				introEnd.dispose();
				introEnd = new Pixmap(introBeginFile);
				if(asText){
					textEnd.dispose();
					textEnd = new Pixmap(textBeginFile);
				}
				LaPlumeNoire2.endEnd();
				stat = -1;
			}
		}else if(stat == -1){
			if(System.currentTimeMillis() - time > 33){
				if(frame < 90-1){
					frame++;
				}else{
					frame = 0;
				}
				img.dispose();
				Pixmap pixmap = new Pixmap(LaPlumeNoire2.getDeathFile()[frame]);
				img = new Texture(pixmap);
				pixmap.dispose();
				time += 33;
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
				isEnd = false;
				LaPlumeNoire2.change();
			}
		}
	}
	
	public void imgApear (boolean intro, boolean appear) {
		int s = 0;
		if(intro){
			s = 28 - (int)(((3f - LaPlumeNoire2.getLanch().getPosition())/3f) * 28);
		}else{
			s = 29 - (int)(((1.5f - LaPlumeNoire2.getLanch().getPosition())/1.5f) * 29);
			if(stat == 0){
				s = s-29;
			}
		}
		if(frame < 6-1){
			frame ++;
		}else{
			frame = 0;
		}
		
		if(mouvement == 0 || !appear){
			for(int y=24-frame; y >= 0; y-=6){
				for(int f=0; f < s-preS[y]; f++){
					if(y%2 == 0){
						for(int x=0; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a, (y*14)-s+f));
							}
						}
					}else{
						for(int x=4; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a, (y*14)-s+f));
							}
						}
					}
				}
				preS[y] = s;
			}
		}else if(mouvement == 1){
			for(int y=24-frame; y >= 0; y-=6){
				for(int f=0; f < s-preS[y]; f++){
					if(y%2 == 0){
						for(int x=0; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a+mouvementSave, (y*14)-s+f));
							}
						}
					}else{
						for(int x=4; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a+mouvementSave, (y*14)-s+f));
							}
						}
					}
				}
				preS[y] = s;
			}
		}else{
			for(int y=24-frame; y >= 0; y-=6){
				for(int f=0; f < s-preS[y]; f++){
					if(y%2 == 0){
						for(int x=0; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a, (y*14+mouvementSave)-s+f));
							}
						}
					}else{
						for(int x=4; x <= 742/2; x+=8){
							for(int a=x; a < x+8; a++){
								introBegin.drawPixel(x+a, (y*14)-s+f, introEnd.getPixel(x+a, (y*14+mouvementSave)-s+f));
							}
						}
					}
				}
				preS[y] = s;
			}
		}
		
		img.dispose();
		img = new Texture(introBegin);
	}
	
	public void imgEndApear (boolean intro) {
		int s = 0;
		if(intro){
			s = 28 - (int)(((2f - (audio.getPosition() - audioInfo[2]))/2f) * 28);
		}else{
			s = 29 - (int)(((2f - (audio.getPosition() - audioInfo[2] - 2))/2f) * 29);
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
	
	public void textApear(int i, boolean end){
		int s = 0;
		int startY = 0;
		int endY =0;
		if(!end){
			if(passAudio){
				s = 28 - (int)(((1.5F - (audio.getPosition()-startTimeText[i]))/1.5F) * 28);
			}else{
				s = 28 - (int)(((4F - (audio.getPosition()-startTimeText[i]))/4F) * 28);
			}
			if(textInfo.length == 1 || passAudio){
				startY = 0;
				endY = 98;
			}else if(textInfo.length == 2){
				startY = (98/2)*i;
				endY = (98/2)*(i+1);
			}else{
				if(i == 2){
					startY = 66;
					endY = 98;
				}else{
					startY = (65/2)*i;
					endY = (65/2)*(i+1);
				}
			}
		}else{
			s = 29 - (int)(((1.5f - LaPlumeNoire2.getLanch().getPosition())/1.5f) * 29);
			startY = 0;
			endY = 98;
		}
		if(frameText[i] < 6-1){
			frameText[i] ++;
		}else{
			frameText[i] = 0;
		}
		for(int x=frameText[i]; x <= 84; x+=6){
			for(int f=0; f < s-preTextS[x]; f++){
				if(x%2 == 0){
					for(int y=startY; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}else{
					for(int y=startY+4; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}
			}
			preTextS[x] = s;
		}
		
		if(s > 30){
			if(textInfo.length == 1){
				textBegin.drawPixmap(textEnd, 0, 0);
			}else if(textInfo.length == 2){
				textBegin.drawPixmap(textEnd, 0, 98*i, 0, 98*i, 1110, 98);
			}else{
				if(i == 2){
					textBegin.drawPixmap(textEnd, 0, 65+66, 0, 65+66, 1110, 66);
				}else if(i == 1){
					textBegin.drawPixmap(textEnd, 0, 65, 0, 65, 1110, 65);
				}else{
					textBegin.drawPixmap(textEnd, 0, 0, 0, 0, 1110, 65);
				}
			}
			endText[i] = true;
		}
		
		imgText.dispose();
		imgText = new Texture(textBegin);
	}
	
	public void textEndApear(boolean intro){
		int s = 0;
		int startY = 0;
		int endY = 98;
		if(intro){
			s = 28 - (int)(((2f - (audio.getPosition() - audioInfo[2]))/2f) * 28);
		}else{
			s = 29 - (int)(((2f - (audio.getPosition() - audioInfo[2] - 2))/2f) * 29);
		}
		if(frameText[0] < 6-1){
			frameText[0] ++;
		}else{
			frameText[0] = 0;
		}
		for(int x=frameText[0]; x <= 84; x+=6){
			for(int f=0; f < s-preTextS[x]; f++){
				if(x%2 == 0){
					for(int y=startY; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}else{
					for(int y=startY+4; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}
			}
			preTextS[x] = s;
		}
		
		if(s > 30){
			textBegin.drawPixmap(textEnd, 0, 0);
			endText[0] = true;
		}
		
		imgText.dispose();
		imgText = new Texture(textBegin);
	}
	
	public int[] getCoinCache () {
		int[] r = new int[3];
		if(coinStat < 1 || (coinStat == 1 && coinTurn)){
			r[1] = 0;
			if(coinTime[3] <= audio.getPosition()){
				r[0] = 0;
			}else{
				r[0] = 1;
			}
		}else{
			r[1] = 1;
			if(coinTime[4] <= audio.getPosition()){
				r[0] = 0;
			}else{
				r[0] = 1;
			}
			r[2] = (int)(215*coin.getScaleX());
		}
		return r;
	}
	
	public void setAudio(float pos) {
		audio.setPosition(pos);
		if(mouvement == 1 && mouvementPos > 0){
			mouvementPos = 0;
		}else if(mouvement == 2 && mouvementPos < mouvementSave){
			mouvementPos = mouvementSave;
		}
	}
	
	public Texture getImg() {
		return img;
	}
	
	public Texture getImgText() {
		return imgText;
	}
	
	public Music getAudio () {
		return audio;
	}
	
	public int[] getBoucleInfo() {
		return boucleInfo;
	}
	
	public int[][] getTextInfo() {
		return textInfo;
	}
	
	public float[] getAudioInfo() {
		return audioInfo;
	}
	
	public void passAudio(){
		passAudio = true;
	}
	
	public void reniPassAudio(){
		passAudio = false;
	}
	
	public boolean getPassAudio () {
		return passAudio;
	}
	
	public boolean canClick (int i) {
		if(stat == 1 && !enigma){
			return endText[i];
		}else{
			return false;
		}
	}

	public boolean isText(int i) {
		if(audio.getPosition() >= textInfo[i][5] || passAudio){
			if(startText[i]){
				startTimeText[i] = audio.getPosition();
				startText[i] = false;
			}
			if(!endText[i]){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean isMouvement(){
		if(mouvement == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isXMouvement(){
		if(mouvement == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public float getMouvementPos(){
		return mouvementPos;
	}
	
	public void enigma(){
		enigma = true;
		textEnd.dispose();
		textEnd = new Pixmap(textEndEnigmaFile); 
		startTimeEnigma = audio.getPosition();
	}
	
	public void textApearEnigma(){
		int s = 28 - (int)(((4F - (audio.getPosition()-startTimeEnigma))/4F) * 28);
		int startY = (65/2)*1;
		int endY = (65/2)*(1+1);
		if(frameTextEnigma < 6-1){
			frameTextEnigma ++;
		}else{
			frameTextEnigma = 0;
		}
		for(int x=frameTextEnigma; x <= 84; x+=6){
			for(int f=0; f < s-preTextS[x]; f++){
				if(x%2 == 0){
					for(int y=startY; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}else{
					for(int y=startY+4; y <= endY; y+=8){
						for(int a=y; a < y+8; a++){
							textBegin.drawPixel(((x*14)+s-f) - 14, y+a, textEnd.getPixel(((x*14)+s-f) - 14, y+a));
						}
					}
				}
			}
			preTextS[x] = s;
		}
		
		if(s > 30){
			textBegin.drawPixmap(textEnd, 0, (65/2), 0, (65/2), 1110, 65);
		}
		
		imgText.dispose();
		imgText = new Texture(textBegin);
		
		if(s > 30){
			close(false);
			System.out.println("changeScene : " + 25);
			LaPlumeNoire2.changeScene(25);
		}
	}
	
	public void setFirstScene() {
		firstScene = true;
	}
	
	public void start() {
		time = System.currentTimeMillis();
	}

	public void close(boolean back) {
		if(mouvement == 1){
			mouvementPos = 0;
		}else if(mouvement == 2){
			mouvementPos = mouvementSave;
		}
		audio.stop();
		isAudioFinish = false;
		textBegin.dispose();
		if(!isEnd && asText){
			if(!enigma){
				textBegin = new Pixmap(textEndFile);
			}else{
				textBegin = new Pixmap(textEndEnigmaFile);
			}
		}else if(asText){
			textBegin = new Pixmap(endEndFile);
		}
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
				passAudio = true;
			}
		}
		enigma = false;
		time = System.currentTimeMillis();
	}

	public boolean canRepeat() {
		if(audioInfo[1] <= audio.getPosition() && endText[0] && !asEnd && !enigma){
			return true;
		}else{
			return false;
		}
	}
}
