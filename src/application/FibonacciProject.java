package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * 
 * This is the FibonacciProject. This class extends Application for javaFx.
 *
 */
/**
 * 
 * @author Mike Hodges
 * @version 1.0000001
 */
public class FibonacciProject extends Application {
//	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * This is the start method that calls the Launch method to start the stand alone application.
	 */
	public void start(Stage primaryStage) {
	        primaryStage.setTitle("FibonacciProject");
//          Number of iteration to test
	        int n = 45;

//          Setup chart	 label etc...        

	        NumberAxis yAxis =new NumberAxis(0, n+5, 5);
	        yAxis.setLabel("Nth Degree");
	        NumberAxis xAxis =new NumberAxis(-500, 4000,500);
	        xAxis.setLabel("Tine in Nano Seconds");
	        LineChart chart = new LineChart(yAxis, xAxis);
	        chart.setCreateSymbols(false);
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Ititeration");
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Recursion");	        
	        
//	        start  Start time in nanoseconds.
//	        finish Finish time in nanoseconds.
//	        timeElapsed Elapsed time in nanoseconds.
	        
	        long start; 
	        long finish;
	        long timeElapsed;
	        		
	        		

	        
	        
	        
//	        Iterate while checking the times for a recursive verses an iterative function. Add data to the chart with each iteration. 
	        
	        for (int i = 0; i <= n; i++) {
		        
	        	start = System.nanoTime();
	        	fibonacciIteration(i);
		        finish = System.nanoTime();
		        timeElapsed= finish - start;

		        
	        	series1.getData().add(new XYChart.Data<Integer,Long>(i,timeElapsed));
	        	
	        	start = System.currentTimeMillis();
	        	System.out.println(start);
	        	System.out.println(finish);
		        fibonacciRecursion(i);
		        finish = System.currentTimeMillis();
		        timeElapsed= finish - start;
		        System.out.println(timeElapsed);
		        System.out.println(i);
				
				series2.getData().add(new XYChart.Data<Integer,Long>(i,timeElapsed));
				
			}
	        
//          Add data to chart and display	        
	        chart.getData().addAll(series1,series2);
            Group root = new Group(chart);
            Scene scene = new Scene(root,550,450); 
			primaryStage.setScene(scene);
			primaryStage.show();	
	}
	/**
	 * Fibonacci  Series using Recursion. 
	 * @param nthNumber Represents place value of the nthNuber Fibonacci in the sequence. 
	 * @return Returns the current number plus the current number minus one. When called recursively returns nthNuber Fibonacci in the sequence.
	 */
	public static int fibonacciRecursion( int nthNumber) {
        if (nthNumber <= 1) {
        	return nthNumber;
		}
		if(nthNumber == 2){
				return 1;
		}
		
        return fibonacciRecursion(nthNumber - 1) + fibonacciRecursion(nthNumber - 2);
    }
	/**
	 * Fibonacci  Series using Iteration. 
	 * @param nthNumber Represents place value of the nthNuber Fibonacci in the sequence. 
	 * @return Returns returns nthNuber in the Fibonacci sequence.
	 */
	 public static int fibonacciIteration(int nthNumber) {
	        //use loop
	        int previouspreviousNumber, previousNumber = 0, currentNumber = 1;

	        for (int i = 1; i < nthNumber ; i++) {
	        	
//	        	 On each iteration, we are assigning second number
//	             to the first number and assigning the sum of last two
//	             numbers to the second number
	             

	            previouspreviousNumber = previousNumber;

	            previousNumber = currentNumber;

	            currentNumber = previouspreviousNumber + previousNumber;

	        }
	        return currentNumber;
	    }
	 /**
	  * 
	  * The application's entry point
      * @param args an array of command-line arguments for the application
	  *  
	  */
	public static void main(String[] args) {
		launch(args);
	}
}
