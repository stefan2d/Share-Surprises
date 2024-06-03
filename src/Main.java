import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

abstract class AbstractGiveSurprise {

    private int waitTime;
    IBag bagType;

    public AbstractGiveSurprise () {
    }

    public AbstractGiveSurprise (String bagType, int waitTime) {

        switch (bagType.toLowerCase ()) {

            case "random": {

                this.bagType = new BagRandom ();
                break;
            }
            case "lifo": {

                this.bagType = new BagLifo ();
                break;
            }
            case "fifo": {
                this.bagType = new BagFifo ();
                break;
            }
        }
        this.waitTime = waitTime;
    }

    public void put (ISurprise newSurprise) {


    }

    public void put (IBag surprises) {
    }

    public IBag give () {

        return this.bagType;
    }

    public void giveAll () {

        try {
            while (!bagType.isEmpty ()) {

                System.out.println (bagType.takeOut ());
            }
            TimeUnit.SECONDS.sleep (10); // number of seconds to sleep
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        }
    }

    public boolean isEmpty () {

        return this.bagType.isEmpty ();
    }

    abstract void giveWithPassion ();


}

class RandomSingleton {

    private static Random instance;

    private RandomSingleton () {

    }

    public static Random getInstance () {

        if (null == instance) {

            instance = new Random ();
        }
        return instance;
    }
}

class FortuneCookie implements ISurprise {

    private String message;
    private static final String[] quotes = {
            "Cand vei fi multumit sa fii pur si simplu tu insuti si sa nu te compari cu ceilalti, toti te vor respecta. (Lao Tse)",
            "Odata ce ai ales speranta, totul este posibil. (Christopher Reeve)",
            "Am invatat tacerea de la cei vorbareti, toleranta de la cei intoleranti si bunatatea de la cei rai. (Khalil Gibran)",
            "Cel ce n-are nici un merit invidiaza intotdeauna meritele altora. (Francis Bacon)",
            "Cea mai inalta masura a valorii o dai de fapt in timpul confruntarilor la care te supune viata. (Anonim)",
            "Am descoperit ca daca iubesti viata, si viata te va iubi pe tine. (Arthur Rubinstein)",
            "Fiecare experienta de viata, fiecare lectie pe care o invat este cheia spre viitorul meu. (Clark Gable)",
            "Prima conditie pentru a fi fericit este sa n-ai timp sa te gandesti la nefericire. (George Bernard Shaw)",
            "Da tot ce ai mai bun in tine, intrucat totul din viata ta iti apartine numai tie. (Ralph Waldo Emerson)",
            "Nebun este cine traieste in propria-i lume. (Paulo Coelho)",
            "Pentru orice rau exista doua leacuri: timpul si tacerea. (Alexandre Dumas)",
            "In viata lucrurile se fac usor, doar ideea gresita ca ar fi greu ne opreste sa fim extraordinari. (Marian Rujoiu)",
            "S-ar putea ca actiunea sa nu-ti ofere fericire, dar nu exista fericire in lipsa actiunii. (William James)",
            "Nu vad niciodata ce s-a facut. Vad doar ce mai e de facut. (Buddha)",
            "Nu-ti pierde timpul batand intr-un perete sperand ca il vei transforma intr-o usa. (Coco Chanel)",
            "Ataseaza-te de cei care te pot face mai bun si primeste-i pe cei care, la randul tau, ii poti face mai buni. (Seneca)",
            "Mai bine sa te consumi decat sa ruginesti. (Denis Diderot)",
            "Intelept este acela care traieste in fiecare zi ca si cum in fiecare zi si in fiecare ceas ar putea sa moara. (Francisco Gomez de Quevedo)",
            "Toti avem in noi o nestiuta rezerva de energie care izbucneste cand viata ne pune la incercare. (Isabel Allende)",
            "Stelele nu pot straluci fara intuneric. (Anonim)"
    };


    public FortuneCookie (String message) {

        this.message = message;
    }

    public FortuneCookie () {
    }

    @Override
    public void enjoy () {
        System.out.println ("You got a fortune cookie");
        System.out.println (this.message);
    }

    @Override
    public String toString () {

        String s = "[FortuneCookie] message = " + this.message;
        return s;
    }

    public static FortuneCookie generate () {

        Random random = RandomSingleton.getInstance ();

        int n = random.nextInt (quotes.length);
        return new FortuneCookie (quotes[ n ]);
    }
}

class Candies implements ISurprise {

    private int noCandies;
    private String type;
    private static String[] candieType = {"chocolate", "jelly", "fruits", "vanilla"};

    public Candies (String type, int noCandies) {

        this.noCandies = noCandies;
        this.type = type;

    }

    public Candies () {
    }

    @Override
    public void enjoy () {

        System.out.println ("You received " + this.noCandies + " " + this.type + " candies.");
    }

    @Override
    public String toString () {

        String s = "[Cookies] number = " + this.noCandies + ", type = " + this.type;
        return s;
    }

    public static ISurprise generate () {

        Random random = RandomSingleton.getInstance ();
        int candiesType = random.nextInt (candieType.length);
        int numberOfCandies = random.nextInt ();

        return new Candies (candieType[ candiesType ], numberOfCandies);
    }
}

class MinionToy implements ISurprise {

