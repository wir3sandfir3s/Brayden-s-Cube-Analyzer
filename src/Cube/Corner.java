package Cube;

import java.util.Arrays;

public class Corner extends Piece {

    public Corner(int x, int z, int y){

        super(x, z, y);

    }

    protected void turnR(int direction){

        for(int i = 0; i < 4; i++){

            if(Arrays.equals(Cube.rCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.rCornerPositions[(i + direction + 4) % 4];
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

            if(Arrays.equals(Cube.uCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.uCornerPositions[(i + direction + 4) % 4];
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

            if(Arrays.equals(Cube.fCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.fCornerPositions[(i + direction + 4) % 4];
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

            if(Arrays.equals(Cube.lCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.lCornerPositions[(i + direction + 4) % 4];
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

            if(Arrays.equals(Cube.dCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.dCornerPositions[(i + direction + 4) % 4];
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

            if(Arrays.equals(Cube.bCornerPositions[i], new int[]{this.x, this.z, this.y})){

                int[] newPos = Cube.bCornerPositions[(i + direction + 4) % 4];
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
