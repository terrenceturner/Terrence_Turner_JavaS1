package com.company.composition.inheirtance;

public class Developer extends StaffMember {

    public void estimatestoryPoints(){

        System.out.println("Estimating Story points");

    }

    public void chceckInCode(){

    }

    private void privateMethod(){

    }

    protected void protectedMethod(){

    }

    @Override
    public void submitTimeCard() {
        System.out.println("Submitting card...");
    }
}
