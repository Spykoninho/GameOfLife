package org.example;

import java.util.List;

public class Cellule {
    private Position position;
    private int lifeStatus;
    private int futurelifeStatus;

    public Cellule(Position position, int lifeStatus) {
        this.position = position;
        this.lifeStatus = lifeStatus;
        futurelifeStatus = lifeStatus;
    }

    public boolean setFuturLifeStatus(List<Cellule> neighbors) {
        int livingNeighbors = 0;
        for (Cellule neighbor : neighbors) {
            int status = neighbor.getLifeStatus();
            if (status == 1) {
                livingNeighbors++;
            }
        }

        if (lifeStatus == 1) {
            if (livingNeighbors < 2 || livingNeighbors > 3) {
                futurelifeStatus = 0;
                return true;
            }else{
                futurelifeStatus = 1;
            }
        } else {
            if (livingNeighbors == 3) {
                futurelifeStatus = 1;
                return true;
            }else{
                futurelifeStatus = 0;
            }
        }
        return false;
    }

    public int getLifeStatus() {
        return lifeStatus;
    }

    public Position getPosition() {
        return position;
    }

    public void setFuturLifeStatusActual(){
        lifeStatus = futurelifeStatus;
    }
}
