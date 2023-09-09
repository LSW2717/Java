import Player.*;
import Wildmonster.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("지우");
        Player player2 = new Player("웅이");

        Poketmonster poketmon1 = new Poketmonster("피카츄", 100, 100, "백만볼트");
        Poketmonster poketmon2 = new Poketmonster("꼬부기", 100, 60, "하이드로펌프");
        Poketmonster poketmon3 = new Poketmonster("파이리", 100, 50, "파이어볼");

        Wildmonster wildmon1 = new Wildmonster("아보크", 100, 40);
        Wildmonster wildmon2 = new Wildmonster("또가스", 100, 20);

        Monsterball masterball = new Monsterball("마스터볼");
        Monsterball superball = new Monsterball("슈퍼볼");

        Medicine jamongfruit = new Medicine("자몽열매", 30);

        //게임 시작
        GameStart(player1, poketmon2, wildmon2, masterball, jamongfruit);
    }


    public static void getBattle(Player player, Poketmonster poketmon, Wildmonster wildmonster) {
        player.attackCommand(poketmon);
        wildmonster.attack(wildmonster);
        int currentPoketmonHP = poketmon.getPoketmonHP() - wildmonster.getWildmonATK();
        int currentWildmonHP = wildmonster.getWildmonHP() - poketmon.getPoketmonATK();
        poketmon.setPoketmonHP(currentPoketmonHP);
        wildmonster.setWildmonHP(currentWildmonHP);
        System.out.println(poketmon.getName() + "의 HP가" + poketmon.getPoketmonHP() + "가 되었다!");
        System.out.println(wildmonster.getWildmonName() + "의 HP가" + wildmonster.getWildmonHP() + "가 되었다!");
    }

    public static void GameStart(Player player, Poketmonster poketmon, Wildmonster wildmonster, Monsterball monsterball, Medicine medicine) {
        int mosterCount = 0;
        System.out.println(player.getName() + "앞에 야생의 " + wildmonster.getWildmonName() + "가 나타났다!");
        System.out.println("1. 싸운다 2. 도망간다");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> {
                while (true) {
                    if(mosterCount == 1){
                        break;
                    }
                    System.out.println("1. 공격하기 2. 가방");
                    switch (scanner.nextInt()) {
                        case 1 -> {
                            getBattle(player, poketmon, wildmonster);
                        }
                        case 2 -> {
                            System.out.println("1. 몬스터볼, 2. 상처약");
                            switch (scanner.nextInt()) {
                                case 1 -> {
                                    if (wildmonster.getWildmonHP() == 0) {
                                        player.useMonsterballCommand(monsterball, wildmonster.getWildmonName());
                                        mosterCount++;
                                    } else {
                                        System.out.println("아직 잡을 수 없어!");
                                    }
                                }
                                case 2 -> {
                                    player.useMedicineCommand(poketmon, medicine);
                                }
                            }

                        }
                    }
                }
            }
            case 2 -> {
                System.out.println("무사히 빠져나왔다!");
            }
        }
    }

}
