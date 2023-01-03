import org.junit.jupiter.api.Test;
import org.mantis.BlackjackIteration4.Card;
import org.mantis.BlackjackIteration4.Rank;
import org.mantis.BlackjackIteration4.Suit;
import org.mantis.BlackjackIteration4.VCard;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleUnitTest {

    @Test
    public void getImageTest() {
        Card card = new VCard( Suit.HEARTS, Rank.ACE, "/CardImages/AceOfHearts" );
    }
}
