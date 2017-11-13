
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        // create two integers for the row and col difference between the doctors position and the clicks position
        int difRow = newRow - this.row;
        int difCol = newCol - this.col;

        // if you click on the doctor, it will not move
        if (newRow == this.row && newCol == this.col) {
            newRow = this.row;
            newCol = this.col;
        }

        // if the click is on a spot immediately near the doctor, move to it
        if (difCol >= -1 && difCol <= 1 && difRow >= -1 && difRow <= 1) {
            this.col = newCol;
            this.row = newRow;

            // if the click is not on a spot immediately near the doctor, teleport randomly  
        } else {
            this.col = (int) (Math.random() * 12);
            this.row = (int) (Math.random() * 12);
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;

    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;

    }
}
