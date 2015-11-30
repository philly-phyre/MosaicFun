/**
 * Created by Phil on 11/17/2015.
 */



public class MosaicFun1 {

    private static int ROWS = 145;
    private static int COLS = 145;

    public static void main(String[] args) {
        Mosaic.open(ROWS,COLS,6,6);
        Mosaic.fill(0,1,0); // Changed 3D-effect grouting to ORANGE in Mosaic class, line 279 //

        int curRow = 0;
        int curCol = 0;

        while (Mosaic.isOpen()) {
            for (int i = 1; i<ROWS && i<COLS; i++) {
                if (curRow < 143 && curCol < 143) {
                    colorChange(curRow,curCol);
                    colorChange(i,curCol);
                    colorChange(curRow,i);
                } else if (curRow >= 143){
                    curRow = 0;
                    colorChange(curRow,curCol);
                    colorChange(i,curCol);
                    colorChange(curRow,i);
                }
                curRow++;

                for (int j = i - 1; j <COLS; j++) {
                    if (curCol < 143){
                        curCol++;
                        colorChange(curRow, curCol);
                        colorChange(i, j);
                        colorChange(j, i);
                        colorChange(j, j);
                        colorChange(i, i);
                } else if (curCol >= 143) {
                        curCol = 0;
                        colorChange(curRow, curCol);
                        colorChange(i, j);
                        colorChange(j, i);
                        colorChange(j, j);
                        colorChange(i, i);
                    }
                    break;
                } // end for2 //
            } // end for1 //
        } // end while loop //

    } // end main() routine //

    static int step = 6;

    static void colorChange(int x,int y) {
        int red = Mosaic.getRed(x,y);
        int green = Mosaic.getGreen(x,y);
        int blue = Mosaic.getBlue(x,y);


        if (red <= 0 && blue <= 0 && green <= 0) {
            step = 6;
        }
        if (red >= 239 && blue >= 239 && green >= 239) {
            step = -6;
        }

        if (red <= green) {
            Mosaic.setColor(x, y, red+(step),green,blue);
        } else if (green<=blue) {
            Mosaic.setColor(x, y, red,green+(step),blue);
        } else {
            Mosaic.setColor(x, y, red, green, blue + (step));
        }

    } // end colorChange(x,y) routine //


} // end MosaicFun1 class //