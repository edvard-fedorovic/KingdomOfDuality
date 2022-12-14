/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomofduality;

import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Beylix
 */
public class GameMain {
    public int [][] gameArena = new int[8][8];
    public int [][] pointMatrix = new int[8][8];
    
    public boolean move = true;
    public int playerColor = 0;
    public int whiteStonesNmbr;
    public int blackStonesNmbr;
    
    public void createArena(){
        for( int i = 0; i < 8; i++ )
        {
            for( int y = 0; y < 8; y++ )
            {
                gameArena[i][y] = 0;
            }
        }
        gameArena[3][3] = 1;
        gameArena[3][4] = 2;
        gameArena[4][3] = 2;
        gameArena[4][4] = 1;
        // Taip bus geriau. Is karto savo vietoje. Ir nereikia kurti nereikalinga metoda.
    }
    
    public void CheckStonesNumber(){
        whiteStonesNmbr = 0;
        blackStonesNmbr = 0;
        for( int x = 0; x < 8; x++ )
        {
            for( int y = 0; y < 8; y++ )
            {
                if ( gameArena[x][y] == 2 )
                {
                    whiteStonesNmbr += 1;
                }
                else if( gameArena[x][y] == 1)
                {
                    blackStonesNmbr += 1;
                }
            }
        }
    }
    
    /*public void placeStartingStones(){
        gameArena[3][3] = 1;
        gameArena[3][4] = 2;
        gameArena[4][3] = 2;
        gameArena[4][4] = 1;
    }*/
    // Galima sutaupyti vietos. Gali vietoj to, kad rasyti placeStartingStones kaip atskyra metoda, irasyti ja iskarto i createArena metoda.
    // Vis tiek bus naudojama tik viena karta pradedant zaidima.
    
    public void BlackMove(){
        if(playerColor == 2){
            int xyCoordinates[] = aiDecision(1);
            mapSlotPicked(xyCoordinates[0], xyCoordinates[1], 1);
        }
    }
    
