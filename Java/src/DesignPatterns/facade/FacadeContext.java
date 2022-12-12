package DesignPatterns.facade;

public class FacadeContext {

   private Facade additon;
   private Facade substraction;

   public FacadeContext(){
      additon = new Addition();
      substraction = new Substraction();
   }

   public void addition(int a, int b){
      this.additon.doOperation(a,b);
   }

   public void substraction(int a, int b){
      this.substraction.doOperation(a,b);
   }

}
