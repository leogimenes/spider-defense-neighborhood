package spiderdefenseneighborhood.sdnweb.immutable;

import java.util.*;

public class ImmutableTest {
	
	public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        ImmutablePassword p = new ImmutablePassword(101, "Senha", map);
        System.out.println(p.getId());
        System.out.println(p.getPassword());
        System.out.println(p.getHashMap());
        
        // Uncommenting below line causes error
        // s.regNo = 102;
        
        map.put("3", "third");
        System.out.println(p.getHashMap()); // Remains unchanged due to deep copy in constructor
 
        p.getHashMap().put("4", "fourth");
        System.out.println(p.getHashMap()); // Remains unchanged due to deep copy in getter
        
        //Objeto "p" não consegue ser alterado depois que criado
    }
	

}
