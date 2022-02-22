package dk.webtrade.gson_demo.demos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
//        serializeList();
        serializeSet();
    }

    public static void serializeList(){
        C1 c1 = new C1(1, "C1_1");
        c1.addC2(new C2(1, "C2_1"));
        c1.addC2(new C2(2, "C2_2"));
        String gsonString = gson.toJson(c1);
        System.out.println(gsonString);
    }

    public static void serializeSet(){
        C3 c3 = new C3(1, "C3_1");
        c3.addC4(new C4(1, "C4_1"));
        c3.addC4(new C4(2, "C4_2"));
        String gsonString = gson.toJson(c3);
        System.out.println(gsonString);
    }





    private static class C1 {
        int id;
        String name;
        List<C2> c2s = new ArrayList();

        public C1(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<C2> getC2s() {
            return c2s;
        }

        public void addC2(C2 c2) {
            this.c2s.add(c2);
            if(!c2.getC1s().contains(this))
                c2.addC1(this);
        }
    }

    private static class C2 {
        int id;
        String name;
        List<C1> c1s = new ArrayList();

        public C2(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<C1> getC1s() {
            return c1s;
        }

        public void addC1(C1 c1) {
            this.c1s.add(c1);
            if(!c1.getC2s().contains(this))
                c1.addC2(this);
        }
    }

    private static class C3 {
        int id;
        String name;
        Set<C4> c4s = new HashSet();

        public C3(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<C4> getC4s() {
            return c4s;
        }

        public void addC4(C4 c4) {
            this.c4s.add(c4);
            if(!c4.getC3s().contains(this))
                c4.addC3(this);
        }
    }
    private static class C4 {
        int id;
        String name;
        Set<C3> c3s = new HashSet<>();

        public C4(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<C3> getC3s() {
            return c3s;
        }

        public void addC3(C3 c3) {
            this.c3s.add(c3);
            if(!c3.getC4s().contains(this))
                c3.addC4(this);
        }
    }
}
