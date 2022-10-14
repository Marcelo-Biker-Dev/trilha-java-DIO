package com.treinamento;

public class CoffeeBeans implements Comparable<CoffeeBeans> {
    
    String origem;

    public CoffeeBeans(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CoffeeBeans other = (CoffeeBeans) obj;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "coffeeBeans [origem=" + origem + "]";
    }

    // METODO "COMPARE_TO" OBRIGADO POR IMPLEMENTAR A INTERFACE COMPARABLE,
    // QUE FOI NECESSARIO A IMPLEMENTAR-LA PARA PODER USAR A ARVORE TREE_SET

    // NESTA PRIMEIRA IMPLEMENTACAO FIZ UMA COMPARACAO CUSTOMIZADA
    /*@Override
    public int compareTo(CoffeeBeans o) {
        if (this.origem.length() < o.origem.length()) {
            return -1;
        }
        else if (this.origem.length() > o.origem.length()) {
            return 1;
        }
        return 0;
    }*/

    // NESTA SEGUNDA IMPLEMENTACAO USEI O METODO COMPARE DA PROPRIA CLASSE
    @Override
    public int compareTo(CoffeeBeans o) {
        return this.getOrigem().compareTo(o.getOrigem());
    }
}
