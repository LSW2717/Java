package Player;

public class Monsterball extends Bag {
    public Monsterball(String name) {
        setName(name);
    }
    @Override
    public void useItem(String target){
        System.out.println(this.getName() + "을 사용했다.");
        System.out.println("신난다 " + target + "을 잡았다!");
    }
}
