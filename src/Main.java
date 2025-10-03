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
            field = userStep(field, scanner);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j].equals(""))
                        System.out.print("_");
                    System.out.print(field[i][j]);
                }
                System.out.println("");
            }
            if (test(field)) break;
            field = computerStep(field);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j].equals(""))
                        System.out.print("_");
                    System.out.print(field[i][j]);
                }
                System.out.println("");
            }
            if (test(field)) break;
        }

        scanner.close();
    }

    public static String[][] userStep(String[][] field, Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter number of your position [1-9]: ");
                int position = scanner.nextInt();

                boolean validMove = false;

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

                if (validMove) break;
                else System.out.println("This position is already taken. Try again.");

            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Enter a number from 1 to 9.");
                scanner.next();
            }
        }

        return field;
    }


    public static String[][] computerStep(String[][] field) {
        while (true) {
            int position = (int) ((Math.random() * 9) + 1);

            switch (position) {
                case 1: if (field[0][0].equals("")) { field[0][0] = "O"; return field; } break;
                case 2: if (field[0][1].equals("")) { field[0][1] = "O"; return field; } break;
                case 3: if (field[0][2].equals("")) { field[0][2] = "O"; return field; } break;
                case 4: if (field[1][0].equals("")) { field[1][0] = "O"; return field; } break;
                case 5: if (field[1][1].equals("")) { field[1][1] = "O"; return field; } break;
                case 6: if (field[1][2].equals("")) { field[1][2] = "O"; return field; } break;
                case 7: if (field[2][0].equals("")) { field[2][0] = "O"; return field; } break;
                case 8: if (field[2][1].equals("")) { field[2][1] = "O"; return field; } break;
                case 9: if (field[2][2].equals("")) { field[2][2] = "O"; return field; } break;
            }
        }
    }

    public static boolean test(String[][] field) {
        // X win conditions
        if (field[0][0].equals("X") && field[0][1].equals("X") && field[0][2].equals("X")) {
            System.out.println("X wins (row 1)");
            return true;
        } else if (field[1][0].equals("X") && field[1][1].equals("X") && field[1][2].equals("X")) {
            System.out.println("X wins (row 2)");
            return true;
        } else if (field[2][0].equals("X") && field[2][1].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (row 3)");
            return true;
        } else if (field[0][0].equals("X") && field[1][0].equals("X") && field[2][0].equals("X")) {
            System.out.println("X wins (column 1)");
            return true;
        } else if (field[0][1].equals("X") && field[1][1].equals("X") && field[2][1].equals("X")) {
            System.out.println("X wins (column 2)");
            return true;
        } else if (field[0][2].equals("X") && field[1][2].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (column 3)");
            return true;
        } else if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")) {
            System.out.println("X wins (diagonal left-to-right)");
            return true;
        } else if (field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X")) {
            System.out.println("X wins (diagonal right-to-left)");
            return true;
        }

        // O win conditions
        else if (field[0][0].equals("O") && field[0][1].equals("O") && field[0][2].equals("O")) {
            System.out.println("O wins (row 1)");
            return true;
        } else if (field[1][0].equals("O") && field[1][1].equals("O") && field[1][2].equals("O")) {
            System.out.println("O wins (row 2)");
            return true;
        } else if (field[2][0].equals("O") && field[2][1].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (row 3)");
            return true;
        } else if (field[0][0].equals("O") && field[1][0].equals("O") && field[2][0].equals("O")) {
            System.out.println("O wins (column 1)");
            return true;
        } else if (field[0][1].equals("O") && field[1][1].equals("O") && field[2][1].equals("O")) {
            System.out.println("O wins (column 2)");
            return true;
        } else if (field[0][2].equals("O") && field[1][2].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (column 3)");
            return true;
        } else if (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O")) {
            System.out.println("O wins (diagonal left-to-right)");
            return true;
        } else if (field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O")) {
            System.out.println("O wins (diagonal right-to-left)");
            return true;
        }

        // no winner
        System.out.println("No winner yet!");
        return false;
    }
}