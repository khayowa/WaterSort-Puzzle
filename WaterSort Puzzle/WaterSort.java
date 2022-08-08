import java.util.Random;
import java.util.Scanner;

public class WaterSort {

    private static StackAsMyArrayList<Character> bottles[] = new StackAsMyArrayList[5];

    private static StackAsMyArrayList<Character> bottle1 = new StackAsMyArrayList<Character>();
    private static StackAsMyArrayList<Character> bottle2 = new StackAsMyArrayList<Character>();
    private static StackAsMyArrayList<Character> bottle3 = new StackAsMyArrayList<Character>();
    private static StackAsMyArrayList<Character> bottle4 = new StackAsMyArrayList<Character>();
    private static StackAsMyArrayList<Character> bottle5 = new StackAsMyArrayList<Character>();

    private static StackAsMyArrayList<Character> bottle = new StackAsMyArrayList<>();

    private static Character red = new Character('r');
    private static Character green = new Character('g');
    private static Character blue = new Character('b');


    
    public static void main(String[] args){

        
        bottles[0] = bottle1;
        bottles[1] = bottle2;
        bottles[2] = bottle3;
        bottles[3] = bottle4;
        bottles[4] = bottle5;

        Scanner input = new Scanner(System.in);

        int root = 0;
        int pinpoint = 0;

        for(int i = 0; i < 4; i++){
            bottle.push(green);
            bottle.push(blue);
            bottle.push(red);

        }

        fillbottles();

        while(bottle.getStackSize() > 0){
            fillbottles();
        }

        System.out.println("Game Start: ");
        while(!solved()){

            showALL();
            System.out.print("Select the bottle : ");
        
            root = input.nextInt();
            System.out.print("Select the bottle destination: ");
            pinpoint = input.nextInt();

            if(bottles[pinpoint].getStackSize() < 4 && bottles[root].getStackSize() != 0){
                if(bottles[root].peek() == bottles[pinpoint].peek() || bottles[pinpoint].getStackSize() == 0){
                    bottles[pinpoint].push(bottles[root].pop());
                }
            }
        }
        
        System.out.println("End of Game");
        showALL();


    }
    public static void showALL(){
        System.out.println("");
        for(int k =0; k < bottles.length; k++){
            System.out.println("Bottle " +k+ " " + bottles[k].toString());
        }
    }

    public static void fillbottles(){

        int pastNum = 0;

        for(int k = 0; k < 3; k++){
            int newNum = 1 + new Random().nextInt(3);
            int random = new Random().nextInt(5);

            if(newNum == pastNum){
                Random view = new Random();
                newNum = 1 + view.nextInt(3);
            }

            switch(newNum){
                case 1: if(bottles[random].getStackSize() < 4){
                    if(bottle.getStackSize() > 0){
                        bottles[random].push(bottle.pop());
                    }
                }
                        break;

                case 2:if(bottles[random].getStackSize() < 4){
                    if(bottle.getStackSize() > 0){
                        bottles[random].push(bottle.pop());
                    }
                }
                        break;

                default: if(bottles[random].getStackSize() < 4){
                    if(bottle.getStackSize() > 0){
                        bottles[random].push(bottle.pop());
                    }

                }
                        
            }

            

        }


    }
    public static boolean solved(){
        boolean isComplete = false;
        int k = 0;

        for(int j = 0; j < 5; j++){
            if(bottles[j].getStackSize() == 4 && bottles[j].checkStackUniform()){k++;}

        }

        if(k !=3 ){
            isComplete = false;
        }
        else{
            isComplete = true;
        }
        
        return isComplete ;
    }
    
}
