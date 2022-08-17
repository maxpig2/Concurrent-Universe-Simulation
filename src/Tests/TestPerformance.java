package Tests;

import datasets.DataSetLoader;
import model.Model;
import org.junit.jupiter.api.Test;

public class TestPerformance {
    double TimeSerial[] = new double[TestHelper.NTESTS];
    double TimeParallel[] = new double[TestHelper.NTESTS];
    int parallelIsFaster = 0;
    int serialIsFaster = 0;
    int equalTimes = 0;

    @Test
    void TestPerformance() {

        DataSetLoader.isParallel = false;

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            Model m = TestHelper.getModel(i);
            TimeSerial[i] = TestHelper.runTest(m);
        }

        DataSetLoader.isParallel = true;

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            Model m = TestHelper.getModel(i);
            TimeParallel[i] = TestHelper.runTest(m);
        }

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            System.out.println("Time for Serial:" + TimeSerial[i] + "  Time for Parallel:" + TimeParallel[i] + "  Time Difference:" + (TimeSerial[i] - TimeParallel[i]));
            if (TimeSerial[i] == TimeParallel[i]) {
                equalTimes++;
            } else if (TimeSerial[i] > TimeParallel[i]) {
                parallelIsFaster++;
            } else if (TimeSerial[i] < TimeParallel[i]) {
                serialIsFaster++;
            }


        }
        System.out.println("\nInstances where Parallel is faster:" + parallelIsFaster);
        System.out.println("Instances where Serial is faster:" + serialIsFaster);
        System.out.println("Instances where Parallel and Serial are equal:" + equalTimes);

    }
}
