/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomofduality;

/**
 *
 * @author Beylix
 */
public class GameMain {
    
    GameBoard GB = new GameBoard();
    
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
    
    public void CheckStonesNumber()
    {
        int WhiteStonesNmbr = 0;
        int BlackStonesNmbr = 0;
        for( int x = 0; x < 8; x++ )
        {
            for( int y = 0; y < 8; y++ )
            {
                if ( GameArena[x][y] == 2 )
                {
                    WhiteStonesNmbr += 1;
                }
                else if( GameArena[x][y] == 1)
                {
                    BlackStonesNmbr += 1;
                }
            }
        }
        GB.changeStonesNumberText(BlackStonesNmbr, WhiteStonesNmbr);
    }
    
    //  Place starting stones to arena
    public void PlaceStartingStones()
    {
        GameArena[3][3] = 1;
        GameArena[3][4] = 2;
        GameArena[4][3] = 2;
        GameArena[4][4] = 1;
    }
    
    public void MainMove()
    {
        CheckStonesNumber();
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
    /////
    public void GameCheckForEnd(int Color)
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                
            }
        }
    }
    
    public int CheckForPointsUp(int i, int j, int Color)
    {
        for(int m = i-1; m>=0; m--)
        {
            if(GameArena[m][j] == Color)
            {
                return m-i-1;
            }
            else if(GameArena[m][j] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int CheckForPointsRight(int i, int j, int Color)
    {
        for(int m = j+1; m<8; m++)
        {
            if(GameArena[i][m] == Color)
            {
                return j-m-1;
            }
            else if(GameArena[i][m] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int CheckForPointsDown(int i, int j, int Color)
    {
        for(int m = i+1; m<8; m++)
        {
            if(GameArena[m][j] == Color)
            {
                return m-i-1;
            }
            else if(GameArena[m][j] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int CheckForPointsLeft(int i, int j, int Color)
    {
        for(int m = j-1; m>=0; m--)
        {
            if(GameArena[i][m] == Color)
            {
                return j-m-1;
            }
            else if(GameArena[i][m] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    public int CheckForPointsUpLeft(int i, int j, int Color)
    {
        for(int m = j-1; m>=0; m--)
        {
            if(GameArena[i][m] == Color)
            {
                return j-m-1;
            }
            else if(GameArena[i][m] == 0)
            {
                return 0;
            }
        }
        return 0;
    }
    
    ////
    
    //  playerColor = true  ->  Black
    //  playerColor = false ->  white
    public void NewGame(boolean playerColor)
    {
        CreateArena();
        PlaceStartingStones();
        CheckStonesNumber();
    }
}
