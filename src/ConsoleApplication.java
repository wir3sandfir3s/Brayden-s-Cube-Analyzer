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

        Piece[][][] cubeState = this.cube.getCurrentState();
        HashMap<Character, Colors[][]> colorMap = new HashMap<>();
        colorMap.put('R', new Colors[3][3]);
        colorMap.put('U', new Colors[3][3]);
        colorMap.put('F', new Colors[3][3]);
        colorMap.put('L', new Colors[3][3]);
        colorMap.put('D', new Colors[3][3]);
        colorMap.put('B', new Colors[3][3]);

        for(int x = 0; x < 3; x++){

            for(int z = 0; z < 3; z++){

                for(int y = 0; y < 3; y++){

                    if(x == 1 && z == 1 && y == 1){

                        continue;

                    }

                    Piece piece = cubeState[x][z][y];
                    Colors[] colors = piece.getColorsMapped();
                    Colors[][] faceMap;

                    if(x == 0){

                        faceMap = colorMap.get('L');
                        faceMap[z][y] = colors[0];
                        colorMap.put('L', faceMap);

                    }else if(x == 2){

                        faceMap = colorMap.get('R');
                        faceMap[2 - z][y] = colors[0];
                        colorMap.put('R', faceMap);

                    }

                    if(z == 0){

                        faceMap = colorMap.get('B');
                        faceMap[x][y] = colors[1];
                        colorMap.put('B', faceMap);

                    }else if(z == 2){

                        faceMap = colorMap.get('F');
                        faceMap[x][y] = colors[1];
                        colorMap.put('F', faceMap);

                    }

                    if(y == 0){

                        faceMap = colorMap.get('U');
                        faceMap[x][z] = colors[2];
                        colorMap.put('U', faceMap);

                    }else if(y == 2){

                        faceMap = colorMap.get('D');
                        faceMap[x][2 - z] = colors[2];
                        colorMap.put('D', faceMap);

                    }

                }

            }

        }

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
