/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palumbovincentdfa;
import java.io.*;
import java.util.*;

/**
 *
 * @author vince
 */
public class PalumboVincentDFA {
    public int[][] Transition = new int[20][20];
    public int alphaset, stateset;
    public ArrayList < Character > alphabet;
    public Set < Integer > finalstates;

    public void builtdfa() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of alphabets in the alphabet set: ");
        alphaset = Integer.parseInt(br.readLine());

        System.out.println("Enter the number of states in the set: ");
        stateset = Integer.parseInt(br.readLine());

        System.out.println("Next, enter all the characters in the alphabet without any spaces.\nExample: abcde NOT a b c d e");
        String alphabets = br.readLine();

        alphabet = new ArrayList < Character > ();
        for (int i = 0; i < alphabets.length(); i++) {
        alphabet.add(alphabets.charAt(i));
        }

        for (int s = 0; s < stateset; s++) {
        System.out.println("Enter the row entries of the transition table: ");
        for (int r = 0; r < alphaset; r++) {
            int int1 = Integer.parseInt(br.readLine());
            Transition[s][r] = int1;
            }
        }

    finalstates = new HashSet < Integer > ();
    System.out.println("Enter the final states of the DFA");
    System.out.println("When you are done of giving the inputs enter -2 to stop feeding final states");

    int int2 = Integer.parseInt(br.readLine());

    while (int2 != -2) {
        finalstates.add(int2);
        int2 = Integer.parseInt(br.readLine());
    }
    System.out.println(finalstates);
    DfaTest();
 }

    public void DfaTest() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int state;
        System.out.println("Enter the starting state: ");
        state = Integer.parseInt(br.readLine());

        System.out.println("Begin entering in your string of characters");
        System.out.println("In order to end the string you must place a '!' character at the end of the string");
        System.out.println("For Example: aaabbccee!");
        System.out.println("Make sure characters entered are from the alphabet\n");
        String input = br.readLine();
        int index = 0;

        try{
            while (input.charAt(index) != '!') {            
                char char1 = input.charAt(index);
                int index1 = alphabet.indexOf(char1);
                state = Transition[state][index1];
                index++; 
            }
        }
        catch (Exception e){
            System.out.println("The characters need to be from alphabet set. You entered something outside the alphabet");
        }
        

        
        System.out.println("\nThe final state after giving input is: " + state);
        if (finalstates.contains(state))
        System.out.print("Your string is accepted\n");
        else
        System.out.println("Your string is rejected\n");
    }

    public static void main(String args[]) throws Exception {
        PalumboVincentDFA raw = new PalumboVincentDFA();
        raw.builtdfa();
        
    }
}


    