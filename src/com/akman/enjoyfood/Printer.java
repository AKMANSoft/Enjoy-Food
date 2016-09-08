/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood;

import java.awt.Image;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;

/**
 *
 * @author AKMAN
 */
public class Printer {

    /**
     * @param args the command line arguments
     */
    
    String name;
    Image image;
    Boolean status;

    public Printer(String name,Boolean status ) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    

    @Override
    public String toString() {
        return name;
    }
    
        class MyPrintJobListener implements PrintJobListener {

        @Override
        public void printDataTransferCompleted(PrintJobEvent pje) {
            System.out.println("printDataTransferCompleted");
        }

        @Override
        public void printJobCanceled(PrintJobEvent pje) {
            System.out.println("The print job was cancelled");
        }

        @Override
        public void printJobCompleted(PrintJobEvent pje) {
            System.out.println("The print job was completed");
        }

        @Override
        public void printJobFailed(PrintJobEvent pje) {
            System.out.println("The print job has failed");
        }

        @Override
        public void printJobNoMoreEvents(PrintJobEvent pje) {
        }

        @Override
        public void printJobRequiresAttention(PrintJobEvent pje) {
        }
    }
    

}
