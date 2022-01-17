package com.codegym;

import java.util.ArrayList;
import java.util.Scanner;

public class CadreManagement {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Cadre> cadres;

    public CadreManagement() {
        this.cadres = new ArrayList<>();
    }

    public CadreManagement(ArrayList<Cadre> cadres) {
        this.cadres = cadres;
    }

    public ArrayList<Cadre> getCadres() {
        return cadres;
    }

    public void setCadres(ArrayList<Cadre> cadres) {
        this.cadres = cadres;
    }
    public void addNewCadres(Cadre newCadre){
        cadres.add(newCadre);
    }
    public void displayAllCadres(){
        for (int i = 0; i < cadres.size(); i++) {
            System.out.println((i+1)+". "+ cadres.get(i));
        };
    }
    public int findNameCadre(String name){
        int index = -1;
        for (int i = 0; i < cadres.size(); i++) {
            if (cadres.get(i).equals(name)){
                index = i;
            }
        }
        return index;
    }

}
