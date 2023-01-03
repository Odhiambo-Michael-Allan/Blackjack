package org.mantis.BlackjackIteration4;

public class OptionViewController implements PlayerListener {

    private GUIPlayer model;
    private BlackjackDealer dealer;
    private OptionView view;

    public OptionViewController( GUIPlayer model, BlackjackDealer dealer, OptionView view ) {
        this.model = model;
        this.dealer = dealer;
        this.view = view;
        this.model.addListener( this );
    }

    public void quit() {
        System.exit( 0 );
    }

    public void hit() {
        model.takeCard();
    }

    public void stand() {
        model.stand();
    }

    public void newGame() {
        view.disableGameControls( true );
        view.disablePlayerControls( true );
        view.disableBettingControls( false );
        dealer.newGame();
    }

    public void bet10() {
        view.disableBettingControls( true );
        view.disablePlayerControls( false );
        model.place10Bet();
    }

    public void bet50() {
        view.disableBettingControls( true );
        view.disablePlayerControls( false );
        model.place50Bet();
    }

    public void bet100() {
        view.disableBettingControls( true );
        view.disablePlayerControls( false );
        model.place100Bet();
    }

    @Override
    public void playerChanged( Player player ) {}

    @Override
    public void playerBusted( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }

    @Override
    public void playerBlackjack( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }

    @Override
    public void playerStanding( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }

    @Override
    public void playerWon( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }

    @Override
    public void playerLost( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }

    @Override
    public void playerStandOff( Player player ) {
        view.disablePlayerControls( true );
        view.disableGameControls( false );
    }
}
