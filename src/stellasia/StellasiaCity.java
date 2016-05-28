package stellasia;

import java.io.IOException;

import dungeon.Dungeon;
import dungeon.DungeonGate;
import laboratory.Laboratory;
import object.Enemy;
import object.Item;
import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.OverProbabilityException;
import system.Tools;

public final class StellasiaCity {

	public static boolean forthefirstTime;

	public static final Tools tl = new Tools();

	public static final Player player = Introduction.player;

	public static Laboratory lab = new Laboratory();// ３：研究所

	public static CityHall cityhall = new CityHall();// １：市役所

	public static Market market = new Market();// ２：市場

	public static DungeonGate gate = new DungeonGate();// ０：ダンジョンへの門

	public static Bar bar = new Bar();// ４：酒場

	// メインメソッド・行ったかどうかで変わる
	public static void main() throws InterruptedException, IOException,
			NoMonsterNameException, NoItemNameException,
			IllegalArgumentException, OverProbabilityException {

		tl.showSlowMessage("ここは星の都ステラシア");
		Thread.sleep(500);
		tl.showSlowMessage("\n多くの冒険者が夢を追いかける町である");
		tl.enter_wait();

		if (forthefirstTime) {
			tutorialCity(player);
		} else {
			wheretogo(player);
		}

	}

	// チュートリアルメソッド
	public static void tutorialCity(Player player) throws InterruptedException,
			IOException, NoMonsterNameException, NoItemNameException,
			IllegalArgumentException, OverProbabilityException {

		// 筋肉バキバキ市長登場
		tl.showSlowMessage("・・・そこのお方、まちなされ！");
		System.out.println();
		Thread.sleep(800);
		tl.showSlowMessage(player.name + "は後ろから呼ばれた");
		tl.showSlowMessage("長身の筋肉質な老人だ");
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("・");
			Thread.sleep(500);
		}
		tl.showSlowMessage("すこしむさくるしい");
		tl.enter_wait();

		// もろオーキドである
		tl.showSlowMessage("ワタシはここの市長をしている\"ソル\"という");
		tl.showSlowMessage("ダンジョンにはキケンがいっぱいじゃ！");
		tl.enter_wait();
		tl.showSlowMessage("うおっほん！");
		Thread.sleep(800);
		tl.showSlowMessage("そこで新参のおぬしにこの武器を授けよう！");
		System.out.println();

		// オッケー押すまで無限ループ
		// うぜえ・・・この市長・・・
		int sol_loop = 2;
		while (sol_loop == 2) {
			System.out.println("**************************");
			System.out.println("・・・どうする？");
			System.out.println("1：ほしいです！おねがいします！");
			System.out.println("2：いや・・・いいです・・・");
			System.out.println("**************************");

			System.out.println("▽【数字を入力してください】");
			sol_loop = tl.command_input(1, 2);
			System.out.println();
			if (sol_loop == 2) {
				tl.showSlowMessage("まあまあ、そういわずにわたしにまかせなさい！");
				System.out.println();
			}
		}
		// なんか無理やり案内させられるんだけど
		tl.showSlowMessage("よかろう！\n君ならそういってくれると思っていたぞ！");
		Thread.sleep(800);

		tl.showSlowMessage("まずおぬしに武器を渡す\n");
		Thread.sleep(800);
		tl.showSlowMessage(player.name + "はグローブのようなものを受け取った");
		tl.enter_wait();
		tl.showSlowMessage("これが錬金術士のグローブだ");

		tl.showSlowMessage("\n手を叩き、印をむすぶことで" + "\n魔力の弾をため、発射することができるのだ");

