package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Grille {
    private int width;
    private int height;
    ArrayList<Cellule> cellules;

    public Grille(int width, int height, ArrayList<Cellule> cellules) {
        this.width = width;
        this.height = height;
        this.cellules = cellules;
    }

    public void printGrille() throws InterruptedException {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cellule cell = getCellByPos(new Position(x, y));
                System.out.print(cell.getLifeStatus() == 1 ? "*" : ".");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
        Thread.sleep(1000);
    }

    public ArrayList<Cellule> getNeighborCells(Position p) {
        ArrayList<Cellule> neighborCells = new ArrayList<>();
        Position[] nPos = {
                new Position(p.getX(), p.getY() + 1),
                new Position(p.getX(), p.getY() - 1),
                new Position(p.getX() + 1, p.getY()),
                new Position(p.getX() - 1, p.getY()),
                new Position(p.getX() + 1, p.getY() + 1),
                new Position(p.getX() + 1, p.getY() - 1),
                new Position(p.getX() - 1, p.getY() + 1),
                new Position(p.getX() - 1, p.getY() - 1),
        };
        for (Cellule c : cellules) {
            Position cellPosition = c.getPosition();
            for (Position n : nPos) {
                if(n.getX() == cellPosition.getX() && n.getY() == cellPosition.getY()) {
                    neighborCells.add(c);
                }
            }
        }
        return neighborCells;
    }

    public Cellule getCellByPos(Position p) {
        for (Cellule c : cellules) {
            if (c.getPosition().getX() == p.getX() && c.getPosition().getY() == p.getY()) {
                return c;
            }
        }
        return null;
    }
}
