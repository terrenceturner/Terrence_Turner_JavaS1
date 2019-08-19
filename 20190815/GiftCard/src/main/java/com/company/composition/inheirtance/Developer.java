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



    public int blackjack(int a, int b) {

        int card = 21;

        if(a > card){
            if (b > card){
                return 0;
            } else {
                return b;
            }
        }


        if((a < card) && (b <= card)){
            return b;
        } else {
            return a;
        }

    }
}
