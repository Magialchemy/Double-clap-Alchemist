package laboratory;

import java.io.IOException;
import java.util.ArrayList;

import object.Armor;
import object.Player;
import system.Tools;

public class MakeArms {

	public static Tools tl  = new Tools();

	public static ArrayList<Armor> makable = new ArrayList<Armor>();

	public static ArrayList<Armor> make = new ArrayList<Armor>();

	public void startMaking(Player player) throws InterruptedException, IOException{

		makableItem(player,make,makable);

		boolean makeEND = false;
		while (!makeEND) {
			System.out.println("**************************");
			System.out.println("なにをつくる？");
			for (int i = 1; i < make.size(); i++) {
				if (i < 10) {
					System.out.print(" ");
				}
				System.out.println(i+ "："
						+ make.get(i-1).name);
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

	private void makableItem(Player player, ArrayList<Armor> make, ArrayList<Armor> makable) {

		int counter = 0;

		for (int i = 0; i < makable.size(); i++) {
			for (int j = 0; j < player.materialInventory.size(); j++) {

				if (makable.get(i).recipe.contains(player.materialInventory.get(j))) {

					counter++;

				}

			}
			if(counter == makable.get(i).recipe.size()) {
				make.add(makable.get(i));
			}
		}
	}

	private void make(Player player) {
		player



	}

}