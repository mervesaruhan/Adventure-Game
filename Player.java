import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjinalHealth;
    private  int money;
    private String name;
    private String charName;
    private Inventory inventory;

    private Scanner input = new Scanner(System.in);


    public Player(String name){
        this.name= name;
        this.inventory = new Inventory();
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public  void setDamage(int damage){
        this.damage = damage;
    }


    public int getHealth(){
        return health;
    }

    public  void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }


    public int getMoney(){
        return money;
    }

    public  void setMoney(int money) {
        this.money = money;
    }

    public  String getName(){
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public String getCharName(){
        return charName;
    }

    public void setCharName(String charName){
        this.charName = charName;
    }

    public Inventory getInventory(){return inventory;}
    public void setInventory(Inventory inventory){this.inventory = inventory;}

    public void selectChar(){
//        Samurai samurai = new Samurai();
//        Archer archer = new Archer();
//        Knight knight = new Knight();
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Karakterler: ");
        System.out.println("-----------------------------------------------------------------------------------");
        for (GameChar gameChar:charList){
            System.out.println("Id: " + gameChar.getId() +
                    "\t\t Karakter: " + gameChar.getName() +
                    "\t\t Hasar: " + gameChar.getDamage() +
                    "\t\t Sağlık: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());
        }

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Lütfen bir karakter giriniz: ");
        int selectChar = input.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

            default:
                initPlayer(new Samurai());
        }

        System.out.println("Karakter: " +  this.getCharName() +
                "\t Hasar: " + this.getDamage() +
                "\t Sağlık: " +  this.getHealth() +
                "\t Para: " + this.getMoney());

    }



//    public void selectLoc(){
//        Location location = null;
//        System.out.println("Bölgeler:");
//        System.out.println("1- Güvenli Ev");
//        System.out.println("2- Mağaza");
//        System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
//        int loc = input.nextInt();
//
//        switch (loc){
//            case 1:
//                location = new Safehouse(this); //hani nesne ile kullanılıyorsa onu buraya atayacak
//                break;
//            case 2:
//                location = new ToolStore(this);
//                break;
//
//            default:
//                location = new Safehouse(this);
//
//        }
//        location.onLocation();
//    }

    public void initPlayer(GameChar gameChar){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Silahınız: " + this.getInventory().getWeapon().getName() +
                "\t Zrhıhınız: " + this.getInventory().getArmor().getName() +
                "\t Bloklama: " + this.getInventory().getArmor().getBlock() +
                "\t Hasarınız: " + this.getTotalDamage() +
                "\t Sağlıgınz: " + this.getHealth() +
                "\t Paranız: " + this.getMoney());

    }



    public Weapon getWeapon(){
        return getInventory().getWeapon();
    }


}
