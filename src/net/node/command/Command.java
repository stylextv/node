package net.node.command;

import net.node.command.message.Message;

public abstract class Command {
	
	private String name;
	
	public Command(String name) {
		this.name = name;
	}
	
	public abstract void execute(Message m);
	
	public String getName() {
		return name;
	}
	
}
