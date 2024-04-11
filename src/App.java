public class App {

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(String type, String name, String beverage, String size, String dessert, String dsize, String coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (isEmptyType(type, name)) return -1;

        // si le client prends un plat en assiette
        total = getTotal(type, size, dsize, total);
        total = getCoffePromo(type, size, dsize, coffee, total);
        return total;
    }



    private int getCoffePromo(String type, String size, String dsize, String coffee, int total) {
        if (!coffee.equals("yes")) {
            total += 1;
        }
        if (type.equals("assiette") && size.equals("moyen") && dsize.equals("normal") && coffee.equals("yes")) {
            System.out.print(" avec café offert!");
        }
        return total;
    }

    private int getTotal(String type, String size, String dsize, int total) {
        FormuleType formuleType;
        try {
            formuleType = FormuleType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return total; // ou lancez une nouvelle exception
        }
        switch (formuleType) {
            case FormuleType.ASSIETTE:
                total = getAssietteTotal(size, dsize, total);
                break;
            case FormuleType.SANDWICH:
                total = getSandwichTotal(size, dsize, total);
                break;
        }
        return total;
    }

    private int getSandwichTotal(String size, String dsize, int total) {
        total += 10;
        // ainsi qu'une boisson de taille:
        if (size == "petit") {
            total += 2;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }

            // si on prends moyen
        } else if (size =="moyen") {
            total += 3;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // j'affiche la formule appliquée
                System.out.print("Prix Formule Standard appliquée ");
                // le prix de la formule est donc 13
                total = 13;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }

        } else if (size =="grand") {
            total += 4;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // dans ce cas on a la fomule max
                System.out.print("Prix Formule Max appliquée ");
                total = 16;
            }

        }
        return total ;
    }

    private int getAssietteTotal(String size, String dsize, int total) {
        total += 15;
        if (size == "petit") {

            total += 2;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }

            // si on prends moyen
        } else if (size =="moyen") {

            total += 3;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // j'affiche la formule appliquée
                System.out.print("Prix Formule Standard appliquée ");
                // le prix de la formule est donc 18
                total = 18;
            } else {
                // sinon on rajoute le prix du dessert special
                total += 4;
            }

        } else if (size =="grand") {
            total += 4;
            // dans ce cas, on applique la formule standard
            if (dsize.equals("normal")) {
                // pas de formule
                // on ajoute le prix du dessert normal
                total += 2;
            } else {
                // dans ce cas on a la fomule max
                System.out.print("Prix Formule Max appliquée ");
                total = 21;
            }

        }
        return total ;
    }

    private boolean isEmptyType(String type, String name) {
        return type == null || name == null || type.isEmpty() || name.isEmpty();
    }


}