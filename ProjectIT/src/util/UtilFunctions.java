package util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class UtilFunctions {
	
	/**
	 * @param start start of range (inclusive)
	 * @param end end of range (exclusive)
	 * @param excludes numbers to exclude
	 * @return the random number within start-end but not one of excludes
	 */
	public static int nextIntInRangeButExclude(int start, int end, int... excludes){
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
	
	/**
	 * Convert ArrayList of Integers to primitive array.
	 * @param integers
	 * @return int array
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
