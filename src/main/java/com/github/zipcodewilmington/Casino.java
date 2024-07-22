package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {

    public String accountSignedIn;
    public String passwordSignedIn;
    public CasinoAccountManager casinoAccountManager123;
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        this.casinoAccountManager123 = casinoAccountManager;
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    this.accountSignedIn = accountName;
                    this.passwordSignedIn = accountPassword;
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
                        play(new NumberGuessGame(), new NumberGuessPlayer());
                    }else if(gameSelectionInput.equals("ROULETTE")){
                        play(new RouletteGame(), new RoulettePlayer());
                    }else if(gameSelectionInput.equals("BLACKJACK")){
                        play(new BlackJackGame(), new BlackJackPlayer());
                    }else if (gameSelectionInput.equals("KENO")){
                            play(new KenoGame(), new KenoPlayer());
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                   String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
//                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                   // continue;
                    System.out.printf((errorMessage) + "%n", accountPassword, accountName);
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
                Integer amountToAdd = console.getIntegerInput("Please add money to your balance:  \n How much would you like to add?");
                casinoAccountManager.getAccount(accountName, accountPassword).setAccountBalance(amountToAdd);
                System.out.println("Your new balance is: " + casinoAccountManager.getAccount(accountName, accountPassword).getAccountBalance() + " \n Have fun wasting your money!");
               // System.out.println("inside get account : " + casinoAccountManager.getAccount(accountName, accountPassword).getAccountName());
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ BLACKJACK], [ ROULETTE ], [ KENO ], [ BEAT THE DEALER ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.addUserNameAndPassword(this.accountSignedIn, this.passwordSignedIn);
        game.addCasinoAccountManager(this.casinoAccountManager123);
        game.run();
    }
}
