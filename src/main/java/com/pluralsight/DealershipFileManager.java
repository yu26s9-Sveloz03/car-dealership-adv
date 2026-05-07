package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {


    public Dealership getDealership() {
        try {
            FileReader fileReader = new FileReader("dealership.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstLine = bufferedReader.readLine();
            String[] dealershipInfo = firstLine.split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0],dealershipInfo[1],dealershipInfo[2]);
            return dealership;
        } catch (Exception e) {
            System.out.println("Can't find the file.");

        }

    }
}
