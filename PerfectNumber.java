package zajecia01;

public class PerfectNumber {
    public static void perfectNumber(){
        int count = 0;
        for(int i = 1; count < 8; i++) {
            long number = (long) (Math.pow(2,i) * (Math.pow(2,i +1) - 1));
           // System.out.println(number);
            if(check(number)){
                System.out.println(number);
                count++;
            }
        }
    }
    public static boolean check(long number){
        long numberSum = 1;
        for(long i = 2 ; i  <=  Math.sqrt(number)  ; i++){
            if(number % i == 0) {
                numberSum += i + number / i;
            }
            if(numberSum > number) return false;
        }
        if(numberSum == number ) return true;
        return false;
    }

    public static void main(String[] args) {
        perfectNumber();

    }
}
