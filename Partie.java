package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Partie {
    private int nbTour = 0;
    private Grille grille;

    Partie() {
    }

    public void startGame() {
        System.out.println("Choisissez les cellules que vous voulez mettre (<0 pour quitter)");
        Scanner sc = new Scanner(System.in);
        ArrayList<Position> positions = new ArrayList<>();
        int count = 0;
        do {
            System.out.println("Cellule n" + count + " :");
            System.out.println("x:");
            int x = sc.nextInt();
            if (x < 0) break;
            System.out.println("y:");
            int y = sc.nextInt();
            positions.add(new Position(x, y));
            count++;
        } while (true);
        ArrayList<Cellule> cellules = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (isPosInArray(new Position(x, y), positions)) {
                    cellules.add(new Cellule(new Position(x, y), 1));
                } else {
                    cellules.add(new Cellule(new Position(x, y), 0));
                }
            }
        }
        this.grille = new Grille(10, 10, cellules);
    }

    public boolean isPosInArray(Position pos, ArrayList<Position> positions) {
        for (Position p : positions) {
            if (p.getX() == pos.getX() && p.getY() == pos.getY()) {
                return true;
            }
        }
        return false;
    }

    public void playGame() {
        int moove = -1;
        while (moove != 0) {
            moove = 0;
            try {
                grille.printGrille();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Cellule c : grille.cellules) {
                Position p = c.getPosition();
                if (c.setFuturLifeStatus(grille.getNeighborCells(p))) {
                    moove++;
                }
            }
            for (Cellule c : grille.cellules) {
                c.setFuturLifeStatusActual();
            }
        }
    }
}
