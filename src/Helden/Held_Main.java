package Helden;

import java.util.ArrayList;

public class Held_Main {
    public static void main(String[] args) {
        String file= "H:\\AufgabenblattD\\helden.xml";
        ArrayList<Held> held;

        Held_Parser heldParser=new Held_Parser();

        try{
            heldParser.parse(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        held=heldParser.getHelden();


        for(int i=0;i<held.size();i++){
            System.out.println(held.get(i));
        }
    }



}
