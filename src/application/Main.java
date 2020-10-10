package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
/**
 * 
 * @author Mike
 * @version 1.0000001
 * 
 * 
 * 
 * 
 */



public class Main extends Application {
	Button button1;	

//	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start(Stage primaryStage) {
	        primaryStage.setTitle("Nth Degree");
//	        Defining Axis
	        int n = 45;
	        NumberAxis yAxis =new NumberAxis(0, n+5, 5);
	        yAxis.setLabel("Nth Degree");

	        NumberAxis xAxis =new NumberAxis(-500, 4000,500);
	        xAxis.setLabel("Tine in Nano Seconds");

	        
	        
       
	        StackedAreaChart chart = new StackedAreaChart(yAxis, xAxis);
	        
	        //prepare XYChart.Series objects by setting data 
	        
	        long start; 
	        // ...
	        long finish;
	        long timeElapsed;
	        		
	        		
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Ititeration");
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Recursion");
	        
	        
	        
	        for (int i = 0; i <= n; i++) {
		        
	        	start = System.currentTimeMillis();
	        	fibonacciLoop(i);
		        finish = System.currentTimeMillis();
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
	        
	        
	        chart.getData().addAll(series1,series2);
     
	        Group root = new Group(chart);
   
        
	        Scene scene = new Scene(root,600,600);        
			primaryStage.setScene(scene);
			primaryStage.show();	
	}
	public static int fibonacciRecursion( int nthNumber) {
        //use recursion
        if (nthNumber == 0) {

            return 0;

        } else if (nthNumber == 1) {

            return 1;
        }   
     return fibonacciRecursion(nthNumber - 1) + fibonacciRecursion(nthNumber - 2);
    }
	
	 public static int fibonacciLoop(int nthNumber) {
	        //use loop
	        int previouspreviousNumber, previousNumber = 0, currentNumber = 1;

	        for (int i = 1; i < nthNumber ; i++) {

	            previouspreviousNumber = previousNumber;

	            previousNumber = currentNumber;

	            currentNumber = previouspreviousNumber + previousNumber;

	        }
	        return currentNumber;
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
