import java.util.HashMap;
import java.util.Scanner;
import cube.*;

public class ConsoleApplication {

    Cube cube;

    public ConsoleApplication(){

        this.cube = new Cube();

    }

    public ConsoleApplication(Piece[][][] state){

        this.cube = new Cube();
        this.cube.setCurrentState(state);

    }

    private void turnCube(String move){

        try{

            this.cube.turn(move.toUpperCase());

        }catch(Exception e){

            e.printStackTrace();
            System.out.println("Move probably not valid");

        }

    }

    private void displayCube(){

        HashMap<Character, Colors[][]> colorMap = this.cube.makeColorMap();

        Colors[][] faceB = colorMap.get('B');
        Colors[][] faceL = colorMap.get('L');
        Colors[][] faceU = colorMap.get('U');
        Colors[][] faceR = colorMap.get('R');
        Colors[][] faceF = colorMap.get('F');
        Colors[][] faceD = colorMap.get('D');

        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceB[i][0]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceB[i][1]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceB[i][2]); } System.out.println();
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceL[0][2 - i]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceU[i][0]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceR[2][i]); } System.out.println();
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceL[1][2 - i]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceU[i][1]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceR[1][i]); }  System.out.println();
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceL[2][2 - i]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceU[i][2]); }
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceR[0][i]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceF[i][0]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceF[i][1]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceF[i][2]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceD[i][0]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceD[i][1]); } System.out.println();
        System.out.print("      ");
        for(int i = 0; i < 3; i++){ System.out.print(" " + faceD[i][2]); } System.out.println();

    }

    private void inputHandler(){

        Scanner s = new Scanner(System.in);

        displayCube();

        while(true){

            System.out.print(" > ");
            String input = s.nextLine().trim();

            if(input.equals("quit")){

                System.exit(0);

            }

            turnCube(input);
            displayCube();

        }

    }

    public static void main(String[] args){

        ConsoleApplication app = new ConsoleApplication();

        app.inputHandler();

    }

}
