import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> comArrayList = getComIntegers();
        List<Integer> humanArrayList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        for (int number : comArrayList) {
            System.out.println(number);
        }
//        int count = 0;
        int correctAnswer = 1;
        while (correctAnswer == 1) {
            int ball = 0;
            int strike = 0;
//            ++count;
//            System.out.print(count + "번째 시도 : ");
            System.out.print("숫자를 입력해주세요 : ");
            int humanInput = input.nextInt();
            String numberString = Integer.toString(humanInput);
            char[] digits = numberString.toCharArray();
            for (char digitChar : digits) {
                int digit = Character.getNumericValue(digitChar);
                humanArrayList.add(digit);
            }
            for (int i = 0; i < 3; i++) {
                if (Objects.equals(comArrayList.get(i), humanArrayList.get(i))) {
                    strike++;
                } else if (comArrayList.contains(humanArrayList.get(i))) {
                    ball++;
                }
            }
            if (strike == 3){
//                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int end = input.nextInt();
                correctAnswer = end;
            }
            else{
                if (strike == 0){
                    System.out.println(ball + "볼");
                }
                else if(ball == 0){
                    System.out.println(strike + "스트라이크");
                }
                else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
            humanArrayList.clear();
        }
    }

    private static List<Integer> getComIntegers() {
        List<Integer> comArrayList = new ArrayList<>();
        Random random = new Random();
        while (comArrayList.size() < 3) {
            int randomNumber = random.nextInt(10);
            comArrayList.add(randomNumber);
            if (comArrayList.get(0) == 0) {
                comArrayList.remove(0);
            } else if (comArrayList.contains(randomNumber)) {
                continue; // 중복된 숫자인 경우 다시 랜덤한 숫자 생성
            }
        }
        return comArrayList;
    }
}
