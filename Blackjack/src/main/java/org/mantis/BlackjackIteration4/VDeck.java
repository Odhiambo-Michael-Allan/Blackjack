package org.mantis.BlackjackIteration4;

/**
 * The VDeck builds a deck of VCards. Please not that you could have written a loop that would construct
 * the correct image names. However, while ugly, this is a much more straight forward approach.
 * @Author Michael Allan Odhiambo.
 */
public class VDeck extends Deck {

    @Override
    protected void buildCards() {
        Card[] deck = new Card[52];
        setDeck( deck );
        deck[0] = new VCard( Suit.HEARTS, Rank.TWO, "CardImages/TwoOfHearts.png" );
        deck[1] = new VCard( Suit.HEARTS, Rank.THREE, "CardImages/ThreeOfHearts.png" );
        deck[2] = new VCard( Suit.HEARTS, Rank.FOUR, "CardImages/FourOfHearts.png" );
        deck[3] = new VCard( Suit.HEARTS, Rank.FIVE, "CardImages/FiveOfHearts.png" );
        deck[4] = new VCard( Suit.HEARTS, Rank.SIX, "CardImages/SixOfHearts.png" );
        deck[5] = new VCard( Suit.HEARTS, Rank.SEVEN, "CardImages/SevenOfHearts.png" );
        deck[6] = new VCard( Suit.HEARTS, Rank.EIGHT, "CardImages/EightOfHearts.png" );
        deck[7] = new VCard( Suit.HEARTS, Rank.NINE, "CardImages/NineOfHearts.png" );
        deck[8] = new VCard( Suit.HEARTS, Rank.TEN, "CardImages/TenOfHearts.png" );
        deck[9] = new VCard( Suit.HEARTS, Rank.JACK, "CardImages/JackOfHearts.png" );
        deck[10] = new VCard( Suit.HEARTS, Rank.QUEEN, "CardImages/QueenOfHearts.png" );
        deck[11] = new VCard( Suit.HEARTS, Rank.KING, "CardImages/KingOfHearts.png" );
        deck[12] = new VCard( Suit.HEARTS, Rank.ACE, "CardImages/AceOfHearts.png" );
        deck[13] = new VCard( Suit.DIAMONDS, Rank.TWO, "CardImages/TwoOfDiamonds.png" );
        deck[14] = new VCard( Suit.DIAMONDS, Rank.THREE, "CardImages/ThreeOfDiamonds.png" );
        deck[15] = new VCard( Suit.DIAMONDS, Rank.FOUR, "CardImages/FourOfDiamonds.png" );
        deck[16] = new VCard( Suit.DIAMONDS, Rank.FIVE, "CardImages/FiveOfDiamonds.png" );
        deck[17] = new VCard( Suit.DIAMONDS, Rank.SIX, "CardImages/SixOfDiamonds.png" );
        deck[18] = new VCard( Suit.DIAMONDS, Rank.SEVEN, "CardImages/SevenOfDiamonds.png" );
        deck[19] = new VCard( Suit.DIAMONDS, Rank.EIGHT, "CardImages/EightOfDiamonds.png" );
        deck[20] = new VCard( Suit.DIAMONDS, Rank.NINE, "CardImages/NineOfDiamonds.png" );
        deck[21] = new VCard( Suit.DIAMONDS, Rank.TEN, "CardImages/TenOfDiamonds.png" );
        deck[22] = new VCard( Suit.DIAMONDS, Rank.JACK, "CardImages/JackOfDiamonds.png" );
        deck[23] = new VCard( Suit.DIAMONDS, Rank.QUEEN, "CardImages/QueenOfDiamonds.png" );
        deck[24] = new VCard( Suit.DIAMONDS, Rank.KING, "CardImages/KingOfDiamonds.png" );
        deck[25] = new VCard( Suit.DIAMONDS, Rank.ACE, "CardImages/AceOfDiamonds.png" );
        deck[26] = new VCard( Suit.SPADES, Rank.TWO, "CardImages/TwoOfSpades.png" );
        deck[27] = new VCard( Suit.SPADES, Rank.THREE, "CardImages/ThreeOfSpades.png" );
        deck[28] = new VCard( Suit.SPADES, Rank.FOUR, "CardImages/FourOfSpades.png" );
        deck[29] = new VCard( Suit.SPADES, Rank.FIVE, "CardImages/FiveOfSpades.png" );
        deck[30] = new VCard( Suit.SPADES, Rank.SIX, "CardImages/SixOfSpades.png" );
        deck[31] = new VCard( Suit.SPADES, Rank.SEVEN, "CardImages/SevenOfSpades.png" );
        deck[32] = new VCard( Suit.SPADES, Rank.EIGHT, "CardImages/EightOfSpades.png" );
        deck[33] = new VCard( Suit.SPADES, Rank.NINE, "CardImages/NineOfSpades.png" );
        deck[34] = new VCard( Suit.SPADES, Rank.TEN, "CardImages/TenOfSpades.png" );
        deck[35] = new VCard( Suit.SPADES, Rank.JACK, "CardImages/JackOfSpades.png" );
        deck[36] = new VCard( Suit.SPADES, Rank.QUEEN, "CardImages/QueenOfSpades.png" );
        deck[37] = new VCard( Suit.SPADES, Rank.KING, "CardImages/KingOfSpades.png" );
        deck[38] = new VCard( Suit.SPADES, Rank.ACE, "CardImages/AceOfSpades.png" );
        deck[39] = new VCard( Suit.CLUBS, Rank.TWO, "CardImages/TwoOfClubs.png" );
        deck[40] = new VCard( Suit.CLUBS, Rank.THREE, "CardImages/ThreeOfClubs.png" );
        deck[41] = new VCard( Suit.CLUBS, Rank.FOUR, "CardImages/FourOfClubs.png" );
        deck[42] = new VCard( Suit.CLUBS, Rank.FIVE, "CardImages/FiveOfClubs.png" );
        deck[43] = new VCard( Suit.CLUBS, Rank.SIX, "CardImages/SixOfClubs.png" );
        deck[44] = new VCard( Suit.CLUBS, Rank.SEVEN, "CardImages/SevenOfClubs.png" );
        deck[45] = new VCard( Suit.CLUBS, Rank.EIGHT, "CardImages/EightOfClubs.png" );
        deck[46] = new VCard( Suit.CLUBS, Rank.NINE, "CardImages/NineOfClubs.png" );
        deck[47] = new VCard( Suit.CLUBS, Rank.TEN, "CardImages/TenOfClubs.png" );
        deck[48] = new VCard( Suit.CLUBS, Rank.JACK, "CardImages/JackOfClubs.png" );
        deck[49] = new VCard( Suit.CLUBS, Rank.QUEEN, "CardImages/QueenOfClubs.png" );
        deck[50] = new VCard( Suit.CLUBS, Rank.KING, "CardImages/KingOfClubs.png" );
        deck[51] = new VCard( Suit.CLUBS, Rank.ACE, "CardImages/AceOfClubs.png" );
    }

}
