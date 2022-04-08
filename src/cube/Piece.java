package cube;

public abstract class Piece {

    static final Colors[] xColors = new Colors[]{Colors.ORANGE, null, Colors.RED};
    static final Colors[] zColors = new Colors[]{Colors.BLUE, null, Colors.GREEN};
    static final Colors[] yColors = new Colors[]{Colors.WHITE, null, Colors.YELLOW};

    int x;
    int z;
    int y;
    int solvedX;
    int solvedZ;
    int solvedY;
    int xOrientation;
    int zOrientation;
    int yOrientation;
    Colors xColor;
    Colors zColor;
    Colors yColor;
    Colors[] colorsMapped;

    public Piece(int x, int z, int y){

        this.solvedX = this.x = x;
        this.solvedZ = this.z = z;
        this.solvedY = this.y = y;
        this.xColor = xColors[x];
        this.zColor = zColors[z];
        this.yColor = yColors[y];
        this.colorsMapped = new Colors[]{this.xColor, this.zColor, this.yColor};
        int xOrientation = 0;
        int zOrientation = 0;
        int yOrientation = 0;

    }

    protected boolean isSolved(){

        boolean permutation = this.x == this.solvedX && this.z == this.solvedZ && this.y == this.solvedY;
        boolean orientation = this.xOrientation == 0 && this.zOrientation == 0 && this.yOrientation == 0;

        return permutation && orientation;

    }

    protected int getxOrientation(){

        return this.xOrientation;

    }

    protected int getzOrientation(){

        return this.zOrientation;

    }

    protected int getyOrientation(){

        return this.yOrientation;

    }

    protected int getX(){

        return this.x;

    }

    protected int getZ(){

        return this.z;

    }

    protected int getY(){

        return this.y;

    }

    protected Colors getxColor(){

        return this.xColor;

    }

    protected Colors getzColor(){

        return this.zColor;

    }

    protected Colors getyColor(){

        return this.yColor;

    }

    public Colors[] getColorsMapped(){

        return this.colorsMapped;

    }

    protected void orientColors(char axis){

        Colors buffer;

        if(axis == 'x'){

            buffer = this.colorsMapped[1];
            this.colorsMapped[1] = this.colorsMapped[2];
            this.colorsMapped[2] = buffer;

        }else if(axis == 'z'){

            buffer = this.colorsMapped[0];
            this.colorsMapped[0] = this.colorsMapped[2];
            this.colorsMapped[2] = buffer;

        }else if(axis == 'y'){

            buffer = this.colorsMapped[0];
            this.colorsMapped[0] = this.colorsMapped[1];
            this.colorsMapped[1] = buffer;

        }

    }

    abstract void turnR(int direction);
    abstract void turnU(int direction);
    abstract void turnF(int direction);
    abstract void turnL(int direction);
    abstract void turnD(int direction);
    abstract void turnB(int direction);

}
