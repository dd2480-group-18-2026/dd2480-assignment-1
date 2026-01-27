public class Interceptor {
   public static String decide(int numPoints, Point[] points, ParameterStruct parameters, Connectors[][] lcm, boolean[] puv) {
      boolean[] cmv = new boolean[15];
      boolean[][] pum = new boolean[15][15];
      boolean[] fuv = new boolean[15];

      populateCmv(cmv, parameters, numPoints, points);
      
      
      for (int i = 0; i < cmv.length; i++) {
         System.out.println("CMV[" + i + "]: " + cmv[i]);
      }

      populatePum(pum, cmv, lcm);

      populateFuv(fuv, pum, puv);
      

      System.out.println("");
      for (int i = 0; i < fuv.length; i++) {
         System.out.println("FUV[" + i + "]: " + fuv[i]);
      }

      // Get launch decision (all FUV elements are true)
      for (boolean licMet : fuv) {
         if (!licMet) {
            return "NO";
         }
      }

      return "YES";
   }

   private static void populateCmv(boolean[] cmv, ParameterStruct parameters, int numPoints, Point[] points) {
      for (int i = 0; i < cmv.length; i++) {
         cmv[i] = LicHelper.calculateLIC(parameters, numPoints, points, i);
      }
   }

   private static void populatePum(boolean[][] pum, boolean[] cmv, Connectors[][] lcm) {
      for (int i = 0; i < pum.length; i++) {
         for (int j = 0; j < pum[i].length; j++) {
            switch (lcm[i][j]) {
               case Connectors.ANDD:
                  pum[i][j] = cmv[i] && cmv[j];
                  break;
               case Connectors.ORR:
                  pum[i][j] = cmv[i] || cmv[j];
                  break;
               case Connectors.NOTUSED:
                  pum[i][j] = true;
                  break;
            }
         }
      }
   }

   private static void populateFuv(boolean[] fuv, boolean[][] pum, boolean[] puv) {
      for (int i = 0; i < pum.length; i++) {
         boolean fuvLicMet = true;
         if (puv[i]) {    
            for (int j = 0; j < pum[i].length; j++) {
               if (!pum[i][j]) {
                  fuvLicMet = false;
                  break;
               }
            }
         }
         fuv[i] = fuvLicMet;
      }
   }
}
