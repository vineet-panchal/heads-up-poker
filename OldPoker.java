import java.util.*;

import javax.sound.sampled.Port;

import java.math.*;

public class OldPoker {
    public static void main(String[] args) { // start of main method

    Scanner input = new Scanner(System.in); // scanner input, keyboard input
    Random generator = new Random(); // random generator input

// introduction
        // printing the course info, intro, about the creator/credits, and the rules of the game
        System.out.println("Vineet Panchal");
        System.out.println("345559900");
        System.out.println("ICS 3U1-01");
        System.out.println("June 9, 2022");
        System.out.println();

        System.out.println("Hello new Player!");
        System.out.println("Welcome to Vineet's Poker!");
        System.out.println();

        System.out.println("About The Creator:");
        System.out.println();
        System.out.println("Vineet Panchal is an young adult from Toronto, Canada who has interest in computer science.");
        System.out.println("This poker game in java is influenced by a project assigned in his grade 11 computer science course, ICS 3U1-01.");
        System.out.println("With his interest in the game poker and his mindset of challenging himself, he selected to create poker in java for his final project.");
        System.out.println("This game is one of Vineet's first few projects he has done as a software developer, and there's lot more to come.");
        System.out.println();

        System.out.println("The Rules Of The Game:");
        System.out.println();
        System.out.println("Poker is a game played at the casino with it's main goal to get the money that your opponents have put into the game.");
        System.out.println("All of the players start off with the same balance which they can use to bet throughout the game.");
        System.out.println("Players are given two cards each to play with. By the end of the game/round, there will be a total of seven cards from you would have to make your decision.");
        System.out.println("Each turn, all players are given three options for a move, Check, Bet, Fold.");
        System.out.println("Folding means that you don't want to be part of the game because you think you have bad cards, or just don't want to lose money.");
        System.out.println("Betting means you to put in money in the game to try and get your opponents to call your bet.");
        System.out.println("When a player has betted in the game, you are only left with two moves, Call or Fold.");
        System.out.println("Calling means that if you want to stay in the game you have to put in the same amount as the previous bet.");
        System.out.println("The bets and the calls are all added to the winning pot which will be given to the winner at the end of each round.");
        System.out.println("Checking means you don't really want to do anything and want to stay in the game to look at your chances.");
        System.out.println("When all of the players at a table have checked for the first time, the flop cards, which are three cards, will be shown to everyone.");
        System.out.println("The second time all players at the table have checked, the turn card will be shown, which is the fourth card.");
        System.out.println("The third time all players at the table have checked, the river card will be shown, which is the fifth and the last card.");
        System.out.println("With the seven cards in front of you, you would have to determine which hand ranking you have, and make a calculated move with that knowledge.");
        System.out.println("Also take in account of what the other players would have.");
        System.out.println("The fourth time all players check, everyone's cards will be shown, and whoever has the higher hand ranking will win the winning pot.");
        System.out.println();

        System.out.println("The Hand Rankings:");
        System.out.println();
        System.out.println("#1: Full House     #2: Straight Flush     #3: Four Of A Kind   #4: Full House     #5: Flush");
        System.out.println();
        System.out.println("Ace of Diamonds    10 of Hearts           Ace of Hearts        Ace of Hearts      King of Cloves");
        System.out.println("King of Diamonds   9 of Hearts            Ace of Cloves        Ace of Cloves      10 of Cloves");
        System.out.println("Queen of Diamonds  8 of Hearts            Ace of Diamonds      Ace of Diamonds    8 of Cloves");
        System.out.println("Jack of Diamonds   7 of Hearts            Ace of Spades        King of Spades     7 of Cloves");
        System.out.println("10 of Diamonds     6 of Hearts            King of Diamonds     King of Diamonds   5 of Cloves");
        System.out.println();
        System.out.println("#6: Straight       #7: Three Of A Kind    #8: Two Pair         #9: One Pair       #10: High Card");
        System.out.println();
        System.out.println("10 of Hearts       Ace of Hearts          Ace of Hearts        Ace of Hearts      Ace of Hearts");
        System.out.println("9 of Cloves        Ace of Diamonds        Ace of Spades        Ace of Cloves      King of Spades");
        System.out.println("8 of Diamonds      Ace of Spades          King of Diamonds     King of Diamonds   Queen of Cloves");
        System.out.println("7 of Spades        King of Spades         King of Cloves       Jack of Spades     9 of Spades");
        System.out.println("6 of Hearts        Queen of Cloves        7 of Cloves          7 of Hearts        7 of Hearts");
        System.out.println();

        // beginning game, asking user for name and balance, and telling the user who their opponent will be
        System.out.println("Enter your name new Player:");
        String player = input.nextLine();
        System.out.println();

        int balance; // initializing balance variable for the user's balance

            do { // do-while loop for finding the user's desired balance
                System.out.println("Enter your balance ($100 - $1000):");
                balance = input.nextInt();
                System.out.println();

                    if (balance < 100 || balance > 1000) { // if balance entered doesn't fit the range of 100-1000
                        System.out.println("Invalid entry ...");
                        System.out.println();
                    }

                    else { // else if balance entered fits the range of 100-1000
                        System.out.println("Your balance is $" + balance + "."); // printing the user's balance

                        break; // breaking the loop
                    }
            }
            while (balance < 100 || balance > 1000); // condition: loop while balance entered doesn't fit the range of 100-1000

        int balanceOpp = balance; // initializing the same balance for the opponent

        System.out.println("Your opponent will be Vineet.");
        System.out.println();
// end of introduction

// deck of cards
            // initializing two string arrays, one for the suits, and one for the ranks
            String[] suits = {"Diamonds", "Spades", "Hearts", "Cloves"};
            String[] ranks = {"2 of ", "3 of ", "4 of ", "5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ", "Queen of ", "King of ", "Ace of "};

            // initializing new arrays, one for all of the ranks, and one for all of the suits
            String[] deckRanks = new String[52];
            String[] deckSuits = new String[52];

                for (int i = 0; i < deckRanks.length; i++) { // loop for ranks array is reached
                    // creating all of the possible ranks in a deck
                    deckRanks[i] = ranks[i % 13];
                }

                for (int i = 0; i < deckSuits.length; i++) { // loop for suits array is reached
                    // creating all of the possible suits in a deck
                    deckSuits[i] = suits[i / 13];
                }
// end of deck of cards

// poker game
        int counter = 1; // initializing counter variable to count the # of rounds

        System.out.println("The game will start now ...");
        System.out.println();
        // printing that the game is starting

            do { // main do-while loop, executing each round of the poker game, the first biggest decision
                // printing the round #
                System.out.println("**************************************************************************************************************");
                System.out.println("Round #" + counter);
                System.out.println();

                // generating the first random card of the user's hand
                int index1 = generator.nextInt(52);
                String randomCard1 = deckRanks[index1] + deckSuits[index1];

                // generating the second random card of the user's hand
                int index2 = generator.nextInt(52);
                String randomCard2 = deckRanks[index2] + deckSuits[index2];

                // generating the first random card of the opponent's hand
                int index3 = generator.nextInt(52);
                String randomCard3 = deckRanks[index3] + deckSuits[index3];

                // generating the second random card of the opponent's hand
                int index4 = generator.nextInt(52);
                String randomCard4 = deckRanks[index4] + deckSuits[index4];

                // generating the first flop card
                int index5 = generator.nextInt(52);
                String flopCard1 = deckRanks[index5] + deckSuits[index5];

                // generating the second flop card
                int index6 = generator.nextInt(52);
                String flopCard2 = deckRanks[index6] + deckSuits[index6];

                // generating the third flop card
                int index7 = generator.nextInt(52);
                String flopCard3 = deckRanks[index7] + deckSuits[index7];

                // generating the turn card
                int index8 = generator.nextInt(52);
                String turnCard = deckRanks[index8] + deckSuits[index8];

                // generating the river card
                int index9 = generator.nextInt(52);
                String riverCard = deckRanks[index9] + deckSuits[index9];

                // printing the user's hand
                System.out.println("Your Hand:");
                System.out.println("Card 1: " + randomCard1);
                System.out.println("Card 2: " + randomCard2);
                System.out.println();

                int pot = 0; // initializing variable for the winning pot to 0

                // initializing variables for # of moves of user and opponent
                int playerMoves = 5;
                int oppMoves = 5;

                int aroundTable = 1; // initializing variable that would determine showing the flop, turn, and river cards when both players check around the table

                //boolean gameOver = false; // initializing variable for game over

                    while (playerMoves != 0 || oppMoves != 0) { // loop while # of moves doesn't equal to 0 for either user or opponent, the second biggest decision
                        // asking the user for their move, user goes first every round
                        System.out.println("Your move (Check, Bet, or Fold):");
                        String playerMove = input.next();
                        System.out.println();

                            if (playerMove.equals("Check")) { // if user Checks
                                // printing the user's move
                                System.out.println("You Checked for your move.");
                                System.out.println("Waiting for opponent's move ...");
                                System.out.println();
                                System.out.println();

                                int oppRandomMove1 = generator.nextInt(2) + 1; // initializing variable for random move by the opponent

                                    if (oppRandomMove1 == 1) { // if opponent Checks
                                        // printing the opponent's move
                                        System.out.println("Vineet has Checked as well.");
                                        System.out.println();
                                        System.out.println();

                                            if (aroundTable == 1) {
                                                // printing the flop cards and showing the user's hand again
                                                System.out.println("Flop Card 1: " + flopCard1);
                                                System.out.println("Flop Card 2: " + flopCard2);
                                                System.out.println("Flop Card 3: " + flopCard3);
                                                System.out.println();
                                                System.out.println("Your Hand:");
                                                System.out.println("Card 1: " + randomCard1);
                                                System.out.println("Card 2: " + randomCard2);
                                                System.out.println();
                                            }

                                            else if (aroundTable == 2) {
                                                System.out.println("Flop Card 1: " + flopCard1);
                                                System.out.println("Flop Card 2: " + flopCard2);
                                                System.out.println("Flop Card 3: " + flopCard3);
                                                System.out.println("Turn Card: " + turnCard);
                                                System.out.println();
                                                System.out.println("Your Hand:");
                                                System.out.println("Card 1: " + randomCard1);
                                                System.out.println("Card 2: " + randomCard2);
                                                System.out.println();
                                            }

                                            else if (aroundTable == 3) {
                                                System.out.println("Flop Card 1: " + flopCard1);
                                                System.out.println("Flop Card 2: " + flopCard2);
                                                System.out.println("Flop Card 3: " + flopCard3);
                                                System.out.println("Turn Card: " + turnCard);
                                                System.out.println("River Card: " + riverCard);
                                                System.out.println();
                                                System.out.println("Your Hand:");
                                                System.out.println("Card 1: " + randomCard1);
                                                System.out.println("Card 2: " + randomCard2);
                                                System.out.println();
                                            }

                                            else if (aroundTable == 4) {
                                                System.out.println("Time to show your hands ...");
                                                System.out.println();
                                                System.out.println("Flop Card 1: " + flopCard1);
                                                System.out.println("Flop Card 2: " + flopCard2);
                                                System.out.println("Flop Card 3: " + flopCard3);
                                                System.out.println("Turn Card: " + turnCard);
                                                System.out.println("River Card: " + riverCard);
                                                System.out.println();
                                                System.out.println("Your Hand:");
                                                System.out.println("Card 1: " + randomCard1);
                                                System.out.println("Card 2: " + randomCard2);
                                                System.out.println();
                                                System.out.println("Vineet's Hand:");
                                                System.out.println("Card 1: " + randomCard3);
                                                System.out.println("Card 2: " + randomCard4);
                                                System.out.println();

                                                handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method

                                                break; // breaking the loop
                                            }
                                        aroundTable = aroundTable + 1;
                                    }

                                    else if (oppRandomMove1 == 2) { // if opponent Bets
                                    // this part of the loop will run else if the random generator move is 2, the opponent will Bet

                                        int randomBet = generator.nextInt(balanceOpp) + 1; // random opponent bet

                                            if (randomBet == balanceOpp) { // if opponent bet is All-In
                                                // printing All-In
                                                System.out.println("Vineet has went All-In!");
                                                System.out.println();

                                                // subtracting the bet from the opponent's balance, and adding it to the winning pot
                                                balanceOpp = balanceOpp - randomBet;
                                                pot = pot + randomBet;

                                                // printing the updated winning pot
                                                System.out.println("The winning pot is: $" + pot);
                                                System.out.println();
                                            }

                                            else { // else opponent bets anything else
                                                // subtracting the bet from the opponent's balance, and adding it to the winning pot
                                                balanceOpp = balanceOpp - randomBet;
                                                pot = pot + randomBet;

                                                // printing the updated winning pot
                                                System.out.println("The winning pot is: $" + pot);
                                                System.out.println();
                                            }

                                        System.out.println("Vineet has betted $" + randomBet + " on his move.");
                                        System.out.println("Vineet's Balance: $" + balanceOpp);
                                        System.out.println();
                                        System.out.println("Waiting for your move ...");
                                        System.out.println();
                                        System.out.println();

                                        // asking the user for their move
                                        System.out.println("Your Balance: $" + balance);
                                        System.out.println("Your move (Call or Fold):");
                                        playerMove = input.next();
                                        System.out.println();

                                            if (playerMove.equals("Call")) { // if user Calls
                                                // printing user's move
                                                System.out.println("You have called $" + randomBet + ".");

                                                // subtracting the bet from the user's balance, and adding it to the winning pot
                                                balance = balance - randomBet;
                                                pot = pot + randomBet;

                                                // printing the updated winning pot
                                                System.out.println("The winning pot is: $" + pot);
                                                System.out.println();
                                                System.out.println();

                                                    if (balance == 0) { // if user has called All-In
                                                        if (aroundTable == 1) {
                                                            System.out.println("Time to show hands ...");
                                                            System.out.println();
                                                            System.out.println("Flop Card 1: " + flopCard1);
                                                            System.out.println("Flop Card 2: " + flopCard2);
                                                            System.out.println("Flop Card 3: " + flopCard3);
                                                            System.out.println("Turn Card: " + turnCard);
                                                            System.out.println("River Card: " + riverCard);
                                                            System.out.println();
                                                            System.out.println("Your Hand:");
                                                            System.out.println("Card 1: " + randomCard1);
                                                            System.out.println("Card 2: " + randomCard2);
                                                            System.out.println();
                                                            System.out.println("Vineet's Hand: ");
                                                            System.out.println("Card 1: " + randomCard3);
                                                            System.out.println("Card 2: " + randomCard4);
                                                            System.out.println();

                                                            handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method

                                                           // gameOver = true;

                                                            break;
                                                        }

                                                        else if (aroundTable == 2) {
                                                            System.out.println("Time to show hands ...");
                                                            System.out.println();
                                                            System.out.println("Flop Card 1: " + flopCard1);
                                                            System.out.println("Flop Card 2: " + flopCard2);
                                                            System.out.println("Flop Card 3: " + flopCard3);
                                                            System.out.println("Turn Card: " + turnCard);
                                                            System.out.println("River Card: " + riverCard);
                                                            System.out.println();
                                                            System.out.println("Your Hand:");
                                                            System.out.println("Card 1: " + randomCard1);
                                                            System.out.println("Card 2: " + randomCard2);
                                                            System.out.println();
                                                            System.out.println("Vineet's Hand: ");
                                                            System.out.println("Card 1: " + randomCard3);
                                                            System.out.println("Card 2: " + randomCard4);
                                                            System.out.println();

                                                            handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method

                                                            //gameOver = true; // game over

                                                            break; // breaking the loop
                                                        }

                                                        else if (aroundTable == 3) {
                                                            System.out.println("Time to show hands ...");
                                                            System.out.println();
                                                            System.out.println("Flop Card 1: " + flopCard1);
                                                            System.out.println("Flop Card 2: " + flopCard2);
                                                            System.out.println("Flop Card 3: " + flopCard3);
                                                            System.out.println("Turn Card: " + turnCard);
                                                            System.out.println("River Card: " + riverCard);
                                                            System.out.println();
                                                            System.out.println("Your Hand:");
                                                            System.out.println("Card 1: " + randomCard1);
                                                            System.out.println("Card 2: " + randomCard2);
                                                            System.out.println();
                                                            System.out.println("Vineet's Hand: ");
                                                            System.out.println("Card 1: " + randomCard3);
                                                            System.out.println("Card 2: " + randomCard4);
                                                            System.out.println();

                                                            handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method

                                                            //gameOver = true; // game over

                                                            break; // breaking the loop
                                                        }

                                                        else if (aroundTable == 4) {
                                                            System.out.println("Time to show your hands ...");
                                                            System.out.println();
                                                            System.out.println("Flop Card 1: " + flopCard1);
                                                            System.out.println("Flop Card 2: " + flopCard2);
                                                            System.out.println("Flop Card 3: " + flopCard3);
                                                            System.out.println("Turn Card: " + turnCard);
                                                            System.out.println("River Card: " + riverCard);
                                                            System.out.println();
                                                            System.out.println("Your Hand:");
                                                            System.out.println("Card 1: " + randomCard1);
                                                            System.out.println("Card 2: " + randomCard2);
                                                            System.out.println();
                                                            System.out.println("Vineet's Hand:");
                                                            System.out.println("Card 1: " + randomCard3);
                                                            System.out.println("Card 2: " + randomCard4);
                                                            System.out.println();
        
                                                            handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method
        
                                                            //gameOver = true; // game over

                                                            break; // breaking the loop
                                                        } 
                                                    }  
                                            }

                                            else if (playerMove.equals("Fold")) { // else if user Folds
                                                // adding winning pot to opponent's balance
                                                balanceOpp = balanceOpp + pot;

                                                // printing user's move, the winning pot that the opponent has won, and the opponent's updated balance
                                                System.out.println("You have Folded on your move.");
                                                System.out.println();
                                                System.out.println("Vineet has won the round!");
                                                System.out.println("Vineet wins the winning pot of $" + pot);
                                                System.out.println("Vineet's new balance: $" + balanceOpp);
                                                System.out.println();

                                                break; // breaking the loop
                                            }

                                            else { // else user enters anything else
                                                System.out.println("Invalid entry ...");
                                                System.out.println();
                                            }
                                    }
                            }

                            else if (playerMove.equals("Bet")) { // else if user Bets
                                // asking user how much they would like to bet
                                System.out.println("Your balance: $" + balance);
                                System.out.println("How much would you like to bet (1 - All-In)?");
                                int bet = input.nextInt();
                                System.out.println();

                                    if (bet < balance && bet > 0) { // if bet entered is in the range, 1-Balance
                                        // subtracting the bet from the balance and adding it to the winning pot
                                        balance = balance - bet;
                                        pot = pot + bet;

                                        // printing the user's move and the winning pot
                                        System.out.println("The winning pot is: $" + pot);
                                        System.out.println("You have Betted $" + bet + " on your move.");
                                        System.out.println();
                                        System.out.println("Waiting for opponent's move ...");
                                        System.out.println();
                                        System.out.println();
                                    }

                                    else if (bet == balance) { // else if bet equals to current user balance
                                        System.out.println("You have went All-In!"); // printing that the user has went All-In

                                        // subtracting the bet from the balance and adding it to the winning pot
                                        balance = balance - bet;
                                        pot = pot + bet;

                                        // printing the user's move
                                        System.out.println("The winning pot is: $" + pot);
                                        System.out.println("You have Betted $" + bet + " on your move.");
                                        System.out.println();
                                        System.out.println("Waiting for opponent's move ...");
                                        System.out.println();
                                        System.out.println();
                                    }

                                    else {
                                        System.out.println("Invalid entry ...");
                                        System.out.println();
                                    }

                                int oppRandomMove2 = generator.nextInt(2) + 1;
                                // initializing the variable for the opp random move

                                    if (oppRandomMove2 == 1) { // if opponent Calls

                                        // subtracting the bet from the opponent's balance and adding it to the winning pot
                                        balanceOpp = balanceOpp - bet; 
                                        pot = pot + bet;

                                        // printing the opponent's balance and the opponent's balance
                                        System.out.println("Vineet has called your bet.");
                                        System.out.println("Vineet's balance: $" + balanceOpp);
                                        System.out.println("The winning pot is: " + pot);
                                        System.out.println();
                                        System.out.println();

                                            if (balanceOpp == 0) { // if comp has called All-In
                                                if (aroundTable == 1) { // both players bet All-In around the first time
                                                    System.out.println("Time to show your hands ...");
                                                    System.out.println();
                                                    System.out.println("Flop Card 1: " + flopCard1);
                                                    System.out.println("Flop Card 2: " + flopCard2);
                                                    System.out.println("Flop Card 3: " + flopCard3);
                                                    System.out.println("Turn Card: " + turnCard);
                                                    System.out.println("River Card: " + riverCard);
                                                    System.out.println();
                                                    System.out.println("Your Hand:");
                                                    System.out.println("Card 1: " + randomCard1);
                                                    System.out.println("Card 2: " + randomCard2);
                                                    System.out.println();
                                                    System.out.println("Vineet's Hand:");
                                                    System.out.println("Card 1: " + randomCard3);
                                                    System.out.println("Card 2: " + randomCard4);
                                                    System.out.println();
    
                                                    handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method
    
                                                    //gameOver = true; // game over

                                                    break; // breaking the loop
                                                }
    
                                                else if (aroundTable == 2) { // both players bet All-In around the second time
                                                    System.out.println("Time to show your hands ...");
                                                    System.out.println();
                                                    System.out.println("Flop Card 1: " + flopCard1);
                                                    System.out.println("Flop Card 2: " + flopCard2);
                                                    System.out.println("Flop Card 3: " + flopCard3);
                                                    System.out.println("Turn Card: " + turnCard);
                                                    System.out.println("River Card: " + riverCard);
                                                    System.out.println();
                                                    System.out.println("Your Hand:");
                                                    System.out.println("Card 1: " + randomCard1);
                                                    System.out.println("Card 2: " + randomCard2);
                                                    System.out.println();
                                                    System.out.println("Vineet's Hand:");
                                                    System.out.println("Card 1: " + randomCard3);
                                                    System.out.println("Card 2: " + randomCard4);
                                                    System.out.println();
    
                                                    handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method
    
                                                    //gameOver = true; // game over

                                                    break; // breaking the loop
                                                }
    
                                                else if (aroundTable == 3) {
                                                    System.out.println("Time to show your hands ..."); // both players bet All-In around the third time
                                                    System.out.println();
                                                    System.out.println("Flop Card 1: " + flopCard1);
                                                    System.out.println("Flop Card 2: " + flopCard2);
                                                    System.out.println("Flop Card 3: " + flopCard3);
                                                    System.out.println("Turn Card: " + turnCard);
                                                    System.out.println("River Card: " + riverCard);
                                                    System.out.println();
                                                    System.out.println("Your Hand:");
                                                    System.out.println("Card 1: " + randomCard1);
                                                    System.out.println("Card 2: " + randomCard2);
                                                    System.out.println();
                                                    System.out.println("Vineet's Hand:");
                                                    System.out.println("Card 1: " + randomCard3);
                                                    System.out.println("Card 2: " + randomCard4);
                                                    System.out.println();
    
                                                    handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method
    
                                                   // gameOver = true; // game over

                                                    break; // breaking the loop
                                                }
    
                                                else if (aroundTable == 4) { // both players bet All-In around the fourth time
                                                    System.out.println("Time to show your hands ...");
                                                    System.out.println();
                                                    System.out.println("Flop Card 1: " + flopCard1);
                                                    System.out.println("Flop Card 2: " + flopCard2);
                                                    System.out.println("Flop Card 3: " + flopCard3);
                                                    System.out.println("Turn Card: " + turnCard);
                                                    System.out.println("River Card: " + riverCard);
                                                    System.out.println();
                                                    System.out.println("Your Hand:");
                                                    System.out.println("Card 1: " + randomCard1);
                                                    System.out.println("Card 2: " + randomCard2);
                                                    System.out.println();
                                                    System.out.println("Vineet's Hand:");
                                                    System.out.println("Card 1: " + randomCard3);
                                                    System.out.println("Card 2: " + randomCard4);
                                                    System.out.println();
    
                                                    handRankings(deckRanks, deckSuits, index1, index2, index3, index4, index5, index6, index7, index8, index9, balance, balanceOpp, pot); // calling method
    
                                                    //gameOver = true; // game over

                                                    break; // breaking the loop
                                                }
                                            }
                                    }

                                    else if (oppRandomMove2 == 2) { // else if opponent Folds
                                        // adding winning pot to user's balance
                                        balance = balance + pot;

                                        // printing opponent's move, the winning pot that the user has won, and the user's updated balance
                                        System.out.println("Vineet has Folded for his move.");
                                        System.out.println();
                                        System.out.println("You have won the round!");
                                        System.out.println("You wins the winning pot of $" + pot);
                                        System.out.println("Your new balance: $" + balance);
                                        System.out.println();

                                        break; // breaking the loop
                                    }
                            }

                            else if (playerMove.equals("Fold")) { // else if user Folds
                                // adding winning pot to opponent's balance
                                balanceOpp = balanceOpp + pot;

                                // printing user's move, the winning pot that the opponent has won, and the opponent's updated balance
                                System.out.println("You have Folded on your move.");
                                System.out.println();
                                System.out.println("Vineet has won the round!");
                                System.out.println("Vineet wins the winning pot of $" + pot);
                                System.out.println("Vineet's new balance: $" + balanceOpp);
                                System.out.println();

                                break; // breaking the loop
                            }

                            else { // else if user enters anything else
                                System.out.println("Invalid entry ...");
                                System.out.println();
                            }

                            /*if (gameOver) { // if gameOver 
                                break; // breaking the loop
                            }*/
                    }

                    /*if (gameOver) { // if gameOver
                        break; // breaking the loop
                    } 

                    if (balance == 0 || balanceOpp == 0) { // if either the user's balance equals 0 or the opponent's balance eaulas 0
                        break; // breaking the loop
                    }*/

                counter = counter + 1; // adding the round #
            }
            while (balance != 0 || balanceOpp != 0);
            // do this loop while condition doesn't match
// end of poker game

// conclusion
        System.out.println("Game is over.");
        System.out.println("Thank you for playing the game!");
        System.out.println();
// end of conclusion
        input.close(); // scanner input close
    }

