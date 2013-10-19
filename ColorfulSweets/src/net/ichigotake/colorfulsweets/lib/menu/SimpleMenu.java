package net.ichigotake.colorfulsweets.lib.menu;


/**
 * API Level 1
 * Interface used for {@link SimpleMenuList} item.
 */
public interface SimpleMenu {
	
	/**
	 * Return the text for list item label.
	 * @return The identifier for resource
	 */
	public int getLabelName();
	
	/**
	 * Return the background to a given resource.
	 * @return The identifier for resource.
	 */
	public int getIconResource();
	
}
