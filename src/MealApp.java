import enums.FormuleType;
import enums.SizeType;

public class MealApp {

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(String type, String name, String size, String dsize, String coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (isEmptyType(type, name)) return -1;

        // si le client prends un plat en assiette
        total = getTotal(type, size, dsize, total);
        total = getCoffePromo(type, size, dsize, coffee, total);
        return total;
    }


    private int getTotal(String type, String size, String dsize, int total) {
        FormuleType formuleType;
        try {
            formuleType = FormuleType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Type de formule inconnu");
            return -1; // type de formule inconnu
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
        SizeType sizeType;
        try {
            sizeType = SizeType.valueOf(size.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Type de taille inconnu");
            return -1; // type de taille inconnu
        }
        // ainsi qu'une boisson de taille:
        total = getTotalFromSizeType(dsize, total, sizeType);
        return total ;
    }

    private int getAssietteTotal(String size, String dsize, int total) {
        total += 15;
        SizeType sizeType;
        try {
            sizeType = SizeType.valueOf(size.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Type de taille inconnu");
            return -1; // type de taille inconnu
        }
        total = getTotalFromSizeType(dsize, total, sizeType);
        return total ;
    }

    private int getTotalFromSizeType(String dsize, int total, SizeType sizeType) {
        switch (sizeType) {
            case SizeType.PETIT:
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
                break;
            case SizeType.MOYEN:
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
                break;
            case SizeType.GRAND:
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
                break;

            default:
                break;
        }
        return total;
    }

    private int getCoffePromo(String type, String size, String dsize, String coffee, int total) {
        if (!coffee.equals("yes")) {
            total += 1;
        }
        if (type.equals(FormuleType.ASSIETTE.getValue()) && size.equals(SizeType.MOYEN.getValue()) && dsize.equals("normal") && coffee.equals("yes")) {
            System.out.print(" avec café offert!");
        }
        return total;
    }

    private boolean isEmptyType(String type, String name) {
        return type == null || name == null || type.isEmpty() || name.isEmpty();
    }

}