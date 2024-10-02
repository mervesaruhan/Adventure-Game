
import java.util.Scanner;
public class Game {
    public Scanner input  = new Scanner(System.in);


    public void start(){

        System.out.println("Macera Oyununa Hoşgeldiniz...");
        System.out.print("Lütfen bir isim giriniz:");
        //String playerName = input.nextLine();

        Player player1 = new Player("Merve");
        System.out.println("Sayın " + player1.getName() + " Bu Karanlık Adaya Hoşgeldiniz !");
        System.out.println("Lütfen Karakter Seçiniz..");
        System.out.println("-----------------------------------------------------------------------------------");
        player1.selectChar();

        Location location = null;

        while (true) {
            player1.printInfo();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Bölgeler:");
            System.out.println(" ");
            System.out.println("1- Güvenli Ev ---> Düşmansız Bölge ");
            System.out.println("2- Eşya Dükkanı ---> Silah veya zırh satın alabilirsiniz. ");
            System.out.println("3- Mağara ---> Ödül: yemek. Dikkatli ol zombi çıkabilir!  ");
            System.out.println("4- Orman ---> Ödül: Odun. Dikkatli ol vampir çıkabilir!  ");
            System.out.println("5- Nehir ---> Ödül: Su. Dikkatli ol ayı çıkabilir! ");
            System.out.println("0- Çıkış Yap ---> Oyunu sonlandır. ");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int loc = input.nextInt();
            switch (loc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new Safehouse(player1);
                    break;
                case 2:
                    location = new ToolStore(player1);
                    break;
                case 3:
                    location = new Cave(player1);
                    break;
                case 4:
                    location = new Forest(player1);
                    break;
                case 5:
                    location = new River(player1);
                    break;

                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz! ");

            }

            if (location == null){
                System.out.println("Oyun bitti, yine bekleriz. ");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }
    }



}