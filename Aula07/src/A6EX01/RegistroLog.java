package A6EX01;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RegistroLog {
	
	public static void registrar(String descricao) {
		try {
            File arquivo = new File("./src/A6EX01/registro-log.txt");
            
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            
			FileWriter arq = new FileWriter("./src/A6EX01/registro-log.txt", true);
			BufferedWriter bw = new BufferedWriter(arq);
        	
        		Calendar cal = Calendar.getInstance();
        		
        		String dataHora = new SimpleDateFormat("[dd/MM/yyyy - HH:mm:ss]").format(cal.getTime()); 
        		
        		bw.write(dataHora + descricao);
        		bw.close();
        		
        		
        		
		} catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        	
}
}
