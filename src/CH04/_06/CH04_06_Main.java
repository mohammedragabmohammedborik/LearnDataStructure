package CH04._06;

/**
 * Create by xong on 2018/4/9
 * 后放入的皇后，必须考虑所放位置直线方向，横线方向，或对角线方向是否已被放置过皇后
 */
public class CH04_06_Main {
    public static void main(String[] args) {
        Queens queens = new Queens(8);
        System.out.println(queens.getNumber());
    }
}
