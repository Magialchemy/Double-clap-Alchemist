package dungeon;

import java.io.IOException;

import object.Armor;
import object.Enemy;
import object.Item;
import object.Material;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.OverProbabilityException;
import system.Tools;

//ダンジョンクラス
public class Dungeon {

	public static final Tools tl = new Tools();

	String[] monsters;

	String dungeonName;

	static int stage = 0;

	// コンストラクタ(入力したダンジョン名とモンスターを出力)
	public Dungeon(String name, String[] inputMonster) {

		this.dungeonName = name;

		this.monsters = new String[inputMonster.length];

		for (int i = 0; i < inputMonster.length; i++) {

			monsters[i] = inputMonster[i];

		}

	}

	// メインメソッド
	public void dungeonMain(Player player, Item init_item) throws InterruptedException, IOException,
			NoMonsterNameException, NoItemNameException, IllegalArgumentException, OverProbabilityException {

		Item item = init_item;

		player.item = item;

		// ステージのイントロ

		Thread.sleep(800);
		tl.showSlowMessage("\n\n\n\n\n");
		System.out.println("**************************");
		System.out.println();
		System.out.println("  ―" + this.dungeonName + "―");
		System.out.println();
		System.out.println("**************************");
		tl.showPlayerInfo(player);

		// ステージ開始

		while (player.isAlive && stage < monsters.length) {
			tl.showSlowMessage("\n\n\n\n\n");
			System.out.println("**************************");
			System.out.println("******* S T A G E " + (stage + 1) + " ******");
			System.out.println("**************************");
			tl.showSlowMessage("\n\n\n\n");

			if (stage < monsters.length - 1) {
				Thread.sleep(800);
				battle(player, item, monsters[stage]);
			} else if (stage == monsters.length - 1) {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(300);
					System.out.print("・");
				}
				tl.showSlowMessage("くる！！");
				Thread.sleep(1000);
				System.out.println("**************************");
				System.out.println("*******   B O S S  *******");
				System.out.println("**************************");
				Thread.sleep(1000);
				battle(player, item, monsters[stage]);
			}
			// 戦闘終了
			if(stage < monsters.length - 1){
				Dungeon.treasure(0.3, player, 0.05, new Armor("ウッドパック"), 0.1, new Material("木の板"), 0.25, new Item("ポーション"),
					0.1, new Enemy("メガスライム"), 0.5, 1000 + new java.util.Random().nextInt(7) * 100);
			}else{
				Dungeon.treasure(1.0, player, 0, null, 0, null, 0.3, new Item("かえんびん"),
						0, null, 0.7, 10000);
			}
			stage++;
			// ループの終わり
		}
		// ステージを戻す
		stage = 0;
		if (player.isAlive) {
			tl.showSlowMessage("\n\n\n\n");
			System.out.println("\n\n**************************");
			System.out.println("******* C L E A R ********");
			System.out.println("**************************\n\n");
			tl.enter_wait();
			tl.showSlowMessage("\n\nふう、つかれた。");
			Thread.sleep(800);
			tl.showSlowMessage(player.name + "はダンジョンをあとにした");

			tl.enter_wait();
		}

