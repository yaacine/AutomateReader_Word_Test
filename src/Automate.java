import java.util.ArrayList;

/**
 * Created by LENOVO on 15-10-2018.
 */
public class Automate {


    private String alphabet; //alphabet de l'automate
    private ArrayList<String> s= new ArrayList<>(); // l'ensemble des etats de l'automate
    private ArrayList<String> F = new ArrayList<>(); //ensemble des etats finaux
    private ArrayList<Transition> I= new ArrayList<>(); //liste des transitions de l'automate


    public Automate(String  alph,ArrayList<String> s, ArrayList<String> F, ArrayList<Transition> I)
    {

        if(!s.containsAll(F)) // verifier que l'ensemble des etats finaux est inclu dans s
        {
            System.out.println("Erreur dans l'ensemble des etats finaux");
            return;
        }


        this.alphabet=alph;
        this.s=s;
        this.F=F;
        this.I=I;

    }



// cette fonction n'est pas utile pour le moment , peut etre pour d'autres ameloirations

    public boolean transVerif(ArrayList<Transition> t) // verifier que les etats de chaque transitions sont inclus dans s
    {
        boolean stop =true;

        for (Transition i:t
             ) {
            String l ="";
           // l.concat(i.getWord()) /**  probleme entre char et string a resoudre sur cetteligne 15/10/2018  et replace ce "a juste en dessous " **/
            if (!this.s.contains(i.getInitialState()) || !this.s.contains(i.getFinalState()) || this.alphabet.contains(("a")) )
            {
                stop=false;
                break;
            }
        }

        return stop;
    }



    /**  Partie des getteurs et setters**/


    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public ArrayList<String> getS() {
        return s;
    }

    public void setS(ArrayList<String> s) {
        this.s = s;
    }

    public ArrayList<String> getF() {
        return F;
    }

    public void setF(ArrayList<String> f) {
        F = f;
    }

    public ArrayList<Transition> getI() {
        return I;
    }

    public void setI(ArrayList<Transition> i) {
        I = i;
    }

}
