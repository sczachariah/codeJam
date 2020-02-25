package com.sczachariah;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that is used to store the INFO message of opatchauto session log in their execution order
 */
class StartStopExecutionOrder implements Comparable<StartStopExecutionOrder> {
    private int serialNo;
    private String statusCode;
    private String actionCode;
    private String targetSource;
    private String targetValues;

    public StartStopExecutionOrder() {
        this.serialNo = 0;
        this.statusCode = null;
        this.actionCode = null;
        this.targetSource = null;
        this.targetValues = null;
    }

    public StartStopExecutionOrder(String statusCode, String actionCode, String targetSource, String targetValues) {
        this.statusCode = statusCode;
        this.actionCode = actionCode;
        this.targetSource = targetSource;
        this.targetValues = targetValues;
    }

    /**
     * Getter Method
     */
    public int getSerialNo() {
        return serialNo;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getTargetSource() {
        return targetSource;
    }

    public String getTargetValues() {
        return targetValues;
    }

    /**
     * Setter Method
     */
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public void setTargetSource(String targetSource) {
        this.targetSource = targetSource;
    }

    public void setTargetValues(String targetValues) {
        this.targetValues = targetValues;
    }

    @Override
    public String toString() {
        return "{" + serialNo + ", " + statusCode + ", " + actionCode + ", " + targetSource + ", " + targetValues + "}";
    }

    @Override
    public int compareTo(StartStopExecutionOrder object) {
        int result = 1;

        /** succeed success-stop compared with success_no_action-stop for same targets */
        if (this.getStatusCode().equalsIgnoreCase("SUCCESS_NO_ACTION")) {
            if (this.getActionCode().equalsIgnoreCase("STOP") && this.getActionCode().equals(object.getActionCode()) &&
                    this.targetSource.equalsIgnoreCase(object.targetSource) && this.targetValues.equalsIgnoreCase(object.targetValues))
                return 0;
        }

        if ((this.getStatusCode().compareToIgnoreCase(object.getStatusCode()) < 0) || (this.getActionCode().compareTo(object.getActionCode()) < 0) ||
                (this.getTargetSource().compareToIgnoreCase(object.getTargetSource()) < 0) || (this.getTargetValues().compareToIgnoreCase(object.getTargetValues()) < 0)) {
            result = -1;
        } else if (this.getStatusCode().compareToIgnoreCase(object.getStatusCode()) == 0) {
            if (this.getActionCode().compareTo(object.getActionCode()) == 0) {
                if (this.getTargetSource().compareToIgnoreCase(object.getTargetSource()) == 0) {
                    if (this.getTargetValues().compareToIgnoreCase(object.getTargetValues()) == 0) {
                        result = 0;
                    }
                }
            }
        }
        return result;
    }
}


public class Template {

    public static void main(String[] args) throws Exception {
        List<StartStopExecutionOrder> inputList = new ArrayList<>();
        List<StartStopExecutionOrder> outputList = new ArrayList<>();

        //Case1 - MATCH
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));
//
//        outputList.add(new StartStopExecutionOrder("SUCCESS_NO_ACTION", "STOP", "Server", "Server1"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));

        //Case 2 - MATCH
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));
//
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS_NO_ACTION", "STOP", "Server", "Server1"));

        //Case 3 - MATCH
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));
//
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));

        //Case 4 - MATCH
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));
//
//        outputList.add(new StartStopExecutionOrder("SUCCESS_NO_ACTION", "STOP", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS_NO_ACTION", "STOP", "Server", "Server1"));


        //Case 5 - NOT MATCH
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
//        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));
//
//        outputList.add(new StartStopExecutionOrder("SUCCESS_NO_ACTION", "STOP", "Server", "Server1"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
//        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));

        //Case 6 - NOT MATCH
        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
        inputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
        inputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));

        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "Server1"));
        outputList.add(new StartStopExecutionOrder("SUCCESS", "STOP", "Server", "AdminServer"));
        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "AdminServer"));
        outputList.add(new StartStopExecutionOrder("SUCCESS", "START", "Server", "Server1"));


        System.out.println("Input List  : " + inputList.toString());
        System.out.println("Output List : " + outputList.toString());

        if (compareListsHelper(inputList, outputList))
            System.out.println("NOT MATCH");
        else
            System.out.println("MATCH");
    }


    public static boolean compareListsHelper(List<StartStopExecutionOrder> inputStartStopSequenceList, List<StartStopExecutionOrder> startStopExecutionOrderList) throws Exception {
        boolean diffFound = false;

        /** identity which server start to ignore */
        List<String> ignoreStart = new ArrayList<>();
        for (int i = 0; i < startStopExecutionOrderList.size(); i++) {
            if (startStopExecutionOrderList.get(i).getActionCode().equalsIgnoreCase("STOP") &&
                    startStopExecutionOrderList.get(i).getStatusCode().equalsIgnoreCase("SUCCESS_NO_ACTION") &&
                    startStopExecutionOrderList.get(i).getTargetSource().equalsIgnoreCase("Server")) {
                ignoreStart.add(startStopExecutionOrderList.get(i).getTargetValues());
            }
        }

        /** modify input list to remove those server whose start is to be ignored */
        List<StartStopExecutionOrder> expectedStartStopSequenceList = new ArrayList<>();
        for (StartStopExecutionOrder object : inputStartStopSequenceList) {
            if (ignoreStart.contains(object.getTargetValues()) &&
                    object.getActionCode().equalsIgnoreCase("START"))
                continue;
            expectedStartStopSequenceList.add(object);
        }

        System.out.println("Expected List : " + expectedStartStopSequenceList.toString());

        /** ideally list size should be same. Throw exception if otherwise */
        if (startStopExecutionOrderList.size() != expectedStartStopSequenceList.size()) {
            System.out.println("inputStartStopSequenceList contents     :  " + inputStartStopSequenceList.toString());
            System.out.println("expectedStartStopSequenceList contents  :  " + expectedStartStopSequenceList.toString());
            System.out.println("startStopExecutionOrderList contents    :  " + startStopExecutionOrderList.toString());
            throw new Exception("\n[INFO] : Sizes of provided lists is not same. Please check the above list sequences!!");
        }

        /** size of lists for comparision */
        int listSize = expectedStartStopSequenceList.size();

        /** loop through two lists for comparison and finding out the diff set from lists */
        for (int i = 0; i < listSize; i++) {
            if (!(startStopExecutionOrderList.get(i).compareTo(expectedStartStopSequenceList.get(i)) == 0)) {
                diffFound = true;
                System.out.println("[INFO] : There is a mismatch in the below listed sequences. Please check!!!");
                System.out.println("inputStartStopSequenceList.get(" + i + ")     :    " + inputStartStopSequenceList.get(i).toString());
                System.out.println("expectedStartStopSequenceList.get(" + i + ")  :    " + expectedStartStopSequenceList.get(i).toString());
                System.out.println("startStopExecutionOrderList.get(" + i + ")    :    " + startStopExecutionOrderList.get(i).toString());
                break;
            }
        }
        if (!diffFound) {
            System.out.println("[INFO] : Both Lists contain same contents (There is no mismatch found in the provided lists for comparison)");
            System.out.println("inputStartStopSequenceList contents     :  " + inputStartStopSequenceList.toString());
            System.out.println("expectedStartStopSequenceList contents  :  " + expectedStartStopSequenceList.toString());
            System.out.println("startStopExecutionOrderList contents    :  " + startStopExecutionOrderList.toString());
        }
        return diffFound;
    }


}