    private static String[] minionNames = {"James", "Oktav", "Born", "Michael", "Winters"};
    private String name;
    private static int indexMn = 0;

    public MinionToy (String name) {

        this.name = name;
    }

    @Override
    public void enjoy () {

        System.out.println ("You got a minion names " + this.name);
    }

    @Override
    public String toString () {

        String s = "[Minion] name = " + this.name;
        return s;
    }

    public static MinionToy generate () {
        if (indexMn == minionNames.length - 1) {
            indexMn = 0;
        }
        indexMn++;
        return new MinionToy (minionNames[ indexMn ]);

    }

}

class GiveSurpriseAndApplause extends AbstractGiveSurprise {

    @Override
    void giveWithPassion () {
        System.out.println ("Loud applause to you… For it is in giving that we receive.");
    }
}

class GiveSurpriseAndSing extends AbstractGiveSurprise {


    @Override
    void giveWithPassion () {

        System.out.println ("Singing a nice song, full of joy and genuine excitement…");
    }
}

class GiveSurpriseAndHug extends AbstractGiveSurprise {


    @Override
    void giveWithPassion () {

        System.out.println ("Warm wishes and a big hug!");
    }
}

//first in first out bag
class BagFifo implements IBag {

    List<ISurprise> fifoBag = new ArrayList<> ();

    @Override
    public void put (ISurprise newSurprise) {

        if (null != newSurprise) {

            fifoBag.add (newSurprise);
        }
    }

    @Override
    public void put (IBag bagOfSurprises) {

        while (!bagOfSurprises.isEmpty ()) {

            ISurprise surprise = bagOfSurprises.takeOut ();
            fifoBag.add (surprise);
        }
    }

    @Override
    public ISurprise takeOut () {

        if (!fifoBag.isEmpty ()) {

            return fifoBag.remove (fifoBag.size () - 1);
        }

        return null;
    }

    @Override
    public boolean isEmpty () {

        return fifoBag.isEmpty ();
    }

    @Override
    public int size () {


        return fifoBag.size ();
    }

}

final class GatherSurprises {

    private GatherSurprises () {
    }


    public static ISurprise[] gather (int n) {

        int counter = 0;
        IBag generateSurprise;
        ISurprise[] randomSurprises = new ISurprise[ n ];

        while (counter < randomSurprises.length) {

            randomSurprises[ counter ] = gather ();
        }

        return randomSurprises;
    }

    public static ISurprise gather () {

        Random random = RandomSingleton.getInstance ();
        int typeOfSurprise = random.nextInt (3);

        switch (typeOfSurprise) {

            case 1: {

                return FortuneCookie.generate ();
            }
            case 2: {
                return Candies.generate ();
            }
            case 3: {

                return MinionToy.generate ();
            }
            default: {
                throw new IllegalArgumentException ("Invalid surprise type");
            }
        }
    }

}


class BagLifo implements IBag {

    List<ISurprise> lifoBag = new ArrayList<> ();

    @Override
    public void put (ISurprise newSurprise) {

    }

    @Override
    public void put (IBag bagOfSurprises) {

    }

    @Override
    public ISurprise takeOut () {

        if (!lifoBag.isEmpty ()) {

            ISurprise surprise = lifoBag.remove (lifoBag.size () - 1);
        }
        return null;
    }

    @Override
    public boolean isEmpty () {

        return lifoBag.isEmpty ();
    }

    @Override
    public int size () {

        return lifoBag.size ();
    }
}

class BagRandom implements IBag {

    List<ISurprise> randomBag = new ArrayList<> ();

    @Override
    public void put (ISurprise newSurprise) {

        if (null != newSurprise) {

            randomBag.add (newSurprise);
        }
    }

    @Override
    public void put (IBag bagOfSurprises) {

        while (!bagOfSurprises.isEmpty ()) {

            ISurprise surprise = bagOfSurprises.takeOut ();
            randomBag.add (surprise);
        }
    }

    @Override
    public ISurprise takeOut () {

        if (null != randomBag) {

            return randomBag.remove (randomBag.size () - 1);
        }
        return null;
    }

    @Override
    public boolean isEmpty () {

        return randomBag.isEmpty ();
    }

    @Override
    public int size () {

        return randomBag.size ();
    }
}

class BagFactory implements IBagFactory {

    private static BagFactory instance;

    public static BagFactory getInstance () {

        if (null == instance) {

            instance = new BagFactory ();
        }
        return instance;
    }

    private BagFactory () {
    }


    @Override
    public IBag makeBag (String type) {

        switch (type.toLowerCase ()) {

            case "random": {

                return new BagRandom ();
            }
            case "fifo": {
                return new BagFifo ();
            }
            case "lifo": {
                return new BagLifo ();
            }
            default: {
                throw new IllegalArgumentException ("Invalid command: " + type);
            }
        }

    }
}

public class Main {

    public static void main (String[] args) {

        List<ISurprise> test = new ArrayList<> ();
        int n = 0;
        Random rnd = RandomSingleton.getInstance ();


        test.add(new Candies("jelly",100));
        test.add(new FortuneCookie ("Oamenii nu stiu ce vor"));
        test.add(new MinionToy ("Born"));

        while (n < test.size ()){

            test.get (n).enjoy ();
            n++;
        }



    }



}
