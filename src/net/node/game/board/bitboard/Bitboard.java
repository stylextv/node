package net.node.game.board.bitboard;

import net.node.game.board.bitboard.bitboards.PositionBitboard;
import net.node.game.board.position.BoardSquare;

public class Bitboard {
	
	public static final long EMPTY = 0;
	public static final long FULL = -1;
	
	public static int firstSquare(long bb) {
		return Long.numberOfTrailingZeros(bb);
	}
	
	public static int lastSquare() {
		int i = Long.numberOfLeadingZeros(EMPTY);
		
		return BoardSquare.H8 - i;
	}
	
	public static int squareCount(long bb) {
		return Long.bitCount(bb);
	}
	
	public static boolean containsSquare(long bb, int square) {
		long mask = PositionBitboard.ofSquare(square);
		
		return intersects(bb, mask);
	}
	
	public static long flipSquare(long bb, int square) {
		long mask = PositionBitboard.ofSquare(square);
		
		return xor(bb, mask);
	}
	
	// TODO prevent over-/underflow
	public static long shift(long bb, int dir) {
		
		
		return dir < 0 ? bb >>> -dir : bb << dir;
	}
	
	public static boolean contains(long bb1, long bb2) {
		return intersection(bb1, bb2) == bb2;
	}
	
	public static boolean intersects(long bb1, long bb2) {
		return intersection(bb1, bb2) != EMPTY;
	}
	
	public static long intersection(long bb1, long bb2) {
		return bb1 & bb2;
	}
	
	public static long union(long bb1, long bb2) {
		return bb1 | bb2;
	}
	
	public static long xor(long bb1, long bb2) {
		return bb1 ^ bb2;
	}
	
	public static long complement(long bb) {
		return ~bb;
	}
	
}
