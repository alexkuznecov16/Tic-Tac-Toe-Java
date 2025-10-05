import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] field = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
        };
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // user step
            field = userStep(field, scanner);
            System.out.println("Field after user step: ");
            printField(field);
            if (test(field)) break;

            // computer step
            field = computerStep(field);
            System.out.println("\nField after computer step: ");
            printField(field);
            if (test(field)) break;
        }

        scanner.close();
    }

    // print current field
    public static void printField(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                if (string.equals(""))
                    System.out.print("_");
                System.out.print(string);
            }
            System.out.println("");
        }
    }

    // make a user step (by choice)
    public static String[][] userStep(String[][] field, Scanner scanner) {
        // loop works while user input is incorrect
        while (true) {
            try {
                System.out.print("Enter number of your position [1-9]: ");
                int position = scanner.nextInt(); // get integer

                boolean validMove = false; // initial state

                // test specific position is empty and make user step
                switch (position) {
                    case 1: if (field[0][0].equals("")) { field[0][0] = "X"; validMove = true; } break;
                    case 2: if (field[0][1].equals("")) { field[0][1] = "X"; validMove = true; } break;
                    case 3: if (field[0][2].equals("")) { field[0][2] = "X"; validMove = true; } break;
                    case 4: if (field[1][0].equals("")) { field[1][0] = "X"; validMove = true; } break;
                    case 5: if (field[1][1].equals("")) { field[1][1] = "X"; validMove = true; } break;
                    case 6: if (field[1][2].equals("")) { field[1][2] = "X"; validMove = true; } break;
                    case 7: if (field[2][0].equals("")) { field[2][0] = "X"; validMove = true; } break;
                    case 8: if (field[2][1].equals("")) { field[2][1] = "X"; validMove = true; } break;
                    case 9: if (field[2][2].equals("")) { field[2][2] = "X"; validMove = true; } break;
                }

                if (validMove) break; // if user input is correct
                else System.out.println("This position is already taken. Try again."); // if user input is incorrect

            } catch (InputMismatchException e) {
                // if user input is incorrect
                System.out.println("Wrong input! Enter a number from 1 to 9.");
                scanner.next(); // clear previous input
            }
        }

        return field;
    }

    // make a computer (random) step
    public static String[][] computerStep(String[][] field) {
        // loop works while computer step is incorrect
        while (true) {
            int position = (int) ((Math.random() * 9) + 1); // random position

            boolean validMove = false; // initial state

            // test specific position is empty and make computer step
            switch (position) {
                case 1: if (field[0][0].equals("")) { field[0][0] = "O"; validMove = true; } break;
                case 2: if (field[0][1].equals("")) { field[0][1] = "O"; validMove = true; } break;
                case 3: if (field[0][2].equals("")) { field[0][2] = "O"; validMove = true; } break;
                case 4: if (field[1][0].equals("")) { field[1][0] = "O"; validMove = true; } break;
                case 5: if (field[1][1].equals("")) { field[1][1] = "O"; validMove = true; } break;
                case 6: if (field[1][2].equals("")) { field[1][2] = "O"; validMove = true; } break;
                case 7: if (field[2][0].equals("")) { field[2][0] = "O"; validMove = true; } break;
                case 8: if (field[2][1].equals("")) { field[2][1] = "O"; validMove = true; } break;
                case 9: if (field[2][2].equals("")) { field[2][2] = "O"; validMove = true; } break;
            }

            if (validMove) break; // if computer input is correct
        }
        return field;
    }

    // test for win conditions
    public static boolean test(String[][] field) {
        boolean result = false; // initial state (win condition is not exist)

        // X win conditions
        if (field[0][0].equals("X") && field[0][1].equals("X") && field[0][2].equals("X")) {
            System.out.println("X wins (row 1)");
            result = true;
        } else if (field[1][0].equals("X") && field[1][1].equals("X") && field[1][2].equals("X")) {
            System.out.println("X wins (row 2)");
            result = true;
        } else if (field[2][0].equals("X") && field[2][1].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (row 3)");
            result = true;
        } else if (field[0][0].equals("X") && field[1][0].equals("X") && field[2][0].equals("X")) {
            System.out.println("X wins (column 1)");
            result = true;
        } else if (field[0][1].equals("X") && field[1][1].equals("X") && field[2][1].equals("X")) {
            System.out.println("X wins (column 2)");
            result = true;
        } else if (field[0][2].equals("X") && field[1][2].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (column 3)");
            result = true;
        } else if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (diagonal left-to-right)");
            result = true;
        } else if (field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X")) {
            System.out.println("X wins (diagonal right-to-left)");
            result = true;
        }

        // O win conditions
        else if (field[0][0].equals("O") && field[0][1].equals("O") && field[0][2].equals("O")) {
            System.out.println("O wins (row 1)");
            result = true;
        } else if (field[1][0].equals("O") && field[1][1].equals("O") && field[1][2].equals("O")) {
            System.out.println("O wins (row 2)");
            result = true;
        } else if (field[2][0].equals("O") && field[2][1].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (row 3)");
            result = true;
        } else if (field[0][0].equals("O") && field[1][0].equals("O") && field[2][0].equals("O")) {
            System.out.println("O wins (column 1)");
            result = true;
        } else if (field[0][1].equals("O") && field[1][1].equals("O") && field[2][1].equals("O")) {
            System.out.println("O wins (column 2)");
            result = true;
        } else if (field[0][2].equals("O") && field[1][2].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (column 3)");
            result = true;
        } else if (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (diagonal left-to-right)");
            result = true;
        } else if (field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O")) {
            System.out.println("O wins (diagonal right-to-left)");
            result = true;
        }

        // no winner
        return result;
    }
}