//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Pd2BrendanMcIntyreExplore {
    public static void main(String[] args) {
        System.out.println(exploreCount(0, 0, 10, 10));
        System.out.print(explorePath(0, 0, 10, 10, ""));
    }

    public static int exploreCount(int startX, int startY, int endX, int endY){
        int count= 0;
        if(startX == endX && startY == endY){
            return count + 1;
        }
        if(startX < endX && startY < endY){
            count += exploreCount(startX + 1, startY + 1, endX, endY);
        }
        if (startX < endX){
            count += exploreCount(startX + 1, startY, endX, endY);
        }
        if (startY < endY) {
            count += exploreCount(startX , startY + 1, endX, endY);
        }
        return count;
    }

    public static String explorePath(int startX, int startY, int endX, int endY, String path){
        if(startX == endX && startY == endY){
            return path;
        }
        if(startX < endX && startY < endY){
            path += "NE";
            explorePath(startX + 1, startY + 1, endX, endY, path);
        }
        if (startX < endX){
            path += "E";
            explorePath(startX + 1, startY, endX, endY, path);
        }
        if (startY < endY) {
            path += "N";
            explorePath(startX , startY + 1, endX, endY, path);
        }
        return path;
    }
}