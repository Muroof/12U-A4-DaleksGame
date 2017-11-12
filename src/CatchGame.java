
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    // create a board
    private Board b = new Board(12, 12);
    // create three Daleks
//    private Dalek beshoy = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
//    private Dalek kiran = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
//    private Dalek shaq = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
//    // create a doctor
//    private Doctor player = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
    private Dalek kiran = new Dalek(6, 5);
    private Dalek beshoy = new Dalek(5, 5);
    private Dalek shaq = new Dalek(4, 5);
    // create a doctor
    private Doctor player = new Doctor(5, 7);

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {

        // doctor spawn
        b.putPeg(Color.GREEN, player.getRow(), player.getCol());

        // dalek beshoy spawn
        b.putPeg(Color.BLACK, beshoy.getRow(), beshoy.getCol());

        // dalek kiran spawn
        b.putPeg(Color.BLACK, kiran.getRow(), kiran.getCol());

        // dalek shaq spawn
        b.putPeg(Color.BLACK, shaq.getRow(), shaq.getCol());

    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {

        while (true) {

            // if shaq collides with kiran
            // shaq and kiran are set to crashed
            if (shaq.getRow() == kiran.getRow() && shaq.getCol() == kiran.getCol()) {
                shaq.crash();
                kiran.crash();
                System.out.println("Shaq and Kiran crashed into each other");
            }
            // if beshoy collides with kiran
            // beshoy and kiran are set to crashed
            if (beshoy.getRow() == kiran.getRow() && beshoy.getCol() == kiran.getCol()) {
                kiran.crash();
                beshoy.crash();
                System.out.println("Kiran and Beshoy crashed into each other");
            }
            // if shaq collides with beshoy
            // shaq and beshoy are set to crashed
            if (shaq.getRow() == beshoy.getRow() && shaq.getCol() == beshoy.getCol()) {
                shaq.crash();
                beshoy.crash();
                System.out.println("Shaq and Beshoy crashed into each other");
            }

            // IF ANYONE CRASHES PLACE RED PEG AT CRASH SITE
            if (kiran.hasCrashed()) {
                b.putPeg(Color.RED, kiran.getRow(), kiran.getCol());
            }
            if (beshoy.hasCrashed()) {
                b.putPeg(Color.RED, beshoy.getRow(), beshoy.getCol());
            }
            if (shaq.hasCrashed()) {
                b.putPeg(Color.RED, shaq.getRow(), shaq.getCol());
            }

            if (player.getRow() == kiran.getRow() && player.getCol() == kiran.getCol() || player.getRow() == beshoy.getRow() && player.getCol() == beshoy.getCol() || player.getRow() == shaq.getRow() && player.getCol() == shaq.getCol()) {
                b.putPeg(Color.YELLOW, player.getRow(), player.getCol());
                b.displayMessage("You Lost lmao");
                break;
            }

            if (kiran.hasCrashed() && beshoy.hasCrashed() && shaq.hasCrashed()) {
                b.displayMessage("Ay winner");
                break;
            }

            // initialize click
            Coordinate click = b.getClick();
            // assign click coordinates to integers
            int clickRow = click.getRow();
            int clickCol = click.getCol();

            // when a click is made, move the doctos pin
            b.removePeg(player.getRow(), player.getCol());
            player.move(clickRow, clickCol);
            b.putPeg(Color.GREEN, player.getRow(), player.getCol());

            
            // when a click is made, and kiran isn't crashed, move kiran's pin
            if (!kiran.hasCrashed()) {
                // dalek kiran
                b.removePeg(kiran.getRow(), kiran.getCol());
                kiran.advanceTowards(player);
                System.out.println("KIRAN MOVED");
            }
            // when a click is made, and beshoy isn't crashed, move behsoy's pin
            if (!beshoy.hasCrashed()) {
                // dalek beshoy
                b.removePeg(beshoy.getRow(), beshoy.getCol());
                beshoy.advanceTowards(player);
                System.out.println("BESHOY MOVED");
            }
            // when a click is made, and shaq isn't crashed, move shaq's pin
            if (!shaq.hasCrashed()) {
                // dalek shaq
                b.removePeg(shaq.getRow(), shaq.getCol());
                shaq.advanceTowards(player);
                System.out.println("SHAQ MOVED CHUZ");
            }
            b.putPeg(Color.BLACK, kiran.getRow(), kiran.getCol());
            b.putPeg(Color.BLACK, beshoy.getRow(), beshoy.getCol());
            b.putPeg(Color.BLACK, shaq.getRow(), shaq.getCol());

        }

    }
}
