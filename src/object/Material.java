package object;

import system.NoItemNameException;

public class Material{

	public String name;

	public int buy;

	public Material(String str) throws NoItemNameException {
		name = str;

		switch(name) {
			case "木の板" :
				buy = 200;
				break;

			case "ボルト":
				buy = 100;
				break;

			case "からのびん":
				buy = 100;
				break;

			case "やくそう":
				buy = 100;
				break;

			case "炎の石":
				buy = 200;
				break;

			case "氷の石":
				buy = 200;
				break;

			case "鉄鉱石":
				buy = 200;
				break;

			default:
				throw new NoItemNameException();
		}
	}
}
