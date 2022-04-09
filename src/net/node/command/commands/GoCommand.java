package net.node.command.commands;

import net.node.command.Command;
import net.node.command.InputController;
import net.node.command.message.Message;
import net.node.game.board.Board;
import net.node.pick.MovePicker;

public class GoCommand extends Command {
	
	public GoCommand() {
		super("go");
	}
	
	@Override
	public void execute(Message m) {
		Board b = InputController.getBoard();
		
		int move = MovePicker.pickMove(b);
		
		
	}
	
}