    public int [] AiDecision(int Color){
        int bestPossiblemove[] = new int[2];
            int mostPoints = 0;
            bestPossiblemove[0] = 0;
            bestPossiblemove[1] = 0;
            createPointMatrix(Color);
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(pointMatrix[i][j] > mostPoints){
                        mostPoints = pointMatrix[i][j];
                        bestPossiblemove[0] = i;
                        bestPossiblemove[1] = j;
                    }
                }
            }
        return bestPossiblemove;    
    }
    
    public void WhiteMove(){
        if(playerColor == 1){
            int xyCoordinates[] = AiDecision(2);
            mapSlotPicked(xyCoordinates[0], xyCoordinates[1], 2);
        }
    }
    
    public boolean CheckGameFinish(){
        if(move == true){
            if(gameCheckIfpointMatrixIsEmpty(1) == true){
                return true;
            }
        }
        else if(move == false){
            if(gameCheckIfpointMatrixIsEmpty(2) == true){
                return true;
            }
        }
        return false;
    }
    
    public void endGame(){
        checkStonesNumber();
        String Black = String.valueOf(blackStonesNmbr);
        String White = String.valueOf(whiteStonesNmbr);
        JOptionPane.showMessageDialog(null, "Game Finished: Black " + Black +", White " + White);
        System.exit(0);
    }
    
    public boolean gameCheckIfpointMatrixIsEmpty(int Color){
        createPointMatrix(Color);
        int possibleMoves = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(pointMatrix[i][j] != 0) {
                    possibleMoves = possibleMoves + 1;
                }
            }
        }
        if(possibleMoves != 0) return false;
        else return true;
    }
    
    public void createPointMatrix(int Color){
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(gameArena[i][j] == 0)
                {
                    pointMatrix[i][j] = checkForPointsUp(i, j, Color) + checkForPointsRight(i, j, Color) + 
                                        checkForPointsDown(i, j, Color) + checkForPointsLeft(i, j, Color) + 
                                        checkForPointsUpLeft(i, j, Color) + checkForPointsUpRight(i, j, Color) + 
                                        checkForPointsDownRight(i, j, Color) + checkForPointsDownLeft(i, j, Color);
                }
                else
                    pointMatrix[i][j] = 0;
            }
        }
    }
    
    public int checkForPointsUp(int i, int j, int Color){
        for(int m = i-1; m>=0; m--)
        {
            if(gameArena[m][j] == Color)
            {
                return i-m-1;
            }
            else if(gameArena[m][j] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int checkForPointsRight(int i, int j, int Color){
        for(int m = j+1; m<8; m++)
        {
            if(gameArena[i][m] == Color)
            {
                return m-j-1;
            }
            else if(gameArena[i][m] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int checkForPointsDown(int i, int j, int Color){
        for(int m = i+1; m<8; m++)
        {
            if(gameArena[m][j] == Color)
            {
                return m-i-1;
            }
            else if(gameArena[m][j] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int checkForPointsLeft(int i, int j, int Color){
        for(int m = j-1; m>=0; m--)
        {
            if(gameArena[i][m] == Color)
            {
                return j-m-1;
            }
            else if(gameArena[i][m] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int checkForPointsUpLeft(int i, int j, int Color){
        if(i<=j)
        {
            for(int m = 1; m<=i; m++)
            {
                if(gameArena[i-m][j-m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i-m][j-m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
        else
        {
            for(int m = 1; m<=j; m++)
            {
                if(gameArena[i-m][j-m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i-m][j-m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
    }
    
    public int checkForPointsUpRight(int i, int j, int Color){
        if(i<=(7-j))
        {
            for(int m = 1; m<=i; m++)
            {
                if(gameArena[i-m][j+m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i-m][j+m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
        else
        {
            for(int m = 1; m<=(7-j); m++)
            {
                if(gameArena[i-m][j+m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i-m][j+m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
    }
    
    public int checkForPointsDownRight(int i, int j, int Color){
        if(i<=j)
        {
            for(int m = 1; m<=(7-j); m++)
            {
                if(gameArena[i+m][j+m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i+m][j+m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
        else
        {
            for(int m = 1; m<=(7-i); m++)
            {
                if(gameArena[i+m][j+m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i+m][j+m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
    }
    
    public int checkForPointsDownLeft(int i, int j, int Color){
        if(j>=(7-i))
        {
            for(int m = 1; m<=(7-i); m++)
            {
                if(gameArena[i+m][j-m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i+m][j-m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
        else
        {
            for(int m = 1; m<=j; m++)
            {
                if(gameArena[i+m][j-m] == Color)
                {
                    return m-1;
                }
                else if(gameArena[i+m][j-m] == 0)
                {
                    return 0;
                }
            }
            return 0;
        }
    }
    
    public void mapSlotPicked(int positionX, int positionY, int Color){
        createPointMatrix(Color);
        if(pointMatrix[positionX][positionY] != 0)
        {
            changeStonesOnBoard(positionX, positionY, Color);
            if(Color == 1) {
                move = false;
                if(checkGameFinish() == true){
                    endGame();
                }
                whiteMove();
            }
            else if(Color == 2) {
                move = true;
                if(checkGameFinish() == true){
                    endGame();
                }
                blackMove();
            }
        }
    }
    
    public void changeStonesOnBoard(int positionX, int positionY, int Color){
        gameArena[positionX][positionY] = Color;
        changeStonesRight(positionX, positionY, Color);
        changeStonesRightDown(positionX, positionY, Color);
        changeStonesDown(positionX, positionY, Color);
        changeStonesLeftDown(positionX, positionY, Color);
        changeStonesLeft(positionX, positionY, Color);
        changeStonesLeftUp(positionX, positionY, Color);
        changeStonesUp(positionX, positionY, Color);
        changeStonesRightUp(positionX, positionY, Color);
    }
    
    public void changeStonesRight(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX+i >= 8)
            {
                break;
            }
            if(gameArena[positionX+i][positionY] != Color && gameArena[positionX+i][positionY] != 0)
            {
                temp++;
            }
            if(gameArena[positionX+i][positionY] == 0)
            {
                break;
            }
            if(gameArena[positionX+i][positionY] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX+i-j][positionY] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesRightDown(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX+i >= 8 || positionY+i >= 8)
            {
                break;
            }
            if(gameArena[positionX+i][positionY+i] != Color && gameArena[positionX+i][positionY+i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX+i][positionY+i] == 0)
            {
                break;
            }
            if(gameArena[positionX+i][positionY+i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX+i-j][positionY+i-j] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesDown(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionY+i >= 8)
            {
                break;
            }
            if(gameArena[positionX][positionY+i] != Color && gameArena[positionX][positionY+i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX][positionY+i] == 0)
            {
                break;
            }
            if(gameArena[positionX][positionY+i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX][positionY+i-j] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesLeftDown(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX-i < 0 || positionY+i >= 8)
            {
                break;
            }
            if(gameArena[positionX-i][positionY+i] != Color && gameArena[positionX-i][positionY+i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX-i][positionY+i] == 0)
            {
                break;
            }
            if(gameArena[positionX-i][positionY+i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX-i+j][positionY+i-j] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesLeft(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX-i < 0)
            {
                break;
            }
            if(gameArena[positionX-i][positionY] != Color && gameArena[positionX-i][positionY] != 0)
            {
                temp++;
            }
            if(gameArena[positionX-i][positionY] == 0)
            {
                break;
            }
            if(gameArena[positionX-i][positionY] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX-i+j][positionY] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesLeftUp(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX-i < 0 || positionY-i < 0)
            {
                break;
            }
            if(gameArena[positionX-i][positionY-i] != Color && gameArena[positionX-i][positionY-i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX-i][positionY-i] == 0)
            {
                break;
            }
            if(gameArena[positionX-i][positionY-i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX-i+j][positionY-i+j] = Color;
                }
                break;
            }
        }
    }
    
    public void changeStonesUp(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionY-i < 0)
            {
                break;
            }
            if(gameArena[positionX][positionY-i] != Color && gameArena[positionX][positionY-i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX][positionY-i] == 0)
            {
                break;
            }
            if(gameArena[positionX][positionY-i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX][positionY-i+j] = Color;
                }
                break;
            }
        }
    }
     
    public void changeStonesRightUp(int positionX, int positionY, int Color){
        int temp = 0;
        for(int i = 1; i < 8; i++)
        {
            if(positionX+i >= 8 || positionY-i < 0)
            {
                break;
            }
            if(gameArena[positionX+i][positionY-i] != Color && gameArena[positionX+i][positionY-i] != 0)
            {
                temp++;
            }
            if(gameArena[positionX+i][positionY-i] == 0)
            {
                break;
            }
            if(gameArena[positionX+i][positionY-i] == Color)
            {
                for(int j = temp; j > 0; j--)
                {
                    gameArena[positionX+i-j][positionY-i+j] = Color;
                }
                break;
            }
        }
    }

    public void newGame(boolean playerColor1){
        createArena();
        if(playerColor1 == true){
            playerColor = 1;
        }
        else{
            playerColor = 2;
        }
        placeStartingStones();
        if(playerColor == 2){
            blackMove();
        }
    }
}
