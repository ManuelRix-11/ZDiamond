package model;

import java.util.HashMap;
import java.util.Map;

public class Carrello {
    private HashMap<Gioiello, Integer> carrello;

    public Carrello()
    {
        carrello = new HashMap<>();
    }

    public void emptyCarello() {
        carrello.clear();
    }

    public HashMap<Gioiello, Integer> getCarrello() {
        return carrello;
    }
}
