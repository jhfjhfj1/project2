package expression;

import storageManager.Tuple;

import java.util.ArrayList;

public class BooleanTerm implements Satisfiable{
    ArrayList<BooleanFactor> list;
    String[] tableArray;

    public BooleanTerm(BooleanFactor factor) {
        this.list = new ArrayList<BooleanFactor>();
        this.list.add(factor);

    }

    public BooleanTerm(BooleanTerm term1, BooleanTerm term2) {
        this.list = new ArrayList<BooleanFactor>(term1.list);
        this.list.addAll(term2.list);
    }

    public boolean satisfy(ArrayList<String> tuple) {
        for (BooleanFactor factor : list) {
            if (!factor.satisfy(tuple)) {
                return false;
            }
        }
        return true;
    }

    public void setTableArray(String[] tableArray) {
        this.tableArray = tableArray;
        for (BooleanFactor factor: list) {
            factor.setTableArray(tableArray);
        }
    }

    public String toString() {
        return list.toString();
    }
}
