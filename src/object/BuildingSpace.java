package object;

import system.Tools;

public abstract class BuildingSpace {

	public static final Tools tl = new Tools();

	public abstract void goThere(Player player) throws Exception;
}
