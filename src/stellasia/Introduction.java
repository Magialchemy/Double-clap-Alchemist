package stellasia;

import java.io.IOException;

import object.Player;
import system.NoItemNameException;
import system.NoMonsterNameException;
import system.OverProbabilityException;
import system.TemporaryGameEndFlagException;
import system.Tools;

public class Introduction {

	public static Tools tl = new Tools();

	public static Player player;

	static boolean skip = false;

	public static void main(String[] args) {

		// オープニングから
		try {
			System.out.println("**************************");
			System.out.println("1：オープニングから");
			System.out.println("2：とばして街にはいる");
			System.out.println("**************************");
			System.out.println("(2を選ぶことを推奨します)");

			System.out.println("▽【数字を入力してください】");
			int skip_command = tl.command_input(1, 2);

			// スキップさせる
			if (skip_command == 2) {

				skip = true;

			}

			if (!skip) {
				tl.showSlowMessage("\n\n\n\n\n\n");
				tl.showSlowMessage("――それははるか昔のこと");
				tl.showSlowMessage("神々は\"天界の塔\"に");
				tl.showSlowMessage("英知と財宝を託したと言われている――");

				System.out.println("\n(三角が出ているときはEnterを押してください)");
				tl.enter_wait();

				tl.showSlowMessage("いまは大迷宮\"天界の塔\"に向かって");
				tl.showSlowMessage("多くの冒険者が挑んでいった");
				tl.showSlowMessage("\n\"大冒険者時代\"であった");
				tl.enter_wait();

				System.out.println();
				tl.showSlowMessage("そんな中一人の冒険者が立ち上がろうとしていた");
			}
			// ここまでスキップ

			Thread.sleep(800);
			System.out.println();
			System.out.println("▽【名前を入力してください】");
			// ここで冒険者を生成する
			String name = tl.name_input();
			player = new Player(name);

			// さらにスキップ
			if (!skip) {
				System.out.println();
				tl.showSlowMessage("そう・・・その名は・・・");
				tl.showSlowMessage("・・・" + player.name + "！");
				Thread.sleep(800);
				tl.showSlowMessage("\nいま、冒険者" + player.name + "の新たな冒険が始まる！");

				Thread.sleep(1000);
				tl.showSlowMessage("\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("**************************");
				System.out.println("**************************");
				System.out.println("**************************");
				System.out.println();
				System.out.println("  DOUBLE CLAP ALCHEMIST");
				System.out.println("   ―双拍の錬金術師―");
				System.out.println();
				System.out.println("**************************");
				System.out.println("**************************");
				System.out.println("**************************");
				tl.showSlowMessage("\n\n");

				System.out.println("    PLESS ENTER BUTTON\n");

				tl.enter_wait();
				// ステラシアへ向かわせてみる
				tl.showSlowMessage("\n\n\n\n\n\n\n・・・さて。");
				tl.showSlowMessage(player.name + "が調べたところによると"
						+ "\n天界の塔は星の都\"ステラシア\"の近くにあるらしい");
				Thread.sleep(800);
				System.out.println();
				tl.showSlowMessage("早速" + player.name + "はステラシアに向かうことにした");
				tl.enter_wait();

				StellasiaCity.forthefirstTime = true;
				StellasiaCity.main();

			} else {
				// そうでなければ体験版ダンジョン

				tl.showSlowMessage("それではステラシアにむかいます");
				System.out.println("\n(三角が出ているときはEnterを押してください)");
				tl.enter_wait();

				System.out.println();
				StellasiaCity.forthefirstTime = false;
				StellasiaCity.main();// 限定名で呼んでいくスタイル

			}

		} catch (InterruptedException ire) {
			ire.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (NoMonsterNameException nmne) {
			nmne.printStackTrace();
		} catch (NoItemNameException nine) {
			nine.printStackTrace();
		} catch (TemporaryGameEndFlagException tgefe) {
			System.out.println("【◎】ここまでOKです、おつかれさまでした");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (OverProbabilityException e) {
			e.printStackTrace();
		} finally {
			System.out.println("\nゲーム終了");
		}

		// メインメソッドのおわり
	}

}
