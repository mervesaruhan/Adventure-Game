public class Armor {
    private int id;
    private String name;
    private int block;

    private int price;

    public Armor(int id,  String name,int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static  Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Hafif",1,15);
        armorList[1] = new Armor(2,"Orta",3,25);
        armorList[2] = new Armor(3,"Güçlü",5,40);
        return armorList;
    }


    public static Armor getArmorObjById(int id){
        for(Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }



    public int getId() {
        return id;
    }

    public int getBlock() {
        return block;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
