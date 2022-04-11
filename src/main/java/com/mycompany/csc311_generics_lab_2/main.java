/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc311_generics_lab_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soblab
 */
public class main {
    

    public static void printQueueIterator(Queue<String> theQueue) {
        Iterator<String> theIter;
        theIter = theQueue.iterator();

        while (theIter.hasNext()) {
            System.out.println(theIter.next());
        }
    }
    public static void printAndRemoveQueueIterator(Queue<String> theQueue) {
        Iterator<String> theIter;
        theIter = theQueue.iterator();

        while (theIter.hasNext()) {
            System.out.println(theIter.next());
            theIter.remove();
        }
    }
    
    public static void getRegion(int key , Map<Integer , String> theMap){
        if(theMap.get(key) != null)
            System.out.println(theMap.get(key));
        else
            System.out.println("No Element Found");
    }
    
    public static void printSetIterator(Set<String> theSet){
        Iterator<String> theIter;
        theIter = theSet.iterator();

        while (theIter.hasNext()) {
            System.out.println(theIter.next());
        }
    }
    
    public static void main(String[] args) {
        try {
            File queueFile = new File("Queue.txt");
            Scanner queueScan = new Scanner(queueFile);
            
            //Using basic queue interface, filling it, then printing the items
            Queue<String> queue = new LinkedList<>();
            while(queueScan.hasNext()){
                queue.add(queueScan.next());
            }
            printQueueIterator(queue);
            System.out.println("");
            
            //Using Priority Queue, filling it, then printing the items
            queueScan = new Scanner(queueFile);
            Queue<String> prioQueue = new PriorityQueue<>();while(queueScan.hasNext()){
                prioQueue.add(queueScan.next());
            }
            System.out.println("");
            printAndRemoveQueueIterator(prioQueue);
            System.out.println("");
            //checking if items removed
            //System.out.println(prioQueue);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            File mapFile = new File("Map.txt");
            Scanner mapScan = new Scanner(mapFile);
            
            Map<Integer,String> theMap = new HashMap<>();
            while(mapScan.hasNext()){
                int key = mapScan.nextInt();
                String region = mapScan.next();
                theMap.put(key, region);
            }
            System.out.println(theMap);
            //testing getRegion method
            System.out.println("");
            getRegion(1 , theMap);
            getRegion(2 , theMap);
            getRegion(3 , theMap);
            getRegion(4 , theMap);
            getRegion(5 , theMap);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            File setFile = new File("Set.txt");
            Scanner setScan = new Scanner(setFile);
            Set<String> theSet = new HashSet<>();
            
            while(setScan.hasNext()){
                theSet.add(setScan.next());
            }
            
            System.out.println("");
            printSetIterator(theSet);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
