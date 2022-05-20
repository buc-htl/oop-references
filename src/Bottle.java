public class Bottle {

    private double volume;
    private double currentLevel;

    /**********************
     *  Konstruktoren      *
     ***********************/
    public Bottle(double volume) {
        this.volume = volume;
    }

    public Bottle(double volume, double currentLevel) {
        this.volume = volume;
        this.currentLevel = currentLevel;
    }

    public Bottle(){
        volume = 0;
        currentLevel = 0;
    }


    /**************************
     * setter/getter Methoden  *
     ***************************/

    public void setVolume(double v){
        volume = v;
    }

    public double getVolume() {
        return volume;
    }


    public void setCurrentLevel(double level) {
        this.currentLevel = level;
    }

    public double getCurrentLevel(){
        return currentLevel;
    }


    /**************************
     * weitere public Methoden *
     ***************************/

    public void fillBottle(double v) {
        currentLevel += v;

        checkLevel();
    }

    public void emptyBottle(double l) {
        currentLevel -= l;

        checkLevel();
    }

    public String toString() {
        return "Die Flasche ist mit "+currentLevel+" ml von "+volume+" ml gefüllt.";
    }


    /**************************
     * private Methoden        *
     ***************************/

    private void checkLevel() {
        if (currentLevel<0 ) {
            currentLevel = 0;
        } else if (currentLevel > volume) {
            currentLevel = volume;
        }
    }

}
