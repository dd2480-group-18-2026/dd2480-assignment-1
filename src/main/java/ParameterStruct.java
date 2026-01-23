
public class ParameterStruct {
    public double LENGTH_1;
    public double LENGTH_2;
    public double RADIUS_1;
    public double RADIUS_2;
    public double EPSILON;
    public double AREA_1;
    public double AREA_2;
    public int QUADS;
    public double DIST;
    public int A_PTS;
    public int B_PTS;
    public int C_PTS;
    public int D_PTS;
    public int E_PTS;
    public int F_PTS;
    public int G_PTS;
    public int K_PTS;
    public int N_PTS;
    public int Q_PTS;

    public ParameterStruct(
        double length1,
        double length2, 
        double radius1,
        double radius2,
        double epsilon, 
        double area1,
        double area2,
        int quads, 
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

    public ParameterStruct() {
        this.LENGTH_1   = 0;
        this.LENGTH_2   = 0;
        this.RADIUS_1   = 0;
        this.RADIUS_2   = 0;
        this.EPSILON    = 0;
        this.AREA_1     = 0;
        this.AREA_2     = 0;
        this.QUADS      = 0;
        this.DIST       = 0;
        this.A_PTS      = 0;
        this.B_PTS      = 0;
        this.C_PTS      = 0;
        this.D_PTS      = 0;
        this.E_PTS      = 0;
        this.F_PTS      = 0;
        this.G_PTS      = 0;
        this.K_PTS      = 0;
        this.N_PTS      = 0;
        this.Q_PTS      = 0;
    }
}
