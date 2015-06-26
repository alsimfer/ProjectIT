package util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class UtilFunctions {
	
	/**
	 * Random int in the given range excluding... 
	 * @param start start of range (inclusive)
	 * @param end end of range (exclusive)
	 * @param excludes numbers to exclude
	 * @return the random number within start-end but not one of excludes
	 */
	public static int nextIntInRangeButExclude(int start, int end, int... excludes){
p(Arrays.toString(excludes));		
	    int rangeLength = end - start - excludes.length;
	    int randomInt = new Random().nextInt(rangeLength) + start;

	    for(int i = 0; i < excludes.length; i++) {
	        if(excludes[i] > randomInt) {
	            return randomInt;
	        }

	        randomInt++;
	    }

	    return randomInt;
	}
	
	public static String date2String(Date date) {
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
  
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String dateString = df.format(date);

		return dateString;		
	}
	
	/**
	 * Get locale for DB input. English = en, german = de, russian = ru.
	 * @param String language A language.
	 * @return String
	 */
	public static String getLocale(String language) {
		String locale = "en";
		switch (language) {
	    	case "english": locale = "en";
			break;
		
			case "german": locale = "de";
			break;
		
			case "russian": locale = "ru";
			break;
			
			default: locale = "en";
	        break;
		}
		
		return locale;
	}
	
	/**
	 * Concatenate 2 int arrays.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] concatIntArrays(int[] a, int[] b) {
	   int aLen = a.length;
	   int bLen = b.length;
	   int[] c= new int[aLen+bLen];
	   System.arraycopy(a, 0, c, 0, aLen);
	   System.arraycopy(b, 0, c, aLen, bLen);
	   return c;
	}
	
	/**
	 * Convert ArrayList of Integers to primitive array.
	 * 
	 * @param integers
	 * @return 
	 */
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    Iterator<Integer> iterator = integers.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
	
	// Invalidate session
	public static void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}	
	
	/**
	 * Round the double value to the definite amount of decimal points.
	 * 
	 * @param number A number to be rounded.
	 * @param digits Amount of decimal places.
	 * @return	 	 
	 */
	public static double formatDecimal(double number, int digits) {
		String format = "#.";
		
		for (int i = 0; i < digits; i++) {
			format += "0";
		}
		
		DecimalFormat df = new DecimalFormat(format);
		String formattedString = df.format(number);
		formattedString = formattedString.replaceAll(",", ".");

		number = Double.valueOf(formattedString);
		return number;
	}
	
	// Reset all beans with all scopes.
	public static void clear() {
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	}
	
	// Get slug of the current page.
	public static String getCurrentSlug()
	{
	    String URL = getRequestURL();
	    String slug = URL.substring(URL.lastIndexOf("/") + 1);
	    return slug;
	}
	
	// Get request URL.
	public static String getRequestURL()
	{
	    Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    if(request instanceof HttpServletRequest) {
            return ((HttpServletRequest) request).getRequestURL().toString();
	    } else {
	        return "";
	    }
	}
	
	// Prints 2D-array out. Debugging.
    public static void print2DArray(Object [][] dataToPrint)
    {
    	for (int i = 0; i < dataToPrint.length; i++) {
    		for (int j = 0; j < dataToPrint[0].length; j++) {
    			System.out.printf("%10S", dataToPrint[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    // Prints 2D-array out. Debugging.
    // ((Integer) obj).intValue();
    public static void print2DArray(int[][] dataToPrint)
    {
    	for (int i = 0; i < dataToPrint.length; i++) {
    		for (int j = 0; j < dataToPrint[0].length; j++) {
    			System.out.printf("%10S", dataToPrint[i][j]);
    		}
    		System.out.println();
    	}
    }
    
	// Prints ArrayList out. Debugging.
    public static void printArrayList(ArrayList<Object> dataToPrint)
    {
    	for (int i = 0; i < dataToPrint.size(); i++) {
			System.out.printf("%10S", (String) dataToPrint.get(i));
    	}
    }
    
	// Prints array out. Debugging.
    public static void printArray(Object [] dataToPrint)
    {
    	for (int i = 0; i < dataToPrint.length; i++) {
    		System.out.printf("%10S", dataToPrint[i].toString());    		
    	}
    }
    
    // Prints array out. Debugging.
    public static void printArray(double [] dataToPrint)
    {
        for (int i = 0; i < dataToPrint.length; i++) {
            System.out.printf("%10S", String.valueOf(dataToPrint[i]));           
        }
    }
    
    public static void p(String s)
    {
    	System.out.println(s);
    }
    
    public static void p(int s)
    {
    	System.out.println(String.valueOf(s));
    }
    
    public static void p(double s)
    {
    	System.out.println(Double.valueOf(s));
    }
    
    public static void pf(String s)
    {
    	System.out.printf("%10s", s);
    }
    
    public static BufferedImage resizeImage(BufferedImage img, int newW, int newH)
    {
	    int w = img.getWidth();
	    int h = img.getHeight();
	    if (newH == 0) {
	    	double proportion = w / newW;
	    	newH = (int) (h / proportion);
	    }
	    if (newW == 0) {
	    	double proportion = h / newH;
	    	newW = (int) (w / proportion);
	    }
	    
	    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
	    Graphics2D g = dimg.createGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
	    g.dispose();
	    return dimg;      
    }
   
}
