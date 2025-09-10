package edu.wctc;
import edu.wctc.interfaces.Swift;

public class SwiftPlayer extends Player implements Swift {
    @Override
    public void useSwiftAbility() {
        System.out.println("Swift ability used! You can move twice in one turn.");
    }
}

