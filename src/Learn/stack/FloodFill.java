package Learn.stack;

/**
 * 一个图像由一个二维整数数组表示，每个整数表示图像的像素值（从0到65535）。
 * 给定一个坐标（sr，sc）表示洪水填充的起始像素（行和列），以及一个像素值的新颜色，“洪水填充”图像。
 * 要执行“洪水填充”，考虑起始像素，再加上任何与起始像素相同颜色的像素，再加上任何与像素相连的像素（与初始像素相同），等等。替换所有上述的人的颜色
 * 例如：
 * Input:image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * @author zhongtao on 2018/9/13
 */
public class FloodFill {

    /**
     * 递归遍历
     *
     * @param image    图像
     * @param sr       横坐标
     * @param sc       竖坐标
     * @param newColor 新颜色
     * @return 新图像
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        // >= 是为了防止索引溢出
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }

}
