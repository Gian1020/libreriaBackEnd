package org.example.demo.utility;

import java.time.LocalDate;


public class Utility {
    public static Boolean dateCoerenti(LocalDate dataInizio, LocalDate dataFine){
        if(dataFine != null && dataFine.isBefore(dataInizio)){
           return false;
        }
        return true;
    }
}
