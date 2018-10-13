package com.example.harshitagrawal.quickmeds_doc;

import java.util.ArrayList;

public class PrescriptionList {
    String docName;
    ArrayList<String> medicine;
    ArrayList<String> medQuantity;
    public PrescriptionList()
    {

    }

    public PrescriptionList(String docName, ArrayList<String> medicine, ArrayList<String> medQuantity) {
        this.docName = docName;
        this.medicine = medicine;
        this.medQuantity = medQuantity;
    }

    public String getDocName() {
        return docName;
    }

    public ArrayList<String> getMedicine() {
        return medicine;
    }

    public ArrayList<String> getMedQuantity() {
        return medQuantity;
    }
}
