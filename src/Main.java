public class Main {

    public static void main(String[] args) {
        // pour tester, lancer en ligne de commande :
        // java Program "assiette" "couscous" "coca" "moyen" "baba" "normal" "yes"
        // Note: Make sure the class name matches the file name when compiling and running in Java.
        MealApp mealApp = new MealApp();
        int price = mealApp.Compute("assiette", "couscous", "moyen", "normal", "yes");
        System.out.println("\nPrix à payer : " + price + "€");
    }
}