		Thread.sleep(800);
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("・");
			Thread.sleep(500);
		}
		tl.showSlowMessage(player.name + "はぽかんとしている");
		tl.enter_wait();
		tl.showSlowMessage("・・・きみ、戦闘ははじめてかね？");
		System.out.println("**************************");
		System.out.println("1：はじめてです");
		System.out.println("2：実は経験があります");
		System.out.println("**************************");

		System.out.println("▽【数字を入力してください】");
		int youarefirst = tl.command_input(1, 2);
		System.out.println();

		// 初めてならばチュートリアル
		if (youarefirst == 1) {
			tl.showSlowMessage("そうかそうか！");
			tl.showSlowMessage("わたしのペットで教えてしんぜよう！\n\n");
			Thread.sleep(800);
			tl.showSlowMessage("スラ吉！いきなさい！！");
			tutorialBattle(player);

			// そうでないならとばす
		} else {
			tl.showSlowMessage("なんと！それは失礼した！");
			tl.showSlowMessage("ふむ・・・きみなら問題ないな！");
			tl.enter_wait();

		}
		tl.showSlowMessage("センベツとしてこの宝箱をあげよう");

		Dungeon.treasure(1.0, player, 0, null, 0, null, 0, null, 0, null, 1.0,
				10000);

		tl.showSlowMessage("そしてポーションとかえんびんを5個ずつサービスだ！\n\nがんばれよ！！");

		for (int i = 0; i < 5; i++) {

			player.itemInventory.add(new Item("ポーション"));

		}
		for (int i = 0; i < 5; i++) {

			player.itemInventory.add(new Item("かえんびん"));

		}
		tl.enter_wait();
		tl.showSlowMessage("わたしは市役所にいる！\n困ったことがあればいつでもききにくるといい！\n\nはっはっはっはっは・・・");

		Thread.sleep(800);
		tl.showSlowMessage("・・・・ソル市長は去っていった・・・");
		// 次からチュートリアルなし
		forthefirstTime = false;

		wheretogo(player);
		// メソッドの終わり
	}

	// 行き先のメソッド
	public static void wheretogo(Player player) throws InterruptedException,
			IOException, NoMonsterNameException, NoItemNameException,
			IllegalArgumentException, OverProbabilityException {

		boolean goOut = false;
		tl.showPlayerInfo(player);
		while (!goOut) {
			System.out.println("**************************");
			System.out.println("    どこへ行こうか？");
			System.out.println("1：天空の塔行き城門(ダンジョンに挑戦)");
			System.out.println("2：ステラシア市役所(ソル市長に話を聞く)");
			System.out.println("3：ステラ市場(アイテムや素材を買えます)");
			System.out.println("4：" + player.name + "の研究所(武器のパーツやアイテムを作れます)");
			System.out.println("5：星の酒場(他の冒険者に話を聞く)");
			System.out.println("6：自分の状態をみる");
			System.out.println("0：ステラシアから出る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int command = tl.command_input(0, 6);
			switch (command) {
			case 1:
				gate.goThere(player);
				break;
			case 2:
				cityhall.goThere(player);
				break;
			case 3:
				market.goThere(player);
				break;
			// 研究所に行く
			case 4:
				lab.goThere(player);
				break;
			// 酒場へいく
			case 5:
				bar.goThere(player);
				break;
			case 6:
				// 情報のコマンド
				showInfos(player);
				break;
			case 0:
				goOut = tl.goOut("ステラシア", player);
				break;
			}
			// メソッドの終わり
		}
	}

	// チュートリアルのメソッド
	public static void tutorialBattle(Player player) throws IOException,
			InterruptedException, NoItemNameException, NoMonsterNameException,
			IllegalArgumentException, OverProbabilityException {

		Enemy slime = new Enemy("スライム");
		System.out.println(slime.toString());
		Thread.sleep(800);
		tl.showSlowMessage("\nまずおぬしのステータスを確認しよう\n\n" + player.name + "は確認した");
		tl.showPlayerInfo(player);

		tl.showSlowMessage("HPがなくなれば負けだ、ダンジョンの外まで追い出される");
		tl.enter_wait();
		tl.showSlowMessage("\nコマンドの説明をしよう\n\nアタックは相手への攻撃だ\n"
				+ "ガードは防御を固めて自分の防御力を2倍にする\nチャージは溜めたぶんだけ攻撃力を上げるのだ");
		Thread.sleep(800);
		tl.showSlowMessage("さあ、えらんでみなさい");
		Dungeon.command(player, slime, player.item);
		Thread.sleep(800);
		tl.showSlowMessage("ここでモンスターも同時に攻撃しにかかる");
		Thread.sleep(800);
		tl.showSlowMessage("\n同時に攻撃するとき溜めた魔力が大きければ\n攻撃をはじくことができる！");
		Dungeon.enemy_turn(slime);

		Dungeon.attack_judging(player, slime);

		Thread.sleep(800);
		tl.showSlowMessage("\nふむ、ここまでだ。\nあとは自由に戦ってみなさい。");

		while (player.isAlive && slime.isAlive) {

			Dungeon.command(player, slime, player.item);

			Dungeon.enemy_turn(slime);

			Dungeon.attack_judging(player, slime);
		}
		Thread.sleep(800);
		tl.showSlowMessage("む！勝負はやめじゃ！\n\nあとは結果が表示させられる");

		Dungeon.result(player, slime);

		if (!player.isAlive) {

			tl.showSlowMessage("だいじょうぶか？\n今回は回復してやろう・・・\n");
			player.hp = player.maxhp;
			tl.showSlowMessage("今後はこのようなことがないように気をつけるのだ");
		} else {
			tl.showSlowMessage("おぬしなら大丈夫だな、\n\nよくやったスラ吉！");
		}
		tl.enter_wait();

	}

	//情報表示のメソッド
	public static void showInfos(Player player) throws InterruptedException, IOException {

		boolean enough = false;
		while (!enough) {
			System.out.println("**************************");
			System.out.println("なにの情報をみますか？");
			System.out.println("1：つよさ");
			System.out.println("2：そうび");
			System.out.println("3：アイテム");
			System.out.println("4：マテリアル");
			System.out.println("5：パーツいちらん");
			System.out.println("0：やめる");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");
			int info = tl.command_input(0, 5);
			switch (info) {
			case 1:
				tl.showPlayerInfo(player);
				break;
			case 2:
				tl.showNowArmor(player);
				break;
			case 3:
				tl.showItemInventory(player);
				break;
			case 4:
				tl.showMaterialInventory(player);
				break;
			case 5:
				tl.showArmorInventory(player);
				break;
			case 0:
				System.out.println("**************************");
				System.out.println("街へもどりますか？");
				tl.showSlowMessage("1：はい");
				tl.showSlowMessage("2：いいえ");
				System.out.println("**************************");
				System.out.println("▽【数字を入力してください】");

				// 街からでる
				int end_command = tl.command_input(1, 2);
				if (end_command == 1) {
					enough = true;
				} else {

				}
				break;
			}
		}
	}
}
