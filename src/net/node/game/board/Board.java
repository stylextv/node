package net.node.game.board;

import net.node.game.board.property.BoardProperty;
import net.node.game.board.property.properties.CastleProperty;
import net.node.game.board.property.properties.EnPassantProperty;
import net.node.game.board.property.properties.FiftyRuleProperty;
import net.node.game.board.property.properties.PlyProperty;
import net.node.game.board.property.properties.TurnProperty;
import net.node.game.board.view.BoardView;
import net.node.game.board.view.views.BitboardView;
import net.node.game.board.view.views.HashView;
import net.node.game.board.view.views.PieceView;
import net.node.game.board.view.views.SquareView;
import net.node.game.move.MoveProcessor;
import net.node.game.piece.Piece;

public class Board {
	
	private TurnProperty turn = new TurnProperty();
	
	private PlyProperty ply = new PlyProperty();
	
	private FiftyRuleProperty fiftyRule = new FiftyRuleProperty();
	
	private CastleProperty castle = new CastleProperty();
	
	private EnPassantProperty enPassant = new EnPassantProperty();
	
	private SquareView squares = new SquareView();
	
	private PieceView pieces = new PieceView();
	
	private BitboardView bitboards = new BitboardView();
	
	private HashView hash = new HashView();
	
	private BoardProperty[] properties = new BoardProperty[] {
			turn,
			ply,
			fiftyRule,
			castle,
			enPassant
	};
	
	private BoardView[] views = new BoardView[] {
			squares,
			pieces,
			bitboards,
			hash
	};
	
	private MoveProcessor moveProcessor = new MoveProcessor(this);
	
	public void makeMove(int move) {
		moveProcessor.makeMove(move);
	}
	
	public void unmakeMove(int move) {
		moveProcessor.unmakeMove(move);
	}
	
	public void movePiece(int from, int to) {
		int piece = getPiece(from);
		
		setPiece(to, piece);
		removePiece(from);
	}
	
	public void removePiece(int square) {
		int piece = getPiece(square);
		
		if(piece == Piece.NONE) return;
		
		for(BoardView view : views) {
			
			view.removePiece(square, piece);
		}
	}
	
	public void setPiece(int square, int piece) {
		removePiece(square);
		
		for(BoardView view : views) {
			
			view.setPiece(square, piece);
		}
	}
	
	public long getPieceBitboard(int color, int type) {
		return bitboards.getPieceBitboard(color, type);
	}
	
	public long getColorBitboard(int color) {
		return bitboards.getColorBitboard(color);
	}
	
	public long getTypeBitboard(int color) {
		return bitboards.getTypeBitboard(color);
	}
	
	public int getPieceSquare(int piece, int index) {
		return pieces.getPieceSquare(piece, index);
	}
	
	public int getPieceCount(int piece) {
		return pieces.getPieceCount(piece);
	}
	
	public int getPiece(int square) {
		return squares.getPiece(square);
	}
	
	public int getTurn() {
		return turn.getValue();
	}
	
	public int getPly() {
		return ply.getValue();
	}
	
	public int getFiftyRule() {
		return fiftyRule.getValue();
	}
	
	public boolean canCastle(int color, int side) {
		return castle.canCastle(color, side);
	}
	
	public int getEnPassantSquare() {
		return enPassant.getValue();
	}
	
	public BoardProperty[] getProperties() {
		return properties;
	}
	
	public BoardView[] getViews() {
		return views;
	}
	
}
