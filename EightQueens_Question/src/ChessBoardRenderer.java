public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {

		// WRITE YOUR LOGIC HERE...
		System.out.println(square);
		return ((square/8)%2 == 0 && square%2 != 0) || ((square/8)%2 != 0 && square%2 == 0);
	}
}
