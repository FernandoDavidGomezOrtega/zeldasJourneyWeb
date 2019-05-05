package zeldasjourney.objetos;

import zeldasjourney.objetos.objetoPadre.ObjetoPadre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Esta clase sirve para hacer un testeo de la interface Comparable
 * @author casa
 *
 */
public class PruebaComparable {

    public static void main(String[] args) {

        List<ObjetoPadre> objs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ObjetoPadre op = new ObjetoPadre();
            op.setNombre("Hola mundo " + ThreadLocalRandom.current().nextInt(1000));
            objs.add(op);
        }

        System.out.println(objs);

        System.out.println(objs.get(0).compareTo(objs.get(1)));
        System.out.println(objs.get(0).compareTo(objs.get(0)));
        System.out.println(objs.get(1).compareTo(objs.get(0)));


        Collections.sort(objs);

        System.out.println(objs);

    }
}
