package stellasia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import object.Armor;
import object.BuildingSpace;
import object.Item;
import object.Material;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;

public class Market extends BuildingSpace {

	public void goThere(Player player) throws InterruptedException, IOException,
			NumberFormatException, NoMonsterNameException, NoItemNameException {

		tl.showSlowMessage("てくてく・・・・\n\n\n\n" + player.name + "はステラ市場(いちば)についた");

		tl.showSlowMessage("多くの人でにぎわっていて\nこころもウキウキしてくる");
		boolean goOut = false;
		tl.showPlayerInfo(player);
		inMarket(player);
	//メインメソッドおわり
	}

	private void inMarket(Player player) throws InterruptedException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		boolean goOut = false;
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("なにをしようか？");
			tl.showSlowMessage("1：アイテム屋「星の砂」");
			tl.showSlowMessage("2：素材屋「ハガネ亭」");
			tl.showSlowMessage("3：武器パーツ屋「アルテマバスター」");
			tl.showSlowMessage("4：周りの人とお話をする");
			tl.showSlowMessage("0：ここから立ち去る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int marSelect = tl.command_input(0, 4);
			switch (marSelect) {

			case 1:
				hosinosuna(player);
				break;

			case 2:
				haganeTei(player);
				break;

			case 3:
				ultimaBunter(player);
				break;

			case 4:
				talkMarket();
				break;

			case 0:
				goOut = tl.goOut("ステラ市場",player);
				break;
			//スイッチおわり
			}
		// ループのおわり
		}
	//メソッドおわり

	}

	private void talkMarket() {
		// TODO 自動生成されたメソッド・スタブ


	}

	private void ultimaBunter(Player player) throws IOException, InterruptedException {
		// TODO 自動生成されたメソッド・スタブ
		boolean goOut = false;
		while (!goOut) {
			Armor getArmor = null;
			ArrayList<Armor> shop = new ArrayList<Armor>(
					Arrays.asList(new Armor("ウッドパック"),new Armor("フレイム")));
			System.out.println("**************************");
			System.out.println("へいらっしゃい！\nなにか買うかね？");
			for(int i = 1 ; i <= shop.size(); 1) {
				if(i<10) {
					System.out.print(" ");
				}
				tl.showSlowMessage(i+"："+shop.get(i - 1).name);
			}
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int marSelect = tl.command_input(0, 2);
			if(marSelect == 0) {
				goOut = tl.goOut("アルテマバスター",player);
				break;
			//スイッチおわり
			}
		// ループのおわり
		}
	//メソッドおわり

	}

	//なにかしら（オブジェクト）を買うメソッド
	private void buy(Player player, Object o) throws InterruptedException, IOException {

		boolean hasNomoney = false;

		//なにもない箱を用意する
		Item item = null;
		Armor armor = null;
		Material material = null;

		//オブジェクトをinstanceofで判別し、キャストさせる
		if(o instanceof Item) {
			item = (Item)o;
			if(item.buy > player.money) {
				hasNomoney = true;
			}

		}else if(o instanceof Armor) {
			armor = (Armor)o;
			if(armor.buy > player.money) {
				hasNomoney = true;
			}

		}else if(o instanceof Material) {
			material = (Material)o ;
			if(material.buy > player.money) {
				hasNomoney = true;
			}
		}

		//お金をもっていればインベントリにいれる
		if(!hasNomoney) {
			if(o instanceof Item) {
				player.money -= item.buy;
				player.itemInventory.add(item);
			}else if(o instanceof Armor) {
				player.money -= armor.buy;
				player.armorInventory.add(armor);
			}else if(o instanceof Material) {
				player.money -= material.buy;
				player.materialInventory.add(material);
			}
		}

		//セリフの処理
		if(hasNomoney) {
			tl.showSlowMessage("なんだい、お金をもってないじゃないか。");
		}else {
			tl.showSlowMessage("毎度あり！\nありがとね！");
			tl.showSlowMessage(player.name + "の残金：" + player.money);
		}
		tl.enter_wait();

		//メソッドおわり
	}

	private void haganeTei(Player player) {
		// TODO 自動生成されたメソッド・スタブ


	}

	private void hosinosuna(Player player) {

	}

}
