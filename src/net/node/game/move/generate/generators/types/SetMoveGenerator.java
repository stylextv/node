package net.node.game.move.generate.generators.types;

import net.node.game.board.Board;
import net.node.game.move.generate.MoveGenerator;
import net.node.game.move.list.MoveList;

public abstract class SetMoveGenerator extends MoveGenerator {
	
	public abstract void generateMoves(Board board, long bb, MoveList list);
	
	@Override
	public void generateMoves(Board board, MoveList list) {
		
	}
	
}
