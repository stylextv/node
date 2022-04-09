package net.node;

import net.node.command.InputController;

public class Node {
	
	private static Node instance;
	
	public Node() {
		instance = this;
	}
	
	public void onStart() {
		InputController.sendMessage(Constants.VERSIONED_NAME + " by " + Constants.AUTHOR);
		
		InputController.start();
	}
	
	public static Node getInstance() {
		return instance;
	}
	
}
