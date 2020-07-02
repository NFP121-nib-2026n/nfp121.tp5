package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        if(table.contains(t))return false;
        table.add(t);
        return true;
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble ensemble = new Ensemble();
        
        ensemble.addAll(this.table);
        ensemble.addAll(e.table);
        
        return ensemble;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble ensemble = new Ensemble();
        
        ensemble.addAll(this.table);
        ensemble.retainAll(e.table);
        
        return ensemble;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble ensemble = new Ensemble();
        
        ensemble.addAll(this.table);
        ensemble.removeAll(e.table);
        
        return ensemble;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble ensemble = new Ensemble();
        
        ensemble = this.union(e).diff(this.inter(e));

        return ensemble;
    }
    
}
