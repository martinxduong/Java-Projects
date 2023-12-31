public class Rabbit extends Animal {


    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }


    private int lastTurn;

    int decideMove() {
      //Looks at all Directions
      for(int i=Model.MIN_DIRECTION; i<=Model.MAX_DIRECTION; i++){
        if(look(i)==Model.FOX){
          if(canMove(Model.turn(i,5)) && lastTurn!=3){
            lastTurn=5;
            return Model.turn(i,5);
          }
          else if(canMove(Model.turn(i,3)) && lastTurn!=5){
            lastTurn=3;
            return Model.turn(i,3);
          }
          else if(canMove(Model.turn(i,6)) && lastTurn!=2){
            lastTurn=6;
            return Model.turn(i,6);
          }
          else if(canMove(Model.turn(i,2)) && lastTurn!=6){
            lastTurn=2;
            return Model.turn(i,2);
          }
          else if(canMove(Model.turn(i,7)) && lastTurn!=1){
            lastTurn=7;
            return Model.turn(i,7);
          }
          else if(canMove(Model.turn(i,1)) && lastTurn!=7){
            lastTurn=1;
            return Model.turn(i,1);
          }
        }
      }
      return Model.STAY;
    }

        

  }

