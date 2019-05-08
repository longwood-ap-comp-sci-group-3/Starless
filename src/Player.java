
public class Player {
private int x, y;
private boolean left, right, up, down;

public void update() {
	move();
}

public void move() {
	if(left) {
		x--;
	}
	if(right) {
		x++;
	}
	if(up) {
		y--;
	}
	if(down) {
		y++;
	}
}

public void setLeft (boolean newLeft) {
	left = newLeft;
}

public void setUp (boolean newUp) {
	up = newUp;
}

public void setDown (boolean newDown) {
	down = newDown;
}

public void setRight (boolean newRight) {
	right = newRight;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

}
