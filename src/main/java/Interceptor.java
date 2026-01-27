import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Interceptor {
   private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
   private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(NUM_THREADS);
   
   public static boolean decide(int numPoints, Point[] points, ParameterStruct parameters, Connectors[][] lcm, boolean[] puv) {
      if (!(lcm.length == 15 && lcm[0].length == 15)) {
         throw new IllegalArgumentException("The LCM has the wrong dimensions.");
      }

      if (puv.length != 15) {
         throw new IllegalArgumentException("The PUV has the wrong dimensions.");
      }

      boolean[] cmv = new boolean[15];
      boolean[][] pum = new boolean[15][15];
      boolean[] fuv = new boolean[15];

      populateCmv(cmv, parameters, numPoints, points); 
      populatePum(pum, cmv, lcm);
      populateFuv(fuv, pum, puv);      

      // Get launch decision
      for (boolean licMet : fuv) {
         if (!licMet) {
            return false;
         }
      }

      return true;
   }

   private static void populateCmv(boolean[] cmv, ParameterStruct parameters, int numPoints, Point[] points) {
      List<Future<Void>> futures = new ArrayList<>(cmv.length);

      for (int i = 0; i < cmv.length; i++) {
         final int index = i;
         futures.add(THREAD_POOL.submit(() -> {
            cmv[index] = LicHelper.calculateLIC(parameters, numPoints, points, index);
            return null;
         }));
      }

      awaitFutures(futures);
   }

   private static void populatePum(boolean[][] pum, boolean[] cmv, Connectors[][] lcm) {
      List<Future<Void>> futures = new ArrayList<>(pum.length);

      for (int i = 0; i < pum.length; i++) {
         final int index = i;
         futures.add(THREAD_POOL.submit(() -> {
            for (int j = 0; j < pum[index].length; j++) {
               switch (lcm[index][j]) {
                  case Connectors.ANDD:
                     pum[index][j] = cmv[index] && cmv[j];
                     break;
                  case Connectors.ORR:
                     pum[index][j] = cmv[index] || cmv[j];
                     break;
                  case Connectors.NOTUSED:
                     pum[index][j] = true;
                     break;
               }
            }
            return null;
         }));
      }

      awaitFutures(futures);
   }

   private static void populateFuv(boolean[] fuv, boolean[][] pum, boolean[] puv) {
      List<Future<Void>> futures = new ArrayList<>(pum.length);

      for (int i = 0; i < pum.length; i++) {
         final int index = i;
         futures.add(THREAD_POOL.submit(() -> {
            boolean fuvLicMet = true;
            if (puv[index]) {    
               for (int j = 0; j < pum[index].length; j++) {
                  if (!pum[index][j]) {
                     fuvLicMet = false;
                     break;
                  }
               }
            }
            fuv[index] = fuvLicMet;
            return null;
         }));        
      }

      awaitFutures(futures);
   }

   private static void awaitFutures(List<Future<Void>> futures) {
      for (Future<Void> future : futures) {
         try {
            future.get();
         } catch (InterruptedException e) {
               System.err.println("Thread interrupted: " + e);
         } catch (ExecutionException e) {
               System.err.println("Computation threw exception: " + e.getCause());
         }
      }
   }
}
