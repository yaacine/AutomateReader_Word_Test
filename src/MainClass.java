import javafx.scene.Scene;

import java.io.Console;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by LENOVO on 15-10-2018.
 */
public class MainClass {



    public static void main(String[] args) {

        String w1;
        Automate a ;
        a= Read_Automate();

        System.out.println("Introduir le mot a teser :");
        Scanner in1= new Scanner(System.in);
        w1= in1.nextLine();

        boolean result =word_Test(w1,a);

        if (result)
        {
            System.out.println("le mot est lisible par votre automate");
        }
        else
        {
            System.out.println("le mot n'est pas lisible par votre automate");
        }

    }


    public static Automate Read_Automate()
    {
        int nb,i=0 , saveNb;
        String state ="s";
        String transitStr ="";
        Transition tran ;
        String[] transArray;
        String[] finauxArray;
        char c;
        Automate a2 ;
        String Str;
        String alphabet; //alphabet de l'automate
        ArrayList<String> s= new ArrayList<>(); // l'ensemble des etats de l'automate
        ArrayList<String> F = new ArrayList<>(); //ensemble des etats finaux
        ArrayList<Transition> I= new ArrayList<>(); //liste des transitions de l'automate


        System.out.println("###############################################");
        System.out.println("      Debut de definition de l'automate       ");
        System.out.println("############################################### \n");

        System.out.println("Quel est l nombre d'etat de votre automate ?");
        Scanner in = new Scanner(System.in);
        nb = in.nextInt();
        saveNb=nb;
        for (i=0;i<nb;i++) // creation des etats de l'automate
        {
            state="s";
            state = state.concat(((Integer)i).toString());
            s.add(state);
            System.out.println(state);
        }
        System.out.println("***********************************************");
        System.out.println("nous avons créé "+nb+"etats commencant par l'etat initial s0 jusqu'à s"+(nb-1));
        System.out.println("***********************************************");

        System.out.println("Quel est l nombre de transitions de votre automate ?");
        nb = in.nextInt();
        System.out.println("Vous etes sur le point de creer "+nb+"transitions pour votre automate ");
        System.out.println("Il est recommandé de suivre les etapes pour ne pas erronner les resultats ");
        System.out.println("Ecrivez vos transitions sous la forme de l'exempe suivant : s0=>a=>s1 ");

        i=0;
        for (i=0;i<nb;i++) // creation des transitions de l'automate
        {

             System.out.println("***************************************************************** \n");
             System.out.println("Introduisez la "+(i+1)+"eme transition");
             in =new Scanner(System.in);
             transitStr = in.nextLine();
             System.out.println(transitStr);
             transArray = transitStr.split("=>",4);
             tran = new Transition(transArray[0],transArray[2],transArray[1].charAt(0) );

            I.add(tran);
        }
        System.out.println("***********************************************");
        System.out.println("creation des transitions terminée");
        System.out.println("*********************************************** \n \n");

        System.out.println("Il reste juste a indiquer quel sont les etats finaux de votre automate");
        System.out.println("Veuillez introduire juste leurs indexs sous la forme de cet exmple :\n" +
                " 0-1-3-8 pour dire que les etats s0,s1,s3,s8  sont des etats finaux");

        finauxArray =  in.nextLine().split("-");
        for (String x:finauxArray
             ) {

            if(s.contains("s".concat(x)))
            {
                F.add("s".concat(x));

            }
            else
            {
                System.out.println("la liste des etats ne contient pas l'etat"+x);
                System.out.println("Voulez-vous l'ignorer  o/n?");
                if (in.nextLine().equals("o"))
                {
                    continue;
                }
                else
                {
                    System.out.println("Vous devez relancer l'application a nouveau !");
                }


            }
        }

        a2=new Automate("ab", s,F,I);
        return a2;


    }

    public static boolean word_Test(String word , Automate A)
    {
        int i=0 , j=0 , saveJ =0;
        boolean stop =false;
        String actualState ="s0";

        ArrayDeque<String> pile = new ArrayDeque<>();
        while(i< word.length())
        {
            while ((j< A.getI().size()) && !stop)
            {
                //  trouver les transisions possibles

                if(word.charAt(i) == A.getI().get(j).getWord() &&  actualState.equals(A.getI().get(j).getInitialState()) )
                {
                    stop= true;
                }
                else
                {
                    saveJ=j; // sauvegarder J pour le prochain test en cas de depilement
                    j++;
                }
            }

            if (stop)
            {
                pile.push(actualState);
                actualState = A.getI().get(j).getFinalState(); // passer à l'état suivant
                j=0;
                stop=false;
            }
            else
            {
                if(!pile.isEmpty())
                {
                    actualState = pile.getFirst();
                    j= saveJ ++;
                }
                else //pile vide ==> nous sommes arrivé à s0 et le mot n'est pas lu par l'automate
                {
                    // retourner qlq chose
                    System.out.println("pile vide");
                    return false;
                }
            }

            i++;
        }

        if(i==word.length() && A.getF().contains(actualState))
        {

            return true;
        }
        else
        {
            return false;
        }

    }
}