		// メソッドのおわり
	}

	// 戦闘自体のメソッド
	public static void battle(Player player, Item item, String name) throws IOException, NumberFormatException,
			InterruptedException, NoMonsterNameException, NoItemNameException {
		Enemy enemy = new Enemy(name);
		System.out.println("\n" + enemy.toString());
		System.out.println();
		while (player.isAlive && enemy.isAlive) {
			command(player, enemy, item);

			enemy_turn(enemy);

			attack_judging(player, enemy);
		}
		result(player, enemy);

		// メソッドの終わり
	}

	// 自分のコマンドのメソッド
	public static void command(Player player, Enemy enemy, Item item)
			throws NumberFormatException, IOException, InterruptedException, NoItemNameException {

		Thread.sleep(1000);
		System.out.println("\r**************************");
		System.out.println(player.name + "はどうする？");
		tl.showSlowMessage("1:アタック");
		tl.showSlowMessage("2:ガード");
		tl.showSlowMessage("3:チャージ");
		if (!(player.item == null)) {
			tl.showSlowMessage("4:" + item.name);
		}
		System.out.println("**************************");
		System.out.println("【数字を入力してください】");
		int command;
		if (player.item == null) {
			command = tl.command_input(1, 3);
		} else {
			command = tl.command_input(1, 4);
		}
		System.out.println();
		switch (command) {

		case 1:// 攻撃する
			player.attack();
			break;

		case 2:// 防御する
			player.guard();
			break;

		case 3:// ためる
			player.charge();
			break;

		case 4:// アイテム
			item.useItem(player, enemy, item);
			player.item = null;
			break;
		}

		// メソッドのおわり
	}

	// 敵の攻撃のメソッド
	public static void enemy_turn(Enemy enemy) throws InterruptedException {
		int command = new java.util.Random().nextInt(3) + 1;
		System.out.println();
		switch (command) {

		case 1:// 攻撃する
			enemy.attack();
			break;

		case 2:// 防御する
			enemy.guard();
			break;

		case 3:// ためる
			enemy.charge();
			break;
		}

		// メソッドのおわり
	}

	// 攻撃判定メソッド
	public static void attack_judging(Player player, Enemy enemy)

	throws InterruptedException {
		int actual_damage = 0;
		Thread.sleep(1500);
		System.out.println();
		// 状態異常の判定
		// 必ず解除すること

		if (enemy.isStanned) {

			tl.showSlowMessage(enemy.name + "は怯んでいる");
			enemy.isStanned =false;//解除する
		} else

		// 攻撃の判定
			if (enemy.isAttacking && player.isCharging) {
			// ●プレイヤーがダメージを受ける
			actual_damage = enemy.power + (enemy.chargecounter * 5) - player.defence;
			// 敵のチャージぶんをリセット
			enemy.chargecounter = 0;
			// ダメージが負なら0に直す
			if (actual_damage < 0) {
				actual_damage = 0;
			}
			tl.showSlowMessage(player.name + "は攻撃を受けた！");
			Thread.sleep(800);
			tl.showSlowMessage(player.name + "に" + actual_damage + "のダメージ！");
			player.hp -= actual_damage;

		} else if (player.isAttacking && enemy.isCharging) {
			// ○敵がダメージを受ける
			actual_damage = player.power + (player.chargecounter * player.charge_pow) - enemy.defence;
			// 自分のチャージぶんをリセット
			player.chargecounter = 0;
			// ダメージが負なら0に直す
			if (actual_damage < 0) {
				actual_damage = 0;
			}
			tl.showSlowMessage(enemy.name + "に攻撃がはいった！");
			Thread.sleep(800);
			tl.showSlowMessage(enemy.name + "に" + actual_damage + "のダメージ！");
			enemy.hp -= actual_damage;

		} else if (player.isAttacking && enemy.isGuarding) {
			// ▲自分の攻撃がガードされる
			actual_damage = player.power + (player.chargecounter * player.charge_pow) - enemy.defence * 2;
			// 自分のチャージぶんをリセット
			player.chargecounter = 0;
			// ダメージが負なら0に直す
			if (actual_damage < 0) {
				actual_damage = 0;
			}
			tl.showSlowMessage(player.name + "の攻撃は防がれた");
			Thread.sleep(800);
			tl.showSlowMessage(enemy.name + "に" + actual_damage + "のダメージ！");
			enemy.hp -= actual_damage;

		} else if (player.isGuarding && enemy.isAttacking) {

			// △相手の攻撃をガードした！
			actual_damage = enemy.power + (enemy.chargecounter * enemy.charge_pow) - player.defence * 2;
			// 敵のチャージぶんをリセット
			enemy.chargecounter = 0;
			// ダメージが負なら0に直す
			if (actual_damage < 0) {
				actual_damage = 0;
			}
			tl.showSlowMessage(enemy.name + "の攻撃を防いだ！");
			Thread.sleep(800);
			tl.showSlowMessage(player.name + "に" + actual_damage + "のダメージ！");
			player.hp -= actual_damage;

		} else if (player.isAttacking && player.isAttacking) {

			if (player.chargecounter < enemy.chargecounter) {
				// 攻撃をはじかれた
				actual_damage = enemy.power + (enemy.chargecounter * enemy.charge_pow) - player.defence;
				// ダメージが負なら0に直す
				if (actual_damage < 0) {
					actual_damage = 0;
				}
				tl.showSlowMessage("攻撃がはじかれた！！");
				Thread.sleep(800);
				tl.showSlowMessage(player.name + "に" + actual_damage + "のダメージ！");
				player.hp -= actual_damage;

			} else if (player.chargecounter > enemy.chargecounter) {
				// 攻撃が入った！
				actual_damage = player.power + (player.chargecounter * player.charge_pow) - enemy.defence;
				// ダメージが負なら0に直す
				if (actual_damage < 0) {
					actual_damage = 0;
				}
				tl.showSlowMessage(enemy.name + "に攻撃がはいった！");
				Thread.sleep(800);
				tl.showSlowMessage(enemy.name + "に" + actual_damage + "のダメージ！");
				enemy.hp -= actual_damage;

			} else {
				// ・・・なにも起こらない
				tl.showSlowMessage("お互いの攻撃が相殺された！！");
				for (int i = 0; i < 3; i++) {
					System.out.print("・");
					Thread.sleep(300);
				}
				tl.showSlowMessage("緊張した場が流れている");

			}
			// それぞれのチャージカウンタをリセット
			player.chargecounter = 0;
			enemy.chargecounter = 0;

		} else {
			// ・・・なにもおこらない
			for (int i = 0; i < 3; i++) {
				System.out.print("・");
				Thread.sleep(300);
			}
			tl.showSlowMessage("緊張した場が流れている");
		}
		// hpが負になっていたら0にする
		if (player.hp < 0) {
			player.hp = 0;
		}
		if (enemy.hp < 0) {
			enemy.hp = 0;
		}

		System.out.println();
		Thread.sleep(800);
		System.out.println(player.name);
		System.out.println("HP：" + player.hp + "/" + player.maxhp);
		// MPの描画
		System.out.print("MP：");
		for (int i = 0; i < player.chargecounter; i++) {
			System.out.print("■");
		}
		System.out.println();
		System.out.println(enemy.name);
		System.out.println("HP：" + enemy.hp + "/" + enemy.maxhp);
		// MPは描画
		System.out.print("MP：");
		for (int i = 0; i < enemy.chargecounter; i++) {
			System.out.print("■");
		}
		System.out.println("\n");
		// 死んでいるかどうかの判定
		if (player.hp == 0) {
			player.isAlive = false;
		} else if (enemy.hp == 0) {
			enemy.isAlive = false;
		}
		Thread.sleep(800);

		// メソッドのおわり
	}

	// 戦闘結果メソッド
	public static void result(Player player, Enemy enemy) throws InterruptedException, IOException {
		Thread.sleep(1000);

		if (player.isAlive) {

			tl.showSlowMessage(enemy.name + "を倒した！！");
			tl.showSlowMessage(enemy.getEXP + "の経験値を手に入れた！");
			player.exp += enemy.getEXP;

			if(player.exp >= player.neededEXP){
				player.levelUp();
			}
			tl.showSlowMessage(player.name + "の経験値：" + player.exp + "/" + player.neededEXP);


			System.out.println();
			tl.enter_wait();
			System.out.println();

		} else if (enemy.isAlive) {

			tl.showSlowMessage(player.name + "は倒れてしまった・・・");

			Thread.sleep(1000);
			System.out.println("\n\n**************************");
			System.out.println("*****G A M E O V E R******");
			System.out.println("**************************\n\n");
		}

		// メソッドのおわり
	}

	// おたからメソッド
	// 確率がさき、ものはあと
	public static void treasure(double findProb, Player player// どのくらいで【プレイヤー】がみつけ、
	, double isArmor, Armor armor// どのくらいで【武器】がみつかり、
	, double isMaterial, Material material// どのくらいで【素材】が見つかり、
	, double isItem, Item item// どのくらいで【アイテム】が見つかり、
	, double isEnemy, Enemy enemy// どのくらいで【敵】が入っていて、
	, double isMoney, int money)// どのくらいで【お金】が入っているか
			throws OverProbabilityException, IllegalArgumentException, InterruptedException, IOException,
			NoMonsterNameException, NoItemNameException {

		double probSum = isArmor + isMaterial + isItem + isMoney + isEnemy;

		// それぞれの確率は0以上1以下であること
		if (findProb < 0 || isArmor < 0 || isEnemy < 0 || isMaterial < 0 || isItem < 0 || isMoney < 0 || findProb > 1
				|| isArmor < 0 || isEnemy > 1 || isMaterial > 1 || isItem > 1 || isMoney > 1) {
			throw new IllegalArgumentException("【！】確率の値に異常があります");
		}

		// 確率の合計は必ず1になっていること
		if (!(probSum == 1)) {
			throw new OverProbabilityException("【！】合計確率100%をが超えています");
		}

		// 見つかるかどうか
		double findIndex = Math.random();
		if (findIndex < findProb) {

			// 見つかった上で処理

			tl.showSlowMessage("宝箱をみつけた");

			double treasureIndex = Math.random();

			// お金を見つける
			if (treasureIndex < isMoney) {
				tl.showSlowMessage(player.name + "は" + money + "イェンを手に入れた！");
				player.money += money;
				// 素材を見つける
			} else if (treasureIndex < isMoney + isMaterial) {
				tl.showSlowMessage(player.name + "は" + material.name + "を手に入れた！");
				player.materialInventory.add(material);
			} else if (treasureIndex < isMoney + isMaterial + isItem) {
				tl.showSlowMessage(player.name + "は" + item.name + "を手に入れた！");
				player.itemInventory.add(item);
			} else if (treasureIndex < isMoney + isMaterial + isItem + isArmor) {
				tl.showSlowMessage(player.name + "は" + armor.name + "を手に入れた！");
				player.armorInventory.add(armor);
			} else {
				tl.showSlowMessage("しまった！箱の中身はモンスターだ！");
				battle(player, player.item, enemy.name);
			}

			// findIndexのおわり
		}

		// メソッドのおわり
	}

	// クラスのおわり
}
