package Wildmonster;

public class Wildmonster {
    private String name;
    private int HP;
    private int ATK;

    public Wildmonster(String name, int HP, int ATK) {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
    }

    public String getWildmonName() {
        return name;
    }

    public void setWildmonName(String name) {
        this.name = name;
    }

    public int getWildmonHP() {
        return HP;
    }

    public void setWildmonHP(int HP) {
        if(HP < 0){
            this.HP = 0;
        }
        else {
            this.HP = HP;
        }
    }

    public int getWildmonATK() {
        return ATK;
    }

    public void setWildmonATK(int ATK) {
        this.ATK = ATK;
    }
    public void attack(Wildmonster wildmonster){
        System.out.println(wildmonster.getWildmonName() + "가 " + wildmonster.getWildmonATK() + "데미지를 주었다." );
    }
}
