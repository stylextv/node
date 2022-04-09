package net.node.command.commands;

import net.node.command.Command;
import net.node.command.message.Message;

public class NewGameCommand extends Command {
	
	public NewGameCommand() {
		super("ucinewgame");
	}
	
	@Override
	public void execute(Message m) {
		// TODO clear TT and such?
	}
	
}
