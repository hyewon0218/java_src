package prj;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomName {
	   
	   public static void main(String[] args) {
	      
	      String[] name1 = { "kim", "chio", "jeong", "gong", "ham", "cha" };
	      String[] name2 = { "0727", "77", "0118", "0218", "0101", "999", "0900" };
	      
	      Random r = new Random();
	      String id = "";
	      
	      Set<String> ids = new HashSet<String>();
	      
	      while(true) {
	         id = name1[r.nextInt(name1.length)]+name2[r.nextInt(name2.length)];

	         ids.add(id);
	         
	         if (ids.size() == 20) {
	            break;
	         }
	      }
	      System.out.println(ids);
	   }
	}
