package net.node.command.commands;

import net.node.command.Command;
import net.node.command.InputController;
import net.node.command.message.Message;

public class QuitCommand extends Command {
	
	public QuitCommand() {
		super("quit");
	}
	
	@Override
	public void execute(Message m) {
		InputController.stop();
	}
	
}
