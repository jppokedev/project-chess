package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardExceptio("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public Integer getRows() {
		return rows;
	}
	public Integer getColumns() {
		return columns;
	}

	public Piece piece(Integer row, Integer column) {
		if(!positionExists(row, column)) {
			throw new BoardExceptio("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardExceptio("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardExceptio("There is already a piece on position "+ position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private Boolean positionExists(Integer row, Integer column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public Boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardExceptio("Position not on the board");
		}
		return piece(position) != null;
	}
	
}
