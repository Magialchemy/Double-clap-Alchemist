package dungeon;

import java.io.IOException;

import object.BuildingSpace;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.OverProbabilityException;

public class DungeonGate extends BuildingSpace {

	public void goThere(Player player) throws InterruptedException,
			IOException, NoMonsterNameException, NoItemNameException,
			IllegalArgumentException, OverProbabilityException {

		tl.showSlowMessage("てくてく・・・・\n\n\n\n城門についた");
		tl.showSlowMessage("多くの冒険者が見える");

		boolean goOut = false;
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("どこへ行こうか？\n");
			tl.showSlowMessage("1：はじめの洞窟");
			tl.showSlowMessage("2：ボルカノ噴火口");
			tl.showSlowMessage("3：リキッド海岸");
			tl.showSlowMessage("4：ロッキン遺跡");
			tl.showSlowMessage("5：ワール高原");
			tl.showSlowMessage("0：やっぱり帰る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int dungeonSelect = tl.command_input(1, 3);

			Thread.sleep(800);
			tl.showItemInventory(player);
			tl.showSlowMessage("何をもっていきますか？\n(0でなにももっていかない)");
			System.out.println("▽【数字を入力してください】");

			int takingItem = tl.command_input(0, player.itemInventory.size());
			if (takingItem == 0) {

			} else {
				player.item = player.itemInventory.get(takingItem - 1);
				tl.showSlowMessage(player.name + "は" + player.item.name + "をもっていった");
			}

			switch (dungeonSelect) {

			// はじめの洞窟
			case 1:
				String[] planeMonster = { "スライム", "スライム", "ポイズンマッシュ", "メガスライム" };
				Dungeon firstPlane = new Dungeon("はじめの洞窟", planeMonster);
				firstPlane.dungeonMain(player, player.item);
				goOut = true;
				break;

			// ボルカノ噴火口
			case 2:
				String[] volcanoMonster = { "フレイムバット", "ミニリザード", "フレイムバット",
						"バーニングゴーレム", "リザードマン" };
				Dungeon volcanoCrater = new Dungeon("ボルカノ噴火口", volcanoMonster);
				volcanoCrater.dungeonMain(player, player.item);
				goOut = true;
				break;

			// リキッド海岸
			case 3:
				String[] coastMonster = { "メガスライム", "ゴーレム", "ダークマッシュ", "ゴーレム",
						"ドラグーン" };
				Dungeon liquidCoast = new Dungeon("リキッド海岸", coastMonster);
				liquidCoast.dungeonMain(player, player.item);
				goOut = true;
				break;

			// ボルカノ噴火口
			case 4:
				String[] ruinsMonster = { "フレイムバット", "ミニリザード", "フレイムバット",
						"バーニングゴーレム", "リザードマン" };
				Dungeon rockenRuins = new Dungeon("ロッキン遺跡", ruinsMonster);
				rockenRuins.dungeonMain(player, player.item);
				goOut = true;
				break;

			// リキッド海岸
			case 5:
				String[] hilandMonster = { "メガスライム", "ゴーレム", "ダークマッシュ", "ゴーレム",
						"ドラグーン" };
				Dungeon wirlHiland = new Dungeon("ワール高原", hilandMonster);
				wirlHiland.dungeonMain(player, player.item);
				goOut = true;
				break;

			case 0:
				System.out.println("**************************");
				System.out.println("街へもどりますか？");
				tl.showSlowMessage("1：はい");
				tl.showSlowMessage("2：いいえ");
				System.out.println("**************************");
				System.out.println("▽【数字を入力してください】");

				// コマンド選択
				int outSelect = tl.command_input(1, 2);

				Thread.sleep(800);
				if (outSelect == 1) {
					goOut = true;
					tl.showSlowMessage(player.name
							+ "は城門をあとにした\nてくてく・・・・\n\n\n\n");
				} else {
					continue;
				}
				break;
				//スイッチおわり
			}
			// ループのおわり
		}

		// メソッドのおわり
	}

	// クラスのおわり
}
