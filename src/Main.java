public class Main {

    public static void main(String[] args) {
        // pour tester, lancer en ligne de commande :
        // java Program "assiette" "couscous" "coca" "moyen" "baba" "normal" "yes"
        // Note: Make sure the class name matches the file name when compiling and running in Java.
        App app = new App();
        int price = app.Compute("assiette", "couscous", "moyen", "normal", "yes");
        System.out.println("Prix à payer : " + price + "€");
    }
}