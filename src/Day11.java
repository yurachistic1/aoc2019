import javax.swing.*;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;

public class Day11 {

    public static void day11a(){
        IntCodeComputer intCodeComputer = new IntCodeComputer("./inputs/Day11.txt", 0);
        intCodeComputer.setInterruptAfterOutput(true);

        PVector currentLocation = new PVector(0, 0);
        PVector direction = new PVector(0, 1);

        double left = 90;
        double right = -90;

        int black = 0;

        int turnLeft = 0;

        int output = 0;
        int input = 0;


        HashMap<PVector, Integer> visited = new HashMap<>();

        while(!intCodeComputer.isTerminated()){

            input = visited.getOrDefault(currentLocation, black);

            intCodeComputer.setInput(input);

            intCodeComputer.executeProgram();
            output = (int)intCodeComputer.getOutput();

            visited.put(new PVector(currentLocation.getX(), currentLocation.getY()), output);

            intCodeComputer.executeProgram();
            output = (int)intCodeComputer.getOutput();

            if (output == turnLeft){
                direction.rotate(left);
            } else {
                direction.rotate(right);
            }
            currentLocation.add(direction);
        }

        System.out.println(visited.size());

    }

    public static void day11b(){
        IntCodeComputer intCodeComputer = new IntCodeComputer("./inputs/Day11.txt", 0);
        intCodeComputer.setInterruptAfterOutput(true);

        PVector currentLocation = new PVector(0, 0);
        PVector direction = new PVector(0, 1);

        double left = 90;
        double right = -90;

        int black = 0;

        int turnLeft = 0;

        int output = 0;
        int input = 0;


        HashMap<PVector, Integer> visited = new HashMap<>();
        visited.put(new PVector(currentLocation.getX(), currentLocation.getY()), 1);

        while(!intCodeComputer.isTerminated()){

            input = visited.getOrDefault(currentLocation, black);

            intCodeComputer.setInput(input);

            intCodeComputer.executeProgram();
            output = (int)intCodeComputer.getOutput();

            visited.put(new PVector(currentLocation.getX(), currentLocation.getY()), output);

            intCodeComputer.executeProgram();
            output = (int)intCodeComputer.getOutput();

            if (output == turnLeft){
                direction.rotate(left);
            } else {
                direction.rotate(right);
            }
            currentLocation.add(direction);
        }

        System.out.println(visited.size());
        System.out.println(visited);

        JFrame jFrame = new JFrame();

        TileForDay11 tiles = new TileForDay11(visited);
        jFrame.getContentPane().add(tiles);

        jFrame.setResizable(false);
        jFrame.setSize(800, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}