package cube;

import java.util.Arrays;

public class Edge extends Piece {

    public Edge(int x, int z, int y){

        super(x, z, y);

    }

    protected void turnR(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.rEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.rEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.xOrientation = (this.xOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('x');

                }

                break;

            }

        }

    }

    protected void turnU(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.uEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.uEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.yOrientation = (this.yOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('y');

                }

                break;

            }

        }

    }

    protected void turnF(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.fEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.fEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.zOrientation = (this.zOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('z');

                }

                break;

            }

        }

    }

    protected void turnL(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.lEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.lEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.xOrientation = (this.xOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('x');

                }

                break;

            }

        }

    }

    protected void turnD(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.dEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.dEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.yOrientation = (this.yOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('y');

                }

                break;

            }

        }

    }

    protected void turnB(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.bEdgePositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.bEdgePositions[(i + direction + 4) % 4];
                this.x = newPos[0];
                this.z = newPos[1];
                this.y = newPos[2];

                this.zOrientation = (this.zOrientation + direction + 4) % 4;

                if((direction + 4) % 2 != 0){

                    this.orientColors('z');

                }

                break;

            }

        }

    }

}
