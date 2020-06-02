package com.login.utility;

import java.util.List;

import Jama.Matrix;
import Jama.QRDecomposition;

import com.conn.pojo.Admissions;
import com.conn.pojo.Patients;

public class MultipleLinearRegression {
    private final Matrix beta;  // regression coefficients
    private double sse;         // sum of squared
    private double sst;         // sum of squared

   /**
     * Performs a linear regression on the data points {@code (y[i], x[i][j])}.
     * @param  x the values of the predictor variables
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public MultipleLinearRegression(double[][] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("matrix dimensions don't agree");
        }

        // number of observations
        int n = y.length;

        Matrix matrixX = new Matrix(x);

        // create matrix from vector
        Matrix matrixY = new Matrix(y, n);

        // find least squares solution
        QRDecomposition qr = new QRDecomposition(matrixX);
        beta = qr.solve(matrixY);


        // mean of y[] values
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += y[i];
        double mean = sum / n;

        // total variation to be accounted for
        for (int i = 0; i < n; i++) {
            double dev = y[i] - mean;
            sst += dev*dev;
        }
        System.out.println("SST "+sst);

        // variation not accounted for
        Matrix residuals = matrixX.times(beta).minus(matrixY);
        sse = residuals.norm2() * residuals.norm2();
        System.out.println("SSE "+sse);


    }

   /**
     * Returns the least squares estimate of &beta;<sub><em>j</em></sub>.
     *
     * @param  j the index
     * @return the estimate of &beta;<sub><em>j</em></sub>
     */
    public double beta(int j) {
        return beta.get(j, 0);
    }

   /**
     * Returns the coefficient of determination <em>R</em><sup>2</sup>.
     *
     * @return the coefficient of determination <em>R</em><sup>2</sup>,
     *         which is a real number between 0 and 1
     */
   /**
     * Unit tests the {@code MultipleLinearRegression} data type.
     *
     * @param args the command-line arguments
     */
   public static int calculateLos(Admissions admission,Patients patient, List<Double[]> multipleAttributes,List<Double> existingLos) {
         
	    
		double[][] multipleAttributes_array =  new double[existingLos.size()][];
		double[] existing_los =  new double[existingLos.size()];
         for (int f=0;f<existingLos.size();f++)
         {
        	 Double d[] =  multipleAttributes.get(f);
        	 multipleAttributes_array[f]= new double[]{1,d[0],d[1],d[2]};
        	 existing_los[f] = existingLos.get(f);
         }
        
         System.out.print("constant age admissiontype gender los");
         for(int w=0;w<multipleAttributes_array.length;w++) {
        	 for(int k=0;k<multipleAttributes_array[w].length;k++) {
        		 System.out.print(multipleAttributes_array[w][k] +" ");	 
        	 }
        	 System.out.print(existing_los[w]);
        	 System.out.println();
         }
         
        
         MultipleLinearRegression regression = new MultipleLinearRegression(multipleAttributes_array, existing_los);
		 
		  double b0=regression.beta(0); 
		  double b1=regression.beta(1); 
		  double b2=regression.beta(2);
		  double b3=regression.beta(3);
		  String admisssionType  = admission.getAdmission_type();
		  double at = admisssionType.equals("EMERGENCY")?1:admisssionType.equals("NEWBORN")?2:admisssionType.equals("ELECTIVE")?3:4;
  	      double gender = patient.getGender().equals("M")?1:2;
  	      
  	    
		  double los_double = b0 + (b1*patient.getAge()) + (b2*at) + (b3*gender);
		  return (int) los_double;
		  
		 
    }
}
