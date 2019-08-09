
package br.cefetmg.games;

public enum Direction {
 
    upSide(0,1),
    downSide(0,-1),
    rightSide(1,0),
    leftSide(-1,0);
    
    public int stepX;
    public int stepY;

    Direction(int stepX, int stepY) {
        this.stepX = stepX;
        this.stepY = stepY;
    }
    
}
