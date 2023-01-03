package org.mantis.BlackjackIteration3;

import org.mantis.BlackjackIteration3.NotificationListeners.NotifyBlackjackHelper;
import org.mantis.BlackjackIteration3.NotificationListeners.NotifyChangedHelper;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Dealer deals cards and directs the course of play. In the game of Blackjack, a dealer
 * is also a player.
 * @Author Michael Allan Odhiambo.
 */

public class BlackjackDealer extends Player implements Dealer {

    private DeckPile cards;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> waitingPlayers;
    private ArrayList<Player> standingPlayers;
    private ArrayList<Player> bustedPlayers;
    private ArrayList<Player> blackjackPlayers;
    private ArrayList<Player> bettingPlayers;

    public BlackjackDealer( String name, Hand hand, DeckPile cards ) {
        super( name, hand );
        this.cards = cards;
    }

    @Override
    public void hit( Player player ) {
        player.addCard( cards.dealUp() );
    }

    @Override
    public void blackjack( Player player ) {
        blackjackPlayers.add( player );
        play( this );
    }

    @Override
    public void busted( Player player ) {
        bustedPlayers.add( player );
        play( this );
    }

    @Override
    public void standing( Player player ) {
        standingPlayers.add( player );
        play( this );
    }

    @Override
    public void doneBetting( Player player ) {
        waitingPlayers.add( player );
        play( this );
    }

    @Override
    protected boolean hit() {
        if ( standingPlayers.size() > 0 && this.getHand().getTotal() < 17 )
            return true;
        return false;
    }

    public void addPlayer( Player player ) {
        players.add( player );
    }

    public void reset() {
        waitingPlayers = new ArrayList<>();
        standingPlayers = new ArrayList<>();
        bustedPlayers = new ArrayList<>();
        blackjackPlayers = new ArrayList<>();
        bettingPlayers = new ArrayList<>();
        bettingPlayers.addAll( players );
        cards.reset();
        Iterator i = players.iterator();
        while ( i.hasNext() ) {
            Player player = ( Player ) i.next();
            player.reset();
        }
        setCurrentState( getInitialState() );
    }

    public void newGame() {
        reset();
        play( this );
    }

    public void deal() {
        cards.shuffle();
        Player[] playerArray = new Player[ waitingPlayers.size() ];
        waitingPlayers.toArray( playerArray );
        for ( int i = 0; i < playerArray.length; i++ )
            playerArray[i].addCard( cards.dealUp() );
        this.addCard( cards.dealUp() );
        // Deal one more card to each player and one down to self..
        for ( int i = 0; i < playerArray.length; i++ )
            playerArray[i].addCard( cards.dealUp() );
        this.addCard( cards.dealDown() );
    }

    private void exposeHand() {
        this.getHand().turnOver();
        notifyListeners( new NotifyChangedHelper() );
    }

    protected PlayerState getBlackjackState() {
        return new DealerBlackjackState();
    }

    protected PlayerState getDealingState() {
        return new DealingState();
    }

    protected PlayerState getBustedState() {
        return new DealerBustedState();
    }

    protected PlayerState getStandingState() {
        return new DealerStandingState();
    }

    protected PlayerState getWaitingState() {
        return new DealerWaitingState();
    }

    protected PlayerState getInitialState() {
        return getCollectingBetsState();
    }
    protected PlayerState getCollectingBetsState() {
        return new DealerCollectingBetsState();
    }

    private class DealerBustedState implements PlayerState {
        public void handChanged() {
            // not possible in busted state
        }
        public void handPlayable() {
            // not possible in busted state
        }
        public void handBlackjack() {
            // not possible in busted state
        }
        public void handBusted() {
            // not possible in busted state
        }
        public void execute( Dealer dealer ) {
            Iterator i = standingPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.win();
            }
            i = blackjackPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.blackjack();
            }
            i = bustedPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.lose();
            }
        }
    }

    private class DealerBlackjackState implements PlayerState {
        public void handChanged() {
            notifyListeners( new NotifyChangedHelper() );
        }
        public void handPlayable() {
            // not possible in blackjack state
        }
        public void handBlackjack() {
            // not possible in blackjack state
        }
        public void handBusted() {
            // not possible in blackjack state
        }
        public void execute( Dealer dealer ) {
            exposeHand();
            Iterator i = players.iterator();
            while( i.hasNext() ) {
                Player player = ( Player ) i.next();
                if ( player.getHand().blackjack() )
                    player.standoff();
                else
                    player.lose();
            }
        }
    }

    private class DealerCollectingBetsState implements PlayerState {

        @Override
        public void handPlayable() {
            // Not possible in collecting bets state..
        }

        @Override
        public void handBlackjack() {
            // Not possible in collecting bets state..
        }

        @Override
        public void handBusted() {
            // Not possible in collecting bets state..
        }

        @Override
        public void handChanged() {
            // Not possible in collecting bets state..
        }

        @Override
        public void execute( Dealer dealer ) {
            if ( !bettingPlayers.isEmpty() ) {
                Player player = ( Player ) bettingPlayers.get( 0 );
                bettingPlayers.remove( player );
                player.play( dealer );
            }
            else {
                setCurrentState( getDealingState() );
                getCurrentState().execute( dealer );
            }
        }
    }

    private class DealerStandingState implements PlayerState {
        public void handChanged() {
            // not possible in standing state
        }
        public void handPlayable() {
            // not possible in standing state
        }
        public void handBlackjack() {
            // not possible in standing state
        }
        public void handBusted() {
            // not possible in standing state
        }
        public void execute( Dealer dealer ) {
            Iterator i = standingPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                if ( BlackjackDealer.this.getHand().isEqualTo( player.getHand() ) )
                    player.standoff();
                else if ( BlackjackDealer.this.getHand().isGreaterThan( player.getHand() ) )
                    player.lose();
                else
                    player.win();
            }
            i = blackjackPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.win();
            }
            i = bustedPlayers.iterator();
            while( i.hasNext() ) {
                Player player = (Player) i.next();
                player.lose();
            }
        }
    }

    private class DealerWaitingState implements PlayerState {
        public void handChanged() {
            // not possible in waiting state
        }
        public void handPlayable() {
            // not possible in waiting state
        }
        public void handBlackjack() {
            // not possible in waiting state
        }
        public void handBusted() {
            // not possible in waiting state
        }
        public void execute( Dealer dealer ) {
            if( !waitingPlayers.isEmpty() ) {
                Player player = waitingPlayers.get( 0 );
                waitingPlayers.remove( player );
                player.play( dealer );
            } else {
                setCurrentState( getPlayingState() );
                exposeHand();
                getCurrentState().execute( dealer );
                // transition and execute
            }
        }
    }

    private class DealingState implements PlayerState {
        public void handChanged() {
            notifyListeners( new NotifyChangedHelper() );
        }
        public void handPlayable() {
            setCurrentState( getWaitingState() );
        }
        public void handBlackjack() {
            setCurrentState( getBlackjackState() );
            notifyListeners( new NotifyBlackjackHelper() );
        }
        public void handBusted() {
            // not possible in dealing state
        }
        public void execute( Dealer dealer ) {
            deal();
            getCurrentState().execute( dealer );
        }
    }
}
