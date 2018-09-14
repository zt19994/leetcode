package Learn.stack;

/**
 * 填充 sr 横 sc 竖
 *
 * @author zhongtao on 2018/9/13
 */
public class FloodFill {

    /**
     * 递归遍历
     *
     * @param image    图片
     * @param sr       横
     * @param sc       竖
     * @param newColor 新颜色
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }

}
