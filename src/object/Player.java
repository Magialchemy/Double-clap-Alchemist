package object;

import java.util.ArrayList;

import system.Tools;


public class Player extends Character{


	//エフェクトツール
	public static Tools tl = new Tools();

	public static char attackElement = 'N';

	//おかね

	public int money = 0;

	//経験値
	public int exp;

	public int neededEXP;

	//アイテム系統の管理
	//player has a Item の関係
	public Item item;

	public ArrayList<Item> itemInventory = new ArrayList<Item>();

	//素材一覧在庫
	public ArrayList<Material> materialInventory = new ArrayList<Material>();


	//装備に関するデータ

	public Armor armor;

	public ArrayList<Armor> armorInventory = new ArrayList<Armor>();

	//能力値の上昇について
	public int level;

	public Player(String str){
		exp = 0 ;
		neededEXP = 10;
		level = 1;
		name = str;
		maxhp = 50;
		hp = maxhp;
		power = 7;
		defence = 6;
		element = 'N';//ノーマル
		charge_pow = 5;
		//コンストラクタの終わり
	}

	//レベルアップメソッド
	public void levelUp() throws InterruptedException{
		this.level++;
		this.exp -= this.neededEXP;
		int upHP  = new java.util.Random().nextInt(6) + 5;
		int upPOW = new java.util.Random().nextInt(5) + 1;
		int upDEF = new java.util.Random().nextInt(5) + 1;
		int upCHG = new java.util.Random().nextInt(2) + 1;
		int upEXP = new java.util.Random().nextInt(10) + 10;

		Thread.sleep(800);
		System.out.println();
		tl.showSlowMessage(this.name + "はレベルアップしてレベル"+this.level+"になった！");
		Thread.sleep(500);
		System.out.println();
		this.maxhp += upHP;
		System.out.println("HPが"+ upHP + "あがって" + this.maxhp + "になった！");
		this.hp = this.maxhp;
		Thread.sleep(500);
		this.power += upPOW;
		System.out.println("攻撃力が"+ upPOW + "あがって" + this.power + "になった！");
		Thread.sleep(500);
		this.defence += upDEF;
		System.out.println("防御力が"+ upDEF + "あがって" + this.defence + "になった！");
		Thread.sleep(500);
		this.charge_pow += upCHG;
		System.out.println("チャージ力が"+ upCHG + "あがって" + this.charge_pow + "になった！");
		Thread.sleep(500);
		neededEXP += upEXP;
		Thread.sleep(500);
		System.out.println();

		//レベル
	}
	//アイテム使用メソッドは
	//アイテムクラスにて一括管理しています
}
