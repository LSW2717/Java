package Player;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Poketmonster poketmon;
    private List<Bag> bag = new ArrayList<>();
    private String name;

    public void setBag(Bag bag){
        this.bag.add(bag);
    }
    public void removeBag(Bag bag){
        this.bag.remove(bag);
    }

    public Player(){}
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void attackCommand(Poketmonster poketmon){
        System.out.println("가라 " + poketmon.getName() + " " + poketmon.getSkillName());
        System.out.println(poketmon.getName() + "가 " + poketmon.getPoketmonATK() + "데미지를 주었다." );
    }
    public void useMedicineCommand(Poketmonster poketmon, Medicine medicine){
        medicine.useItem(poketmon.getName());
        int currentHP = poketmon.getPoketmonHP() + medicine.getRecoverHP();
        poketmon.setPoketmonHP(currentHP);
        if(poketmon.getPoketmonHP() > 100){
            poketmon.setPoketmonHP(100);
            System.out.println(poketmon.getName() + "의 HP가 " + poketmon.getPoketmonHP() + "이 되었다.");
        }
        else{
            System.out.println(poketmon.getName() + "의 HP가 " + poketmon.getPoketmonHP() + "이 되었다.");
        }
    }
    public void useMonsterballCommand(Monsterball monsterball, String target){
        monsterball.useItem(target);
    }
}
