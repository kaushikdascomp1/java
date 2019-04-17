import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class DiceRoller {


    public static void main(String args[]) throws Exception{
             diceRoller("3D8-2D4+4D6");
    }


    public static void diceRoller(String exp) throws Exception{
        String strarr[] ={""};
        String dice[] = {""};
        int max=0;
        int min = 0;
        if(exp.trim().contains("+") && !exp.contains("-")) {
            String[] result = Arrays.stream(exp.split("[+]")).map(String::trim).toArray(String[]::new);
            showMinMax(result,min,max,1);
        }  else if(exp.contains("-") && !exp.contains("+")){
             String[] result = Arrays.stream(exp.split("[-]")).map(String::trim).toArray(String[]::new);
            showMinMax(result,min,max,0);
        }else if(exp.trim().contains("+") && exp.contains("-"))  {

        }
    }

    public static void showMinMax(String[] result, int min, int max, int operator) throws Exception {
         String dice[] = {""};
        for(int i=0;i<result.length;i++){
            int currMax=0;
            int currMin=0;
            dice = result[i].split("[Dd]");
            if(Integer.parseInt(dice[0]) <= 0){
                  throw new Exception("Dice doesn't makes sense" + dice[0]);
            }
            if((dice[1].equals("4") || dice[1].equals("6") || dice[1].equals("8") || dice[1].equals("10") || dice[1].equals("12") || dice[1].equals("20")) && Integer.parseInt(dice[1])> 0) {
                currMax = Integer.parseInt(dice[0]) * Integer.parseInt(dice[1]);
                currMin = Integer.parseInt(dice[0]);
                if(operator == 1){
                 min += currMin;
                 max += currMax;
                }  else if(operator == 0) {
                   min = currMin-min;
                   max = currMax-max;
                 }
            } else {
                throw new Exception("Dice not supported:" + dice[1]);
            }

        }
        System.out.println(Math.abs(min));
        System.out.println(Math.abs(max));
    }
}
