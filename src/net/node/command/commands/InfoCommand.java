package net.node.command.commands;

import net.node.Constants;
import net.node.command.Command;
import net.node.command.InputController;
import net.node.command.message.Message;

public class InfoCommand extends Command {
	
	public InfoCommand() {
		super("uci");
	}
	
	@Override
	public void execute(Message m) {
		InputController.sendMessage("id", "name", Constants.VERSIONED_NAME);
		InputController.sendMessage("id", "author", Constants.AUTHOR);
		
		
		
		InputController.sendMessage("uciok");
	}
	
}
