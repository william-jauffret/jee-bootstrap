package jeudame;

public class Pion {

	private int x = 0;
	private int y = 0;
	private ColorChip color;
	private boolean isQueen = false;

	public Pion(int x, int y, String color) {
		this.x = x;
		this.y = y;
		if(color.equals("WHITE")){
			this.color = ColorChip.WHITE;
		} else {
			this.color = ColorChip.BLACK;
		}

	}

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
}
