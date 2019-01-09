package wybory;

import java.util.*;
import java.util.stream.IntStream;

public class dHondt {


    private static float calcNewValue(int votes, int mandates)
    {
        return (float) ((votes*1.0) / (mandates + 1.0));
    }

    public static void main(String[] args) {
        int mandates[];
        int votes[];
        List<Integer> finalVotes = new LinkedList<>();
        float calcTab[];
        float max;
        int threshold;
        int groupCount, mandatesCount, maxInd = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe partii");
        groupCount = scanner.nextInt();

        System.out.println("Podaj próg wyborczy");
        threshold = scanner.nextInt();

        mandates = new int[groupCount];
        votes = new int[groupCount];
        calcTab = new float[groupCount];

        System.out.println("Podaj liczbe mandatow");
        mandatesCount = scanner.nextInt();

        for (int i=0; i<groupCount; i++)
        {
            System.out.println("Podaj liczbe glosow na partie " + (i+1));
            votes[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int z : votes) {
            sum += z;
        }
        //int sum2 = IntStream.of(votes).sum();

        for (int x : votes) {
            if (x >= threshold){
                finalVotes.add(x);
            }
        }
        for (int y: finalVotes) {
            System.out.println(y);
        }
        for (int i = 1; i < finalVotes.size(); i++) {
            votes[i] = finalVotes.get(i);
        }
        for (int c : votes) {
            System.out.println(c);
        }

        for (int i=0; i<finalVotes.size(); i++)
        {
            mandates[i] = 0;
        }
        /*for (int i=0; i<groupCount; i++)
        {
            mandates[i] = 0;
        }*/

        for (int i=0; i<finalVotes.size(); i++)
        {
            calcTab[i] = votes[i];
        }
        for (int i=0; i<mandatesCount; i++)
        {

            max = -1;
            for (int j=0; j<finalVotes.size(); j++)
            {
                if (max<calcTab[j])
                {
                    max = calcTab[j];
                    maxInd = j;
                }
            }

            mandates[maxInd]++;
            calcTab[maxInd] = calcNewValue(votes[maxInd], mandates[maxInd]);
        }

        for (int i=0; i<finalVotes.size(); i++)
        {
            System.out.println("Partia " + (i+1) + " ma " + mandates[i] + " mandatow");
        }
    }

}

