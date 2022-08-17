package Tests;

import datasets.DataSetLoader;
import model.Model;

public class TestHelper {
    public static final int NTESTS=9;
    public static final int NSTEPS=100000;

    public static Model getModel(int n) {
        Model m=null;
        switch (n) {
            case 0:
                m = DataSetLoader.getRegularGrid(100, 800, 40);//Try those configurations
                break;
            case 1:
                m = DataSetLoader.getRandomRotatingGrid(0.02d,100, 800, 40);
                break;
            case 2:
                m = DataSetLoader.getRandomRotatingGrid(0.02d, 100, 800, 30);
                break;
            case 3:
                m = DataSetLoader.getElaborate(200, 700, 2, 0.99);
                break;
            case 4:
                m = DataSetLoader.getElaborate(200, 700, 2, 0.99005);
                break;
            case 5:
                m = DataSetLoader.getElaborate(200, 700, 2, 0.99008);
                break;
            case 6:
                m = DataSetLoader.getRandomSet(100, 800, 1000);
                break;
            case 7:
                m = DataSetLoader.getRandomSet(100, 800, 100);
                break;
            case 8:
                m = DataSetLoader.getRandomGrid(100, 800, 30);
        }
        return m;
    }
    public static long runTest(Model m) {
        long time0 = System.currentTimeMillis();
        for (int j = 0; j < TestHelper.NSTEPS; j++) {
            m.step();
        }
        long time1 = System.currentTimeMillis();
        System.out.println("Time:"+ (time1 - time0) / 1000.0 + "s, "+m.p.size()+" particles left, final energy="+m.energy());
        return  (time1 - time0);
    }
}
