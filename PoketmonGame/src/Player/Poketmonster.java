package Player;

public class Poketmonster extends Player {
    private int HP;
    private int ATK;
    private String skillName;

    public Poketmonster(String name, int HP, int ATK, String skillName) {
        super(name);
        this.HP = HP;
        this.ATK = ATK;
        this.skillName = skillName;
    }

    public int getPoketmonHP() {
        return HP;
    }

    public void setPoketmonHP(int HP) {
        this.HP = Math.max(HP, 0);
    }

    public int getPoketmonATK() {
        return ATK;
    }

    public void setPoketmonATK(int ATK) {
        this.ATK = ATK;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
