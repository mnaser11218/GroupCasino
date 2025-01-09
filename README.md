# 🎮 Arcade Simulation - Java Game Simulation

## 📜 Overview
Welcome to the **Arcade Simulation**! This project features a variety of classic casino games built using Java. The games included are:

- **BeatTheDealer**: A card game where you try to beat the dealer by having a higher card value.
- **BlackJack**: A popular casino game where the objective is to reach a hand value of 21 or as close to it as possible without going over.
- **Keno**: A lottery-style game where you pick numbers, and the game draws a set of random numbers to determine the winners.
- **Rouletto**: A simplified version of the classic casino game Roulette, where players bet on numbers, colors, or ranges.
- **Slots**: A classic slot machine game where players spin the reels and hope to match symbols for a prize.
- **NumberGuess**: A number guessing game where players try to guess a randomly selected number within a given range.

![Casino Arcade](./casino.gif)

---

## 🌟 Features

- **Command Line Interface (CLI)** for interacting with each game.
- Randomized results to ensure that each game is different every time it's played.
- Multiple rounds of play for each game with a basic gambling mechanic.
- Basic betting system where users can choose the amount they want to bet in some games.

---

## 📚 Table of Contents

1. [Installation Instructions](#installation-instructions)
2. [How to Play](#how-to-play)
3. [Games Overview](#games-overview)
    - [BeatTheDealer](#beatthedealer)
    - [BlackJack](#blackjack)
    - [Keno](#keno)
    - [Rouletto](#rouletto)
    - [Slots](#slots)
    - [NumberGuess](#numberguess)
4. [Contributing](#contributing)
5. [License](#license)

---

## 💻 Installation Instructions

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/arcade-simulation.git
    cd arcade-simulation
    ```

2. **Compile the Java files**:
    Ensure that you have JDK installed. You can compile the project using the following command:
    ```bash
    javac *.java
    ```

3. **Run the simulation**:
    After compilation, you can run the Arcade Simulation from the command line:
    ```bash
    java ArcadeSimulation
    ```

---

## 🕹️ How to Play

1. **Start the Arcade**: After running the program, you'll be presented with a menu that lists all five available games.
2. **Choose a Game**: Select one of the available games to play by entering the corresponding number.
3. **Place a Bet (if applicable)**: For games that involve betting (like Blackjack, Rouletto, Slots), you will be prompted to enter an amount you want to bet.
4. **Gameplay**: Each game will prompt you for any required inputs (e.g., guessing numbers, selecting cards, or spinning slots).
5. **End the Game**: After each game, you can either choose to play again or quit the Arcade.

---

## 🎮 Games Overview

### 🃏 BeatTheDealer

In **BeatTheDealer**, the goal is to pick a card that beats the dealer's card.

- **Gameplay**:
    - You and the dealer are each dealt a card.
    - You compare the values of the cards to determine the winner.
    - If your card is higher than the dealer's, you win the round.

---

### 🃏 BlackJack

**BlackJack** is a card game where you try to get as close to a value of 21 as possible without exceeding it.

- **Gameplay**:
    - You start with two cards, and you can choose to "hit" (draw another card) or "stand" (keep your current hand).
    - The dealer also has two cards, and you compete to have a hand value closer to 21 than the dealer.
    - Face cards are worth 10 points, and Aces can be worth 1 or 11 points.

---

### 🎲 Keno

**Keno** is a lottery-style game where you select numbers, and the game draws random numbers.

- **Gameplay**:
    - You select a set of numbers (usually between 1 and 80).
    - The game randomly picks a set of winning numbers.
    - You win based on how many numbers you selected match the winning numbers.

---

### 🎰 Rouletto

**Rouletto** is a simplified version of the classic casino game Roulette.

- **Gameplay**:
    - You can place a bet on specific numbers, colors, or ranges.
    - The game simulates a roulette wheel, and a ball lands on a random number.
    - You win if your bet matches the number, color, or range where the ball lands.

---

### 🎰 Slots

**Slots** is a traditional slot machine game where you spin the reels and try to match symbols.

- **Gameplay**:
    - You can bet a certain amount and spin the reels.
    - If the symbols on the reels match in a specific pattern, you win a prize.
    - The payout depends on the number and types of matching symbols.

---

### 🔢 NumberGuess

**NumberGuess** is a simple game where you try to guess a randomly selected number.

- **Gameplay**:
    - You are given a range (e.g., 1 to 100).
    - You need to guess the number within that range.
    - After each guess, the game tells you whether your guess is too high, too low, or correct.

---

## 🤝 Contributing

If you want to contribute to this project, feel free to fork the repository and create a pull request. Please ensure that your changes are well-tested and follow the project's coding style.

1. Fork the repo.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---










