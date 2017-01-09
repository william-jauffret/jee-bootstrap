package jeudame;

public class Pion {

	private int x = 0;
	private int y = 0;
	private ColorChip color;
	private boolean isQueen = false;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ColorChip getColor() {
		return color;
	}

	public void setColor(ColorChip color) {
		this.color = color;
	}

	public boolean isQueen() {
		return isQueen;
	}

	public void setQueen(boolean isQueen) {
		this.isQueen = isQueen;
	}

	public void Move(int colorCode, String leftOrRight) {
		
		if(!this.isQueen){
			// pour les pion Noirs 
			if ( colorCode == 0 && leftOrRight == "left") {
				if (!(this.x - 1 < 0) && !(this.y + 1 > 10)) {
					this.x = (this.x - 1);
					this.y = (this.y + 1);
				} else {
					throw new GameException("Outside of board");
				}
			} else if ( colorCode == 0 && leftOrRight == "right") {
				if (!(this.x + 1 > 10) && !(this.y + 1 > 10)) {
					this.x = (this.x + 1);
					this.y = (this.y + 1);
				} else {
					throw new GameException("Outside of board");
				}
				
			// Pour les jetons blancs, ils sont en haut du board
			} else if ( colorCode == 1 && leftOrRight == "left") {
				if (!(this.x - 1 < 0) && !(this.y - 1 < 0)) {
					this.x = (this.x - 1);
					this.y = (this.y - 1);
				} else {
					throw new GameException("Outside of board");
				}
			} else if (colorCode == 1 && leftOrRight == "right") {
				if (!(this.x + 1 > 10) && !(this.y - 1 < 0)) {
					this.x = (this.x + 1);
					this.y = (this.y - 1);
				} else {
					throw new GameException("Outside of board");
				}
			}
			// Si ce n'est pas une reine 
		} else {
			
		}
		
	}

}