    public static void handRankings(String deckRanks[], String deckSuits[], int index1, int index2, int index3, int index4, int index5, int index6, int index7, int index8, int index9, int balance, int balanceOpp, int pot) { // start of handRankings method
// arranging both hand rankings
        // array for the ranks of all of user's seven cards
        String[] userRanks = new String[7];

        userRanks[0] = deckRanks[index1];
        userRanks[1] = deckRanks[index2];
        userRanks[2] = deckRanks[index5];
        userRanks[3] = deckRanks[index6];
        userRanks[4] = deckRanks[index7];
        userRanks[5] = deckRanks[index8];
        userRanks[6] = deckRanks[index9];

        // array for the suits of all of user's seven cards
        String[] userSuits = new String[7];

        userSuits[0] = deckSuits[index1];
        userSuits[1] = deckSuits[index2];
        userSuits[2] = deckSuits[index5];
        userSuits[3] = deckSuits[index6];
        userSuits[4] = deckSuits[index7];
        userSuits[5] = deckSuits[index8];
        userSuits[6] = deckSuits[index9];

        // array for the ranks of all of opponent's seven cards
        String[] oppRanks = new String[7];

        oppRanks[0] = deckRanks[index3];
        oppRanks[1] = deckRanks[index4];
        oppRanks[2] = deckRanks[index5];
        oppRanks[3] = deckRanks[index6];
        oppRanks[4] = deckRanks[index7];
        oppRanks[5] = deckRanks[index8];
        oppRanks[6] = deckRanks[index9];

        // array for the suits of all of opponent's seven cards
        String[] oppSuits = new String[7];

        oppSuits[0] = deckSuits[index3];
        oppSuits[1] = deckSuits[index4];
        oppSuits[2] = deckSuits[index5];
        oppSuits[3] = deckSuits[index6];
        oppSuits[4] = deckSuits[index7];
        oppSuits[5] = deckSuits[index8];
        oppSuits[6] = deckSuits[index9];
// end of arranging hand rankings

// values
        // initializing arrays to find the values, one for user ranks, and one for opponent ranks
        int[] userValue = new int[7];
        int[] oppValue = new int[7];

            for (int i = 0; i < userRanks.length; i++) { // loop for user ranks array length is reached
                if (userRanks[i].equals("2 of ")) { // if the rank of the card is a 2
                    userValue[i] = 1; // value of the card is 1
                }

                else if (userRanks[i].equals("3 of ")) { // if the rank of the card is a 3
                    userValue[i] = 2; // value of the card is 2
                }

                else if (userRanks[i].equals("4 of ")) { // if the rank of the card is a 4
                    userValue[i] = 3; // value of the card is 3
                }

                else if (userRanks[i].equals("5 of ")) { // if the rank of the card is a 5
                    userValue[i] = 4; // value of the card is 4
                }

                else if (userRanks[i].equals("6 of ")) { // if the rank of the card is a 6
                    userValue[i] = 5; // value of the card is 5
                }

                else if (userRanks[i].equals("7 of ")) { // if the rank of the card is a 7
                    userValue[i] = 6; // value of the card is 6
                }

                else if (userRanks[i].equals("8 of ")) { // if the rank of the card is a 8
                    userValue[i] = 7; // value of the card is 7
                }

                else if (userRanks[i].equals("9 of ")) { // if the rank of the card is a 9
                    userValue[i] = 8; // value of the card is 8
                }

                else if (userRanks[i].equals("10 of ")) { // if the rank of the card is a 10
                    userValue[i] = 9; // value of the card is 9
                }

                else if (userRanks[i].equals("Jack of ")) { // if the rank of the card is a Jack
                    userValue[i] = 10; // value of the card is 10
                }

                else if (userRanks[i].equals("Queen of ")) { // if the rank of the card is a Queen
                    userValue[i] = 11; // value of the card is 11
                }

                else if (userRanks[i].equals("King of ")) { // if the rank of the card is a King
                    userValue[i] = 12; // value of the card is 12
                }

                else if (userRanks[i].equals("Ace of ")) { // if the rank of the card is am Ace
                    userValue[i] = 13; // value of the card is 13
                }
            }

            for (int i = 0; i < oppRanks.length; i++) { // loop for opponent ranks array length is reached
                if (oppRanks[i].equals("2 of ")) { // if the rank of the card is a 2
                    oppValue[i] = 1; // value of the card is 1
                }

                else if (oppRanks[i].equals("3 of ")) { // if the rank of the card is a 3
                    oppValue[i] = 2; // value of the card is 2
                }

                else if (oppRanks[i].equals("4 of ")) { // if the rank of the card is a 4
                    oppValue[i] = 3; // value of the card is 3
                }

                else if (oppRanks[i].equals("5 of ")) { // if the rank of the card is a 5
                    oppValue[i] = 4; // value of the card is 4 
                }

                else if (oppRanks[i].equals("6 of ")) { // if the rank of the card is a 6
                    oppValue[i] = 5; // value of the card is 5
                }

                else if (oppRanks[i].equals("7 of ")) { // if the rank of the card is a 7
                    oppValue[i] = 6; // value of the card is 6
                }

                else if (oppRanks[i].equals("8 of ")) { // if the rank of the card is a 8
                    oppValue[i] = 7; // value of the card is 7
                }

                else if (oppRanks[i].equals("9 of ")) { // if the rank of the card is a 9
                    oppValue[i] = 8; // value of the card is 8
                }

                else if (oppRanks[i].equals("10 of ")) { // if the rank of the card is a 10
                    oppValue[i] = 9; // value of the card is 9
                }

                else if (oppRanks[i].equals("Jack of ")) { // if the rank of the card is a Jack
                    oppValue[i] = 10; // value of the card is 10
                }

                else if (oppRanks[i].equals("Queen of ")) { // if the rank of the card is a Queen
                    oppValue[i] = 11; // value of the card is 11
                }

                else if (oppRanks[i].equals("King of ")) { // if the rank of the card is a King
                    oppValue[i] = 12; // value of the card is 12
                }

                else if (oppRanks[i].equals("Ace of ")) { // if the rank of the card is an Ace
                    oppValue[i] = 13; // value of the card is 13
                }
            }
// end of values

// high card
        // initializing variables to count highCard
        int userHighCard = 0;
        int oppHighCard = 0;

        for (int i = 0; i < userValue.length; i++) { // loop for user values array length is reached
            if (userValue[i] > userHighCard) { // if card value is greater than the variable
                userHighCard = userValue[i]; // set userHighCard equal to the value of that card
            }
        }

        for (int i = 0; i < oppValue.length; i++) { // loop for opponent values array length is reached
            if (oppValue[i] > oppHighCard) { // if card value is greater than the variable
                oppHighCard = oppValue[i]; // set oppHighCard equal to the value of that card
            }
        }
// end of high card

// one pair
        // initializing variable to count one pair
        int userPairCounter = 0;
        int oppPairCounter = 0;
        int userOnePair = 0;
        int oppOnePair = 0;

            for (int i = 1; i < userRanks.length; i++) { // loop for user ranks array length is reached
                if (userRanks[i - 1] == userRanks[i]) { // if a card is equal to another card
                    userPairCounter = userPairCounter + 1; // when pair is found add it to the counter
                }
            }

            if (userPairCounter == 1) { // if one pair is found
                userOnePair = userOnePair + 1; // add 1 to the hand ranking score
            }

            else { // if one pair is not found
                userOnePair = userOnePair + 0; // add 0 to the hand ranking score
            }

            for (int i = 1; i < oppRanks.length; i++) { // loop for opponent ranks array length is reached
                if (oppRanks[i - 1] == oppRanks[i]) { // if a card is equal to another card
                    oppPairCounter = oppPairCounter + 1; // when pair is found add it to the counter
                }
            }

            if (oppPairCounter == 1) { // if one pair is found
                oppOnePair = oppOnePair + 1; // add 1 to the hand ranking score
            }

            else { // if one pair is not found
                oppOnePair = oppOnePair + 0; // add 0 to the hand ranking score
            }
// end of one pair

// two pair
        // initializing variables to count two pair
        int userTwoPairCounter = 0;
        int oppTwoPairCounter = 0;
        int userTwoPair = 0;
        int oppTwoPair = 0;

            for (int i = 1; i < userRanks.length; i++) { // loop for user ranks array length is reached
                if (userRanks[i - 1] == userRanks[i]) { // if a card is equal to another card
                    userTwoPairCounter = userTwoPairCounter + 1; // when pairs are found add it to the counter
                }
            }

            if (userTwoPairCounter == 2) { // if two pairs are found
                userTwoPair = userTwoPair + 1; // add 1 to the hand ranking score
            }

            else { // else two pairs are not found
                userTwoPair = userTwoPair + 0; // add 0 to the hand ranking score
            }

            for (int i = 1; i < oppRanks.length; i++) { // loop for opponent ranks array length is reached
                if (oppRanks[i - 1] == oppRanks[i]) { // if a card is equal to another card
                    oppTwoPairCounter = oppTwoPairCounter + 1; // when pairs are found add it to the counter
                }
            }

            if (oppTwoPairCounter == 2) { // if two pairs are found
                oppTwoPair = oppTwoPair + 1; // add 1 to the hand ranking score
            }

            else { // else two pairs are not found
                oppTwoPair = oppTwoPair + 0; // add 0 to the hand ranking score
            }
// end of two pair

// three of a kind
        // initializing variables to count three of a kind
        int userThreePairCounter = 0; 
        int oppThreePairCounter = 0;
        int userThreeOfAKind = 0;
        int oppThreeOfAKind = 0;

            for (int i = 1; i < userRanks.length; i++) { // loop for user ranks array length is reached
                if (userRanks[i - 1] == userRanks[i]) { // if a card is equal to another card
                    userThreePairCounter = userThreePairCounter + 1; // when three of a kind is found add it to the counter
                }
            }

            if (userThreePairCounter == 3) { // if three of a kind is found
                userThreeOfAKind = userThreeOfAKind + 1; // add 1 to the hand ranking score
            }

            else { // else three of a kind is not found
                userThreeOfAKind = userThreeOfAKind + 0; // add 0 to the hand ranking score
            }

            for (int i = 1; i < oppRanks.length; i++) { // loop for opponent ranks array length is reached
                if (oppRanks[i - 1] == oppRanks[i]) { // if a card is equal to another card
                    oppThreePairCounter = oppThreePairCounter + 1; // when three of a kind is found add it to the counter
                }
            }

            if (oppThreePairCounter == 3) { // if three of a kind is found
                oppThreeOfAKind = oppThreeOfAKind + 1; // add 1 to the hand ranking score
            }

            else { // else three of a kind is not found
                oppThreeOfAKind = oppThreeOfAKind + 0; // add 0 to the hand ranking score
            }
// end of three of a kind

// straight

// end of straight

// flush
        // initializing variables to count flush
        int userFlushCounter = 0;
        int oppFlushCounter = 0;
        int userFlush = 0;
        int oppFlush = 0;

            for (int i = 1; i < userSuits.length; i++) { // loop for user suits array length is reached
                if (userSuits[i - 1] == userSuits[i]) { // if a suit is equal to another suit
                    userFlushCounter = userFlushCounter + 1; // add for every matching suit found to the counter
                }
            }

            if (userFlushCounter == 5) { // if flush is found
                userFlush = userFlush + 1; // add 1 to the hand ranking score
            }

            else { // else flush is not found
                userFlush = userFlush + 0; // add 0 to the hand ranking score
            }

            for (int i = 1; i < oppSuits.length; i++) { // loop for opponent suits array length is reached
                if (oppSuits[i - 1] == oppSuits[i]) { // if a suit is equal to another suit
                    oppFlushCounter = oppFlushCounter + 1; // add for every matching suit found to the counter
                }
            }

            if (oppFlushCounter == 5) { // if flush is found
                oppFlush = oppFlush + 1; // add 1 to the hand ranking score
            }

            else { // else flush is not found
                oppFlush = oppFlush + 0; // add 0 to the hand ranking score
            }
// end of flush

// full house
        // initializing variables to count full house
        int userFullHouseCounter = 0; 
        int oppFullHouseCounter = 0;
        int userFullHouse = 0;
        int oppFullHouse = 0;

            for (int i = 1; i < userRanks.length; i++) { // loop for user ranks array length is reached
                if (userRanks[i - 1] == userRanks[i]) { // if a card is equal to another card
                    userFullHouseCounter = userFullHouseCounter + 1; // add to the counter, when match found
                }
            }

            if (userFullHouseCounter == 3) { // if full house is found
                userFullHouse = userFullHouse + 1; // add 1 to the hand ranking score
            }

            else { // else full house is not found
                userFullHouse = userFullHouse + 0; // add 0 to the hand ranking score
            }

            for (int i = 1; i < oppRanks.length; i++) { // loop for opponent ranks array length is reached
                if (oppRanks[i - 1] == oppRanks[i]) { // if a card is equal to another card
                    oppFullHouseCounter = oppFullHouseCounter + 1; // add to the counter, when match found
                }
            }

            if (oppFlushCounter == 3) { // if full house is found 
                oppFullHouse = oppFullHouse + 1; // add 1 to the hand ranking score
            }

            else { // else full house is not found
                oppFullHouse = oppFullHouse + 0; // add 0 to the hand ranking score
            }
// end of full house

// four of a kind
        // initializing variables to count four of a kind
        int userFourOfAKind = 0;
        int oppFourOfAKind = 0;

            if (userRanks[0] == userRanks[1] && userRanks[2] == userRanks[3]) { // if four of a kind is found
                userFourOfAKind = userFourOfAKind + 1; // add 1 to the hand ranking score
            }

            else  { // else four of a kind is not found
                userFourOfAKind = userFourOfAKind + 0; // add 0 to the hand ranking score
            }

            if (oppRanks[0] == oppRanks[1] && oppRanks[2] == oppRanks[3]) { // if four of a kind is found
                oppFourOfAKind = oppFourOfAKind + 1; // add 1 to the hand ranking score
            }

            else { // else four of a kind is not found
                oppFourOfAKind = oppFourOfAKind + 0; // add 0 to the hand ranking score
            }
// end of four of a kind

// straight flush

// end of straight flush

// royal flush

// enf of royal flush

// ranking the hands
        // initializing variables to compare hand rankings
        int userHandRanking = 0;
        int oppHandRanking = 0;

            if (userOnePair == 1) { // if user has one pair
                System.out.println("You have a one pair!");
                System.out.println();

                userHandRanking = userHandRanking + 1; // add one to user's hand ranking score
            }

            else if (userTwoPair == 1) { // else if user has two pair
                System.out.println("You have a two pair!");
                System.out.println();

                userHandRanking = userHandRanking + 2; // add two to user's hand ranking score
            }

            else if (userThreeOfAKind == 1) { // else if user has a three of a kind
                System.out.println("You have a three of a kind!");
                System.out.println();

                userHandRanking = userHandRanking + 3; // add three to user's hand ranking score
            }

            else if (userFlush == 1) { // else if user has a flush
                System.out.println("You have a flush!");
                System.out.println();

                userHandRanking = userHandRanking + 5; // add five to user's hand ranking score
            }

            else if (userFourOfAKind == 1) { // else if user has a four of a kind
                System.out.println("You have a four of a kind!");
                System.out.println();

                userHandRanking = userHandRanking + 7; // add seven to user's hand ranking score
            }

            else { // else user only has a high card
                System.out.println("You have a high card!");
                System.out.println();

                userHandRanking = userHandRanking + 0; // add zero to user's hand ranking score
            }

            if (oppOnePair == 1) { // if user has one pair
                System.out.println("Vineet has a one pair!");
                System.out.println();

                oppHandRanking = oppHandRanking + 1; // add one to user's hand ranking score
            }

            else if (oppTwoPair == 1) { // else if user has two pair
                System.out.println("Vineet has a two pair!");
                System.out.println();

                oppHandRanking = oppHandRanking + 2; // add two to user's hand ranking score
            }

            else if (oppThreeOfAKind == 1) { // else if user has a three of a kind
                System.out.println("Vineet has a three of a kind!");
                System.out.println();

                oppHandRanking = oppHandRanking + 3; // add three to user's hand ranking score
            }

            else if (oppFlush == 1) { // else if user has a flush
                System.out.println("Vineet has a flush!");
                System.out.println();

                oppHandRanking = oppHandRanking + 5; // add five to user's hand ranking score
            }

            else if (oppFourOfAKind == 1) { // else if user has a four of a kind
                System.out.println("Vineet has a four of a kind!");
                System.out.println();

                oppHandRanking = oppHandRanking + 7; // add seven to user's hand ranking score
            }

            else { // else user only has a high card
                System.out.println("Vineet has a high card!");
                System.out.println();

                oppHandRanking = oppHandRanking + 0; // add zero to user's hand ranking score
            }

            if (userHandRanking > oppHandRanking) { // if user has a higher hand ranking than the opponent
                System.out.println("You have the higher hand ranking!");
                System.out.println("You have won the round! Well Played!");
                System.out.println();
            }

            else if (userHandRanking < oppHandRanking) { // else if opponent has a higher hand ranking than the user
                System.out.println("Vineet has the higher hand ranking!");
                System.out.println("Vineet has won the round!");
                System.out.println("Good try! Almost had him!");
                System.out.println();
            }

            else { // else both user and opponent have the same hand ranking
                if (userHighCard > oppHighCard) { // if user has a higher hand ranking
                    balance = balance + pot;

                    System.out.println("You have the higher hand card ranking!");
                    System.out.println("You win the round!");
                    System.out.println();
                    System.out.println("You win the winning pot of $" + pot);
                    System.out.println("Your balance: " + balance);
                    System.out.println();
                }

                else if (userHighCard < oppHighCard) {
                    balanceOpp = balanceOpp + pot;

                    System.out.println("Vineet has the higher hand ranking!");
                    System.out.println("Vineet has won the round!");
                    System.out.println();
                    System.out.println("Vineet wins the winning pot of $" + pot);
                    System.out.println("Vineet's balance: " + balanceOpp);
                    System.out.println();
                }
            }
// end of ranking the hands
    }
}