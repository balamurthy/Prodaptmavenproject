package dateTimeExamples;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
	    public static void main(String[] args) {  
	        LocalDateTime now = LocalDateTime.now();  
	        System.out.println("Before Formatting: " + now);  
	       // DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");  
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
	        String formatDateTime = now.format(format);  
	        System.out.println("After Formatting: " + formatDateTime);  
	    
	        
	    // Assignment : sop Good morning if <12, Good Afternoon if >=12
	        //and Good evening if >=3
	        //Good night if >=7
	        
	        //Stage no 2 - store the actual Greeting value in a property file or
	        //a string and compare with expected Greeting 
	        int curtime = LocalTime.now().getHour();
	        
	        
	        String greet;
	        
	        if (curtime < 12)
	        {
	        
	        	greet="Good morning";
	
	
	        
	        }
	        else if (curtime >=12 && curtime <16)
	        {
	        	greet="Good Afternoon";
	        }
	        else if (curtime >=16 && curtime <=19)
	        {
	        	greet = "Good Evening";
	        	
	        }
	        else 
	        {
	        	greet = "Good Night";
		        
	        }
	        
	        
	        
	        
	        System.out.println("Expecting " +  greet);
	        
	        
	    }  
	}  


