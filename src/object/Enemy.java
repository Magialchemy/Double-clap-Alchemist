package object;

import system.NoMonsterNameException;
import system.Tools;

public class Enemy extends Character {

	public static Tools tl = new Tools();

	public int getEXP;

	public int getMoney;
	// 状態異常
	public boolean isStanned = false;// 気絶しているか

	public Enemy(String str)throws NoMonsterNameException {

		this.name = str;

		switch (str) {

		case "スライム":
			this.getEXP = 5 + new java.util.Random().nextInt(3);
			this.getMoney = (new java.util.Random().nextInt(3) + 2 )* 10;
			this.maxhp = 9 + new java.util.Random().nextInt(10);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(8) + 8;
			this.defence = new java.util.Random().nextInt(3);
			this.charge_pow = 3;
			this.element = 'W';// ウォーター属性
			break;

		case "メガスライム":
			this.getEXP = 7 + new java.util.Random().nextInt(8);
			this.getMoney = (new java.util.Random().nextInt(2) + 8 )* 10;
			this.maxhp = 20 + new java.util.Random().nextInt(15);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(8) + 8;
			this.defence = new java.util.Random().nextInt(9) + 7;
			this.charge_pow = 7;
			this.element = 'W';// ウォーター属性
			break;

		case "ポイズンマッシュ":
			this.getEXP = 8 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(3) + 12 )* 10;
			this.maxhp = 13 + new java.util.Random().nextInt(14);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(4) + 7;
			this.defence = new java.util.Random().nextInt(7) + 2;
			this.charge_pow = 4;
			this.element = 'L';// リーフ属性
			break;

		case "ダークマッシュ":
			this.getEXP = 11 + new java.util.Random().nextInt(10);
			this.getMoney = (new java.util.Random().nextInt(3) + 18 )* 10;
			this.maxhp = 30 + new java.util.Random().nextInt(14);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(4) + 7;
			this.defence = new java.util.Random().nextInt(7) + 2;
			this.charge_pow = 4;
			this.element = 'L';// リーフ属性
			break;

		case "キラーバット":
			this.getEXP = 6 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(3) + 14 )* 10;
			this.maxhp = 17 + new java.util.Random().nextInt(10);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(4) + 5;
			this.defence = new java.util.Random().nextInt(6);
			this.charge_pow = 10;
			this.element = 'N';// ノーマル属性
			break;

		case "フレイムバット":
			this.getEXP = 10 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(3) + 20 )* 10;
			this.maxhp = 17 + new java.util.Random().nextInt(10);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(4) + 5;
			this.defence = new java.util.Random().nextInt(6);
			this.charge_pow = 10;
			this.element = 'F';// ファイア属性
			break;

		case "ゴーレム":
			this.getEXP = 10 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(3) + 11 )* 10;
			this.maxhp = 20 + new java.util.Random().nextInt(15);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(8) + 7;
			this.defence = new java.util.Random().nextInt(6) + 3;
			this.charge_pow = 5;
			this.element = 'R';// ロック属性
			break;

		case "バーニングゴーレム":
			this.getEXP = 17 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(3) + 21 )* 10;
			this.hp = 30 + new java.util.Random().nextInt(30);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(8) + 7;
			this.defence = new java.util.Random().nextInt(6) + 3;
			this.charge_pow = 5;
			this.element = 'F';// フレイム属性
			break;

		case "ミニリザード":
			this.getEXP = 9 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(30) + 6 )* 10;
			this.maxhp = 20 + new java.util.Random().nextInt(20);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(6) + 5;
			this.defence = new java.util.Random().nextInt(4);
			this.charge_pow = 7;
			this.element = 'N';// ノーマル属性
			break;

		case "リザードマン":
			this.getEXP = 19 + new java.util.Random().nextInt(9);
			this.getMoney = (new java.util.Random().nextInt(20) + 18 )* 10;
			this.maxhp = 50 + new java.util.Random().nextInt(20);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(6) + 5;
			this.defence = new java.util.Random().nextInt(4) + 2;
			this.charge_pow = 7;
			this.element = 'F';// フレイム属性
			break;

		case "ドラグーン":
			this.getEXP = 50 + new java.util.Random().nextInt(20);
			this.getMoney = (new java.util.Random().nextInt(3) + 20 )* 100;
			this.maxhp = 100 + new java.util.Random().nextInt(100);
			this.hp = this.maxhp;
			this.power = new java.util.Random().nextInt(8) + 10;
			this.defence = new java.util.Random().nextInt(10) + 4;
			this.charge_pow = 7;
			this.element = 'N';// 無属性
			break;

		default:
			throw new NoMonsterNameException();
		}
		// コンストラクタのおわり
	}


	public String toString() {
		return this.name + "が現れた！\n\n"+
				this.name +"\nHP   ：" + this.hp +"/"+this.maxhp;
	}

}
