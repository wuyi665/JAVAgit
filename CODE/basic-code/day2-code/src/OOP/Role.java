package OOP;

import java.util.Random;

public class Role {
    private String name;
    private int blood;
    private char gender;
    private String face;


    public Role(String name, int blood, char gender, String face) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void attack(Role role) {
        Random r = new Random();
        int random = r.nextInt(50) + 1;
        int blood = role.getBlood() - random;
        if (blood <= 0) {
            System.out.println(this.name + " 攻击了 " + role.getName() + ",造成了" + random + "点伤害");
            System.out.println(name + "DIED!");
            blood = 0;
        } else {
            System.out.println(this.name + " 攻击了 " + role.getName() + ",造成了" + random + "点伤害");
            System.out.println(name + "还剩" + blood + "点血量");
        }
        role.setBlood(blood);
    }
}
