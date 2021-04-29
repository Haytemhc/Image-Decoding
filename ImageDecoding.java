import java.io.*;
import java.util.*;
import java.math.*;

public class problemC {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int counter = 1;
        while(true) {
            
            int rowCount = Integer.parseInt(in.readLine());
            if(rowCount == 0) break;
            if(counter != 1) out.println();
            int length = 0;
            
            boolean error = false;
            for(int line = 0; line < rowCount; line++) {
                
                String[] input = in.readLine().split(" ");
                
                boolean ishash = input[0].equals("#");
                int tempLength = 0;
                for(int j = 1; j < input.length; j++) {
                    
                    int reps = Integer.parseInt(input[j]);
                    if(line == 0)length += reps;
                    
                    out.print((ishash) ? "#".repeat(reps) : ".".repeat(reps)); //Tenerary operator returns the repeated pixels
                    ishash = !ishash;
                    tempLength += reps;
                }
                if(line != 0 && tempLength != length) error = true; //trigger error if not first line
                tempLength = 0;
                out.println();
            }
            if(error)out.println("Error decoding image");
            counter++;
        }
        out.close();
    }
}
