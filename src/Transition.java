/**
 * Created by LENOVO on 15-10-2018.
 */
public class Transition {

    private String initialState;
    private String finalState;
    private char word;

    /** getters and setters of the private attributes **/

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public String getFinalState() {
        return finalState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }




    /** constructor **/

    public Transition(String init , String finl, char w){

        this.initialState =init;
        this.finalState=finl;
        this.word=w;
    }



}
