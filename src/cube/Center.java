package cube;

public class Center extends Piece {

    public Center(int x, int z, int y){

        super(x, z, y);

    }

    protected void turnR(int direction){

        this.xOrientation = (this.xOrientation + direction + 4) % 4;

    }

    protected void turnU(int direction){

        this.yOrientation = (this.yOrientation + direction + 4) % 4;

    }

    protected void turnF(int direction){

        this.zOrientation = (this.zOrientation + direction + 4) % 4;

    }

    protected void turnL(int direction){

        this.xOrientation = (this.xOrientation + direction + 4) % 4;

    }

    protected void turnD(int direction){

        this.yOrientation = (this.yOrientation + direction + 4) % 4;

    }

    protected void turnB(int direction){

        this.zOrientation = (this.zOrientation + direction + 4) % 4;

    }

}
