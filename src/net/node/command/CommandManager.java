package net.node.command;

import net.node.command.commands.GoCommand;
import net.node.command.commands.InfoCommand;
import net.node.command.commands.NewGameCommand;
import net.node.command.commands.OptionCommand;
import net.node.command.commands.PositionCommand;
import net.node.command.commands.QuitCommand;
import net.node.command.commands.ReadyCommand;
import net.node.command.commands.StopCommand;
import net.node.command.message.Message;

public class CommandManager {
	
	private static final Command[] COMMANDS = new Command[] {
			new PositionCommand(),
			new GoCommand(),
			new StopCommand(),
			new OptionCommand(),
			new NewGameCommand(),
			new ReadyCommand(),
			new InfoCommand(),
			new QuitCommand()
	};
	
	public static void parseMessage(Message m) {
		String name = m.getName();
		
		Command c = getCommand(name);
		
		if(c == null) {
			
			InputController.sendMessage("Unknown command: " + name);
			
			return;
		}
		
		c.execute(m);
	}
	
	public static Command getCommand(String name) {
		for(Command c : COMMANDS) {
			
			String s = c.getName();
			
			if(s.equalsIgnoreCase(name)) return c;
		}
		
		return null;
	}
	
}
