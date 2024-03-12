package org.basix.Library;

public class CommandBase {

    CrudTools servicer;
    ServicerImpl servicerImpala;

    ScannerKaHelper scan;

    public CommandBase() {
        scan = new ScannerKaHelper();
    }

    public void start(){

        System.out.println("Hi there\nWant Some Help\nType Y for Yes or N for No");

      /*  while (true){
//            String helpResponse = scan.callingScanner();
            if(scan.callingScanner().equals("Y")){
                System.out.println("What You Want, INSERT(IN), DELETE(DL), LIST OF ALL(LS)");
//                String helpResponse1 = scan.callingScanner();
                switch (scan.callingScanner()){
                    case "IN":
                        System.out.println("Insertion");
                        servicerImpala = new ServicerImpl();
                        System.out.println(servicerImpala.create());
                        System.out.println(servicerImpala.read("Books"));
                        System.out.println("One record inserted successfully\n");
                        break;
                    case "DL":
                        System.out.println("Deletion");
                        break;
                    case "LS":
                        System.out.println("Listing");
                        break;
                }

                break;
            } else if (scan.callingScanner().equals("N")) {
                exit();
                break;
            }else{
                ErrorCommand();
                continue;
            }
        }*/

    }
    public void exit(){
        System.out.println("Existing");
    }

    public void ErrorCommand(){
        System.out.println("Wrong Command Dalle");
    }

}
