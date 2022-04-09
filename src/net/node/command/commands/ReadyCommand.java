package net.node.command.commands;

import net.node.command.Command;
import net.node.command.InputController;
import net.node.command.message.Message;

public class ReadyCommand extends Command {
	
	public ReadyCommand() {
		super("isready");
	}
	
	@Override
	public void execute(Message m) {
		InputController.sendMessage("readyok");
	}
	
}
