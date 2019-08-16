package com.company.composition.inheirtance;

//establishing a is-a relationship w/ another object
public class TeamLead extends Developer {

    public void planSprint(){


    }

    public void assignWork(){

    }


    public void estimatestoryPoints() {
        System.out.println("Estimating my story points as Team Lead");
        System.out.println("Make sure everyone on my team has estimated story points");
    }


    TeamLead(){

        System.out.println("Constructor for TeamLead");
    }

    @Override
    public void chceckInCode() {
        super.chceckInCode();
    }





}
