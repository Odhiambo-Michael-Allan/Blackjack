package IterationThreeTests;

import org.mantis.BlackjackIteration3.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;


public class BankTest {

    private TestBank bank;

    @BeforeEach
    public void setup() {
        bank = new TestBank();
    }

    @Test
    public void testPlace100Bet() {
        bank.place100Bet();
        Assertions.assertTrue( bank.getBalance() == 900, "Balance should be $900 bet." );
    }

    @Test
    public void testPlace50Bet() {
        bank.place50Bet();
        Assertions.assertTrue( bank.getBalance() == 950, "Balance should be $950" );
    }

    @Test
    public void testPlace10Bet() {
        bank.place10Bet();
        Assertions.assertTrue( bank.getBalance() == 990, "Balance should be $990" );
    }

    @Test
    public void testWin() {
        bank.place10Bet();
        bank.win();
        Assertions.assertTrue( bank.getBalance() == 1010, "Balance should have increased by double" +
                " the bet amount" );
        bank.place100Bet();
        bank.win();
        Assertions.assertTrue( bank.getBalance() == 1110, "Balance should have increased by double " +
                "the bet amount" );
    }

    @Test
    public void testLose() {
        bank.place50Bet();
        bank.lose();
        Assertions.assertTrue( bank.getBalance() == 950, "Balance should be $950" );
    }

    @Test
    public void testBlackjack() {
        double balanceBefore = bank.getBalance();
        bank.place100Bet();
        bank.blackjack();
        double balanceAfter = balanceBefore + ( ( 3 / 2 ) * bank.getBetAmount() );
        Assertions.assertTrue( bank.getBalance() == balanceAfter, "Balance should be $" + balanceAfter );
    }

    @Test
    public void testStandOff() {
        double initialBalance = bank.getBalance();
        bank.place50Bet();
        bank.standOff();
        Assertions.assertTrue( bank.getBalance() == initialBalance, "Balance should be $" + initialBalance );
    }

    @Test
    public void testToString() {
        bank.place10Bet();
        Assertions.assertTrue( bank.toString().equals( "$990.00" ), "String representation is incorrect" );
    }

    private class TestBank extends Bank {

        public double getBalance() {
            return this.balance;
        }

        public double getBetAmount() {
            return this.bet;
        }
    }
}
