package net.node.game.move.generate.generators.types;

import net.node.game.board.Board;
import net.node.game.move.generate.MoveGenerator;
import net.node.game.move.list.MoveList;

public abstract class SingleMoveGenerator extends MoveGenerator {
	
	public abstract void generateMoves(Board board, int square, MoveList list);
	
	@Override
	public void generateMoves(Board board, MoveList list) {
		
	}
	
}
