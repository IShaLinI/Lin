package lin;

import java.util.ArrayList;

/** Represents a block of code */

public class Sling {

    private Sling superSling;
    private ArrayList<Sling> subSlings;

    public Sling(Sling superSling){

        this.superSling = superSling;
        this.subSlings = new ArrayList<>();

    }

    public Sling getSuperSling(){return superSling;}

    

}