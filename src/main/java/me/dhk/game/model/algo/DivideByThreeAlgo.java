package me.dhk.game.model.algo;

public class DivideByThreeAlgo implements IAlgorithm {

    @Override
    public int getNextMove(int move) {
        int result;
        int remainder= move%3;
        switch (remainder){
            case 0:
                  result=move/3;
                  System.out.println("Added 0");
                  break;
            case 1:
                result=(move-1)/3;
                System.out.println("Added -1");
                break;
            case 2:
                result=(move+1)/3;
                System.out.println("Added +1");
                break;
            default:
                throw new RuntimeException(); // This will not be executed
        }
        return result;
    }

    @Override
    public boolean isWon(int move) {
        return move==1;
    }
}
