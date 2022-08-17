package Tests;

import datasets.DataSetLoader;
import org.junit.jupiter.api.Test;
import model.Model;

public class TestCorrectness {
    double EnergySerial[] = new double[TestHelper.NTESTS];
    double EnergyParallel[] = new double[TestHelper.NTESTS];

    @Test
    void TestCorrectness(){

        DataSetLoader.isParallel = false;

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            Model m = TestHelper.getModel(i);
            TestHelper.runTest(m);
            EnergySerial[i] = m.energy();
        }

        DataSetLoader.isParallel = true;

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            Model m = TestHelper.getModel(i);
            TestHelper.runTest(m);
            EnergyParallel[i] = m.energy();
        }

        for (int i = 0; i < TestHelper.NTESTS; i++) {
            assert (EnergySerial[i]==EnergyParallel[i] );
        }




    }

}
