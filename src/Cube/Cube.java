package Cube;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class Cube {
    // Possible corner positions for each face
    static final int[][] rCornerPositions = new int[][]{{2, 0, 0}, {2, 0, 2}, {2, 2, 2}, {2, 2, 0}};
    static final int[][] uCornerPositions = new int[][]{{0, 0, 0}, {2, 0, 0}, {2, 2, 0}, {0, 2, 0}};
    static final int[][] fCornerPositions = new int[][]{{0, 2, 0}, {2, 2, 0}, {2, 2, 2}, {0, 2, 2}};
    static final int[][] lCornerPositions = new int[][]{{0, 0, 0}, {0, 2, 0}, {0, 2, 2}, {0, 0, 2}};
    static final int[][] dCornerPositions = new int[][]{{0, 2, 2}, {2, 2, 2}, {2, 0, 2}, {0, 0, 2}};
    static final int[][] bCornerPositions = new int[][]{{2, 0, 0}, {0, 0, 0}, {0, 0, 2}, {2, 0, 2}};
    // Possible edge positions for each face
    static final int[][] rEdgePositions = new int[][]{{2, 1, 0}, {2, 0, 1}, {2, 1, 2}, {2, 2, 1}};
    static final int[][] uEdgePositions = new int[][]{{1, 0, 0}, {2, 1, 0}, {1, 2, 0}, {0, 1, 0}};
    static final int[][] fEdgePositions = new int[][]{{1, 2, 0}, {2, 2, 1}, {1, 2, 2}, {0, 2, 1}};
    static final int[][] lEdgePositions = new int[][]{{0, 1, 0}, {0, 2, 1}, {0, 1, 2}, {0, 0, 1}};
    static final int[][] dEdgePositions = new int[][]{{1, 2, 2}, {2, 1, 2}, {1, 0, 2}, {0, 1, 2}};
    static final int[][] bEdgePositions = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 2}, {2, 0, 1}};
    // Each possible move with corresponding function call
    private final HashMap<String, Callable<Void>> moves = new HashMap<>(){

        {

            put("R", () -> { turnR(1); return null; });
            put("U", () -> { turnU(1); return null; });
            put("F", () -> { turnF(1); return null; });
            put("L", () -> { turnL(1); return null; });
            put("D", () -> { turnD(1); return null; });
            put("B", () -> { turnB(1); return null; });
            put("R'", () -> { turnR(-1); return null; });
            put("U'", () -> { turnU(-1); return null; });
            put("F'", () -> { turnF(-1); return null; });
            put("L'", () -> { turnL(-1); return null; });
            put("D'", () -> { turnD(-1); return null; });
            put("B'", () -> { turnB(-1); return null; });
            put("R2", () -> { turnR(2); return null; });
            put("U2", () -> { turnU(2); return null; });
            put("F2", () -> { turnF(2); return null; });
            put("L2", () -> { turnL(2); return null; });
            put("D2", () -> { turnD(2); return null; });
            put("B2", () -> { turnB(2); return null; });

        }

    };
    // Current state of the pieces; can also be referred to as the cube state
    public Piece[][][] pieces;
    // Constructor just creates default cube state, initialized each piece
    public Cube(){

        this.pieces = new Piece[3][3][3];

        for(int x = 0; x < 3; x++){

            for(int z = 0; z < 3; z++){

                for(int y = 0; y < 3; y++){

                    if(x == 1 && z == 1 && y == 1){

                        continue;

                    }else if((x + z + y) % 2 == 0){

                        if((x == 1 && z == 1) || (z == 1 && y == 1) || (x == 1 && y == 1)){

                            this.pieces[x][z][y] = new Center(x, z, y);

                        }else{

                            this.pieces[x][z][y] = new Corner(x, z, y);

                        }

                    }else if((x + z + y) % 2 == 1){

                        this.pieces[x][z][y] = new Edge(x, z, y);

                    }

                }

            }

        }

    }
    // Get the current cube state
    public Piece[][][] getCurrentState(){

        return this.pieces;

    }
    // Set the current cube state
    public void setCurrentState(Piece[][][] state){

        this.pieces = state;

    }
    // Calls turn function corresponding to given move, updates cube state
    public void turn(String move) throws Exception{

        this.moves.get(move).call();
        updateCube();

    }
    // Puts all the pieces in their correct positions
    private void updateCube(){

        Piece[][][] newCubeState = new Piece[3][3][3];

        for(int x = 0; x < 3; x++){

            for(int z = 0; z < 3; z++){

                for(int y = 0; y < 3; y++){

                    if(x == 1 && z == 1 && y == 1){

                        continue;

                    }

                    newCubeState[this.pieces[x][z][y].getX()][this.pieces[x][z][y].getZ()][this.pieces[x][z][y].getY()] = this.pieces[x][z][y];

                }

            }

        }

        this.pieces = newCubeState;

    }
    // Each turn function just goes through each piece in the face and calls the appropriate Piece.turn{X} function
    private void turnR(int direction){

        for(int z = 0; z < 3; z++){

            for(int y = 0; y < 3; y ++){

                this.pieces[2][z][y].turnR(direction);

            }

        }

    }

    private void turnU(int direction){

        for(int x = 0; x < 3; x++){

            for(int z = 0; z < 3; z++){

                this.pieces[x][z][0].turnU(direction);

            }

        }

    }

    private void turnF(int direction){

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                this.pieces[x][2][y].turnF(direction);

            }

        }

    }

    private void turnL(int direction){

        for(int z = 0; z < 3; z++){

            for(int y = 0; y < 3; y ++){

                this.pieces[0][z][y].turnL(direction);

            }

        }

    }

    private void turnD(int direction){

        for(int x = 0; x < 3; x++){

            for(int z = 0; z < 3; z++){

                this.pieces[x][z][2].turnD(direction);

            }

        }

    }

    private void turnB(int direction){

        for(int x = 0; x < 3; x++){

            for(int y = 0; y < 3; y++){

                this.pieces[x][0][y].turnB(direction);

            }

        }

    }

}
