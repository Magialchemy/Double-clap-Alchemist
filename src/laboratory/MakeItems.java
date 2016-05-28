package laboratory;

import java.io.IOException;
import java.util.ArrayList;

import object.Item;
import object.Player;
import system.Tools;

public class MakeItems {
	public static Tools tl  = new Tools();

	public static ArrayList<Item> makable = new ArrayList<Item>();

	public void startMaking(Player player)throws InterruptedException, IOException{

		boolean makeEND = false;
		while (!makeEND) {
			System.out.println("**************************");
			System.out.println("なにをつくる？");
			for (int i = 1; i < makable.size(); i++) {
				if (i < 10) {
					System.out.print(" ");
				}
				System.out.println(i+ "："
						+ makable.get(i-1).name);
				// ループおわり
			}
			tl.showSlowMessage("0：ここから立ち去る");
			System.out.println("**************************");
			System.out.println("▽【数字を入力してください】");

			// コマンド選択
			int labSelect = tl.command_input(0,makable.size() );
			if(labSelect >0){
				make(player);

			}else{

				System.out.println("**************************");
				System.out.println("錬成をやめますか？");
				tl.showSlowMessage("1：やめる");
				tl.showSlowMessage("2：やめない");
				System.out.println("**************************");
				System.out.println("▽【数字を入力してください】");

				// コマンド選択
				int outSelect = tl.command_input(1, 2);

				Thread.sleep(800);
				if (outSelect == 1) {
					makeEND = true;
				} else {
					continue;
				}
				break;
			}
			// ループのおわり
		}
	}

	private void make(Player player) {
		// TODO 自動生成されたメソッド・スタブ

	}

}