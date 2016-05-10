import java.util.Random;



public class _MathBFGL{

    public static float _roundDown(float input){
        float result;
        int temp = (int)input;
        result = temp;
        return result;
    }
    public static float _round(float input){
        float result;
        result = Math.round(input);
        return result;
    }
    public static float _sqrt(float input){
        float result;
        double temp = input;
        result = (float) Math.sqrt(temp);
        return result;
    }
    public static float _roundUp(float input){
        float result;
        result = (float) Math.ceil(input);
        return result;
    }
    public static float _pwr(float input, float toThePowerOf){
        float result;
        result = (float) Math.pow(input, toThePowerOf);
        return result;
    }
    public static float _getRandomNum(float upperbound){
        float result;
        Random rand = new Random();
        result = rand.nextInt((int) upperbound);
        return result;
    }
}