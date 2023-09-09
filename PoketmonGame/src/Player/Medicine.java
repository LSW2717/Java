package Player;

public class Medicine extends Bag {
    private int recoverHP;
    public Medicine(String name, int recoverHP){
        setName(name);
        setRecoverHP(recoverHP);
    }
    public int getRecoverHP() {
        return recoverHP;
    }

    public void setRecoverHP(int HP) {
        this.recoverHP = HP;
    }

    @Override
    public void useItem(String target){
        System.out.println( target +" 에게 " + this.getName() + "을 사용했다.");
        System.out.println("체력을" + this.getRecoverHP() + "만큼 회복했다!");

    }
}
