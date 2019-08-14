package com.company;

public class BootCampLearner {

    public static String classNotes = null;
    public String learnersNotes = null;

    public String getLearnersNotes() {
        return learnersNotes;
    }

    public void setLearnersNotes(String learnersNotes) {
        this.learnersNotes = learnersNotes;
    }


    public void learnJava(){

    }

    //Main method is the entry point
    public static void main(String[] args){

        classNotes = " Learn Java today " ;

        BootCampLearner john = new BootCampLearner();
        john.setLearnersNotes("My Notes on iPad ");

        BootCampLearner zeus = new BootCampLearner();
        zeus.setLearnersNotes("My Notes on Macbook");

        zeus.setLearnersNotes(classNotes);
        System.out.println("all objects can refer me : " + classNotes);

        zeus.setLearnersNotes("I am still working on it ");

        System.out.println("You need zeus to see zeus : "
                + "\'s " + "notes :" + zeus.getLearnersNotes());

    }
}

