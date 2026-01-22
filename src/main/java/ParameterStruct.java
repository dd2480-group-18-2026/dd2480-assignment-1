
public class ParameterStruct {
    public final double LENGTH_1;
    public final double LENGTH_2;
    public final double RADIUS_1;
    public final double RADIUS_2;
    public final double EPSILON;
    public final double AREA_1;
    public final double AREA_2;
    public final double QUADS;
    public final double DIST;
    public final int A_PTS;
    public final int B_PTS;
    public final int C_PTS;
    public final int D_PTS;
    public final int E_PTS;
    public final int F_PTS;
    public final int G_PTS;
    public final int K_PTS;
    public final int N_PTS;
    public final int Q_PTS;

    public ParameterStruct(
        double length1,
        double length2, 
        double radius1,
        double radius2,
        double epsilon, 
        double area1,
        double area2,
        double quads, 
        double dist, 
        int aPts, 
        int bPts,
        int cPts,
        int dPts,
        int ePts,
        int fPts,
        int gPts,
        int kPts, 
        int nPts,
        int qPts
    ) {
        this.LENGTH_1 = length1;
        this.LENGTH_2 = length2;
        this.RADIUS_1 = radius1;
        this.RADIUS_2 = radius2;
        this.EPSILON = epsilon;
        this.AREA_1 = area1;
        this.AREA_2 = area2;
        this.QUADS = quads;
        this.DIST = dist;
        this.A_PTS = aPts;
        this.B_PTS = bPts;
        this.C_PTS = cPts;
        this.D_PTS = dPts;
        this.E_PTS = ePts;
        this.F_PTS = fPts;
        this.G_PTS = gPts;
        this.K_PTS = kPts;
        this.N_PTS = nPts;
        this.Q_PTS = qPts;
    }
}
