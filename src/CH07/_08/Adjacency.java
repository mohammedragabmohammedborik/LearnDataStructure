package CH07._08;

/**
 * Create by xong on 2018/4/16
 */
public class Adjacency {
   final int INFINITE = 99999;
   public int[][] graphMatrix;
   public Adjacency(int[][] weightPath, int number) {

       graphMatrix = new int[number][number];

       for (int i = 1; i < number; i++) {
           for (int j = 1; j < number; j++) {
               if (i != j) {
                   graphMatrix[i][j] = INFINITE;
               } else {
                   graphMatrix[i][j] = 0;
               }
           }
       }

       for (int i = 0; i < number; i++) {
           int startPoint = weightPath[i][0];
           int endPoint = weightPath[i][1];
           graphMatrix[startPoint][endPoint] = weightPath[i][2];
       }

   }
   public void printGraphMatrix() {
       for (int i = 1; i < graphMatrix.length; i++) {
           for (int j = 1; j < graphMatrix[i].length; j++) {
               if (graphMatrix[i][j] == INFINITE) {
                   System.out.print("x ");
               } else {
                   if (graphMatrix[i][j] == 0) {
//                       System.out.print(" ");
                   }
                   System.out.print(graphMatrix[i][j] + " ");
               }
           }
           System.out.println();
       }
   }
}
