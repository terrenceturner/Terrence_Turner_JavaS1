package com.company.composition.inheirtance;

import javafx.scene.shape.Arc;

public class App {


    public static void main(String[] args) {
        Developer dev = new Developer();
        TeamLead lead = new TeamLead();
        Architect arch = new Architect();




        lead.chceckInCode();
        lead.assignWork();



        dev.chceckInCode();
        lead.estimatestoryPoints();



        StaffMember aMember = new Developer();
        StaffMember teamLead = new TeamLead();






    }







}
