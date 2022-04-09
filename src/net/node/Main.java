package net.node;

import net.node.util.ExceptionUtil;

public class Main {
	
	public static void main(String[] args) {
		Node h = new Node();
		
		ExceptionUtil.catchEverything(() -> h.onStart());
	}
	
}
