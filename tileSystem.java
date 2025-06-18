import java.util.ArrayList;

class tileSystem{
    public static int width = 8;
    public static int height = 7;
    public static char[][] pixels = new char[height][width];
    public static ArrayList<Integer> tiles = new ArrayList<Integer>();
    
    public static char[][] level = {{' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' '},
                                    {' ', ' ', 'x', ' '},
                                    {'#', '#', '#', '#'},};
    
    public static void main(String[] args){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                pixels[i][j] = '.';
            }
        }

        //adding tiles
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (level[i][j] == '#'){
                    addTile(0, 2*j, -2*i);
                }
                else if (level[i][j] == 'x'){
                    addTile(1, 2*j, -2*i);
                }
            }
        }

        //rendering each tile
        for (int i = 0; i < tiles.size(); i += 3){
            if (tiles.get(i) == 0){
                drawRect(tiles.get(i+1), tiles.get(i+2), 2, 2, '#');
            }
            else if (tiles.get(i) == 1){
                drawRect(tiles.get(i+1), tiles.get(i+2), 2, 2, 'x');
            }
        }

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.print(pixels[i][j]);
            }
            System.out.println();
        }
    }

    static void setPixel(int x, int y, char sym){
        pixels[Math.abs(y)][x] = sym;
    }

    static void drawRect(int x, int y, int width, int height, char sym){
        for (int i = x; i < x + width; i++){
            for (int j = y; j < y + height; j++){
                setPixel(i, j, sym);
            }
        }
    }

    static void addTile(int type, int x, int y){
        tiles.add(type);
        tiles.add(x);
        tiles.add(y);
    }
}