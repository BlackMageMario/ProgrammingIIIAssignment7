/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmeent7;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eamonn Hannon
 */

public class Main {
    private static int numChefs = 2;
    private static String fileLocation = "src/orderList.txt";
    public static void main(String... args)
    {
        BufferedReader file;
        ArrayBlockingQueue<String> orders = new ArrayBlockingQueue<String>(1000);
        try {
            FileReader in = new FileReader(fileLocation);
            file = new BufferedReader(in);
            String line;
            while((line = file.readLine()) != null)
            {
                orders.offer(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayBlockingQueue<Server> servers = new ArrayBlockingQueue<Server>(10);
        Server katie = new Server("Katie", numChefs);
        Server andrew = new Server("Andrew", numChefs);
        Server emily = new Server("Emily", numChefs);
        servers.offer(katie);
        servers.offer(andrew);
        servers.offer(emily);//all our servers are up and ready at this point
        //pass to our chiefs
        Chef mark = new Chef("Mark", orders, servers);
        Chef john = new Chef("John", orders, servers);
    }
}
