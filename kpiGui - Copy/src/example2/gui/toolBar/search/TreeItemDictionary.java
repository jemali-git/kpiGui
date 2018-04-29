package example2.gui.toolBar.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.TreeItem;

public class TreeItemDictionary {
	Set<TreeItem<Object>> treeItems;
	Map<Character, TreeItemDictionary> map;

	public TreeItemDictionary() {
		treeItems = new HashSet<>();
	}

	public void addTreeItem(TreeItem<Object> treeItem) {
		String string = treeItem.getValue().toString().toLowerCase();
		for (int j = 0; j < string.length(); j++) {
			TreeItemDictionary treeItemDictionary = this;
			for (int i = string.length() - j - 1; i < string.length(); i++) {

				if (treeItemDictionary.map == null) {
					treeItemDictionary.map = new HashMap<>();
				}

				Character character = string.charAt(i);

				TreeItemDictionary newTreeItemDictionary = treeItemDictionary.map.get(character);
				if (newTreeItemDictionary == null) {
					newTreeItemDictionary = new TreeItemDictionary();
					treeItemDictionary.map.put(character, newTreeItemDictionary);
				}
				newTreeItemDictionary.treeItems.add(treeItem);
				treeItemDictionary = newTreeItemDictionary;
			}
		}
	}

	public Set<TreeItem<Object>> getMatchTreeItems(String string) {
		string = string.toLowerCase();
		Set<TreeItem<Object>> matchTreeItems = new HashSet<>();
		int maxLength = 0;
		for (int j = 0; j < string.length(); j++) {
			TreeItemDictionary treeItemDictionary = this;
			Set<TreeItem<Object>> treeItems = new HashSet<>();
			int length = 0;
			for (int i = j; i < string.length(); i++) {

				if (treeItemDictionary.map == null) {
					break;
				}
				Character character = string.charAt(i);
				if (treeItemDictionary.map.get(character) != null) {
					treeItemDictionary = treeItemDictionary.map.get(character);
					treeItems = treeItemDictionary.treeItems;
					length++;
				} else {
					break;
				}
			}
			if (length > maxLength) {
				maxLength = length;
				matchTreeItems = treeItems;
			}
		}
		return matchTreeItems;
	}

}
