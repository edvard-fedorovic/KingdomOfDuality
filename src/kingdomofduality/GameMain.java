/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomofduality;

/**
 *
 * @author Rengetsu
 */
public class GameMain {
    //  0   -   Nothing, 1   -   Black, 2   -   White
    int [][] GameArena = new int[8][8];
    
    //  true - Black turn, false - white turn
    boolean Move = true;
    
    //  GameFinish = false   ->  game still going, GameFinish = true  ->  game finish
    boolean GameFinish = false;
    
    //  Create 8 x 8 arena
    public void CreateArena()
    {
        for( int i = 0; i < 8; i++ )
        {
            for( int y = 0; y < 8; y++ )
            {
                GameArena[i][y] = 0;
            }
        }
    }
    
    //  Place starting stones to arena
    public void PlaceStartingStones()
    {
        GameArena[3][3] = 1;
        GameArena[3][4] = 2;
        GameArena[4][3] = 2;
        GameArena[4][4] = 1;
    }
    
    public void BlackMove()
    {
    }
    
    public void WhiteMove()
    {
    }
    
    public boolean CheckGameFinish()
    {
        return false;
    }
    
    public void GameProcess()
    {
        while(CheckGameFinish() == false)
        {
            if(Move == true)
            {
                BlackMove();
                Move = false;
            }
            else
            {
                WhiteMove();
                Move = true;
            }
        }
    }
    
    //  playerColor = true  ->  Black
    //  playerColor = false ->  white
    public void NewGame(boolean playerColor)
    {
        GameBoard GB = new GameBoard();
        CreateArena();
        PlaceStartingStones();
    }
}
