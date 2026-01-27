public class Interceptor {
   public static String decide(int numPoints, Point[] points, ParameterStruct parameters, Connectors[][] lcm, boolean[] puv) {
      boolean[] cmv = new boolean[15];
      boolean[][] pum = new boolean[15][15];
      boolean[] fuv = new boolean[15];

      // Get Condition Met Vector (evaluate all LICs)
      for (int i = 0; i < cmv.length; i++) {
         cmv[i] = LicHelper.calculateLIC(parameters, numPoints, points, i);
      }
      
      for (int i = 0; i < cmv.length; i++) {
         System.out.println("CMV[" + i + "]: " + cmv[i]);
      }

      // Get Preliminary Unlocking Matrix (use CMV and LCM)
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

      // System.out.println("LCM[1][2]: " + lcm[1][2]);
      // System.out.println("PUM[1][2]: " + pum[1][2]);

      // Get Final Unlocking Vector (use PUM and PUV)
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
}
