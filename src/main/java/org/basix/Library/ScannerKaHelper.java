package org.basix.Library;

import java.util.Scanner;

public class ScannerKaHelper {

    Scanner scanner;
    String scannerResponse;

    public ScannerKaHelper() {
        scanner = new Scanner(System.in);
    }
    public String callingScanner(){
        scannerResponse = scanner.nextLine();
        return scannerResponse;
    }
}
