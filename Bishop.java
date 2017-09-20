package chessGame;

/**
 * Bishop --- Extension of piece with bishop specific properties for valid moves
 * @author    Henry Magnuson
 */
public class Bishop extends Piece{

	public Bishop(boolean isWhite, Board myBoard) {
		super(isWhite, myBoard);
		
	}
	
	//checks if move is along a diagonal and there are no pieces in the way
	public boolean validMove(Space toCheck, Space currSpace){
		
		int xi = currSpace.column;
		int xf = toCheck.column;
		int yi = currSpace.row;
		int yf = toCheck.row;
		
		
		if(Math.abs(xf-xi)!= Math.abs(yf-yi))
			return false;
		if(Math.abs(xf-xi) == 1)
			return true;
		
		if(xi>xf && yi>yf){
			for(int x=xi-1; x>xf; x--){
				if(myBoard.getSpace(x,yi-1).occupied()){
					return false;}
				yi--;
			}
			return true;
		}
		
		if(xi<xf && yi>yf){
			for(int x=xi+1; x<xf; x++){
				if(myBoard.getSpace(x,yi-1).occupied()){
					return false;}
				yi--;
			}
			return true;
		}
		
		if(xi<xf && yi<yf){
			for(int x=xi+1; x<xf; x++){
				if(myBoard.getSpace(x,yi+1).occupied()){
					return false;}
				yi++;
			}
			return true;
		}
		
		if(xi>xf && yi<yf){
			for(int x=xi-1; x>xf; x--){
				if(myBoard.getSpace(x,yi+1).occupied()){
					return false;}
				yi++;
			}
			return true;
		}
		
		return true;
	}
		
		
		
}


