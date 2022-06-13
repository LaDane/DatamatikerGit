package entity;

import javax.persistence.Persistence;

public class Tester {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
    }
}
