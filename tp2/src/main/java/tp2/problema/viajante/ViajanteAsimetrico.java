package tp2.problema.viajante;

import java.util.*;

/**
 * Date 11/17/2015
 * @author Tushar Roy
 *
 * Help Karp method of finding tour of traveling salesman.
 *
 * Time complexity - O(2^n * n^2)
 * Space complexity - O(2^n)
 *
 * https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm
 */
public class ViajanteAsimetrico {

    private static int INFINITO = Integer.MAX_VALUE;

    private static class Indice {
        int verticeActual;
        Set<Integer> verticesSet;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Indice indice = (Indice) o;

            if (verticeActual != indice.verticeActual) return false;
            return !(verticesSet != null ? !verticesSet.equals(indice.verticesSet) : indice.verticesSet != null);
        }

        @Override
        public int hashCode() {
            int result = verticeActual;
            result = 31 * result + (verticesSet != null ? verticesSet.hashCode() : 0);
            return result;
        }

        private static Indice crearIndice(int vertex, Set<Integer> vertexSet) {
            Indice i = new Indice();
            i.verticeActual = vertex;
            i.verticesSet = vertexSet;
            return i;
        }
    }

    private static class SetSizeComparator implements Comparator<Set<Integer>>{
        @Override
        public int compare(Set<Integer> o1, Set<Integer> o2) {
            return o1.size() - o2.size();
        }
    }

    public int resolver(Integer[][] distancia) {

        // valores intermedios en map
        Map<Indice, Integer> minCostDP = new HashMap<>();
        Map<Indice, Integer> parent = new HashMap<>();

        List<Set<Integer>> allSets = generarCombinaciones(distancia.length - 1);

        for(Set<Integer> set : allSets) {
            for(int verticeActual = 1; verticeActual < distancia.length; verticeActual++) {
                if(set.contains(verticeActual)) continue;
                Indice indice = Indice.crearIndice(verticeActual, set);
                int minCosto = INFINITO;
                int minVerticeAnterior = 0;
                
                // para evitar ConcurrentModificationException se copia set en otro set mientras se itera
                Set<Integer> copySet = new HashSet<>(set);
                for(int verticeAnterior : set) {
                    int cost = distancia[verticeAnterior][verticeActual] + getCost(copySet, verticeAnterior, minCostDP);
                    if(cost < minCosto) {
                        minCosto = cost;
                        minVerticeAnterior = verticeAnterior;
                    }
                }
                //this happens for empty subset
                if(set.size() == 0) {
                    minCosto = distancia[0][verticeActual];
                }
                minCostDP.put(indice, minCosto);
                parent.put(indice, minVerticeAnterior);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i < distancia.length; i++) {
            set.add(i);
        }
        int min = Integer.MAX_VALUE;
        int verticeAnterior = -1;
        // para evitar ConcurrentModificationException se copia set en otro set mientras se itera
        Set<Integer> copySet = new HashSet<>(set);
        for(int k : set) {
            int cost = distancia[k][0] + getCost(copySet, k, minCostDP);
            if(cost < min) {
                min = cost;
                verticeAnterior = k;
            }
        }

        parent.put(Indice.crearIndice(0, set), verticeAnterior);
        debugTour(parent, distancia.length);
        return min;
    }

    private void debugTour(Map<Indice, Integer> parent, int totalVertices) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < totalVertices; i++) {
            set.add(i);
        }
        Integer inicio = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            stack.push(inicio);
            set.remove(inicio);
            inicio = parent.get(Indice.crearIndice(inicio, set));
            if(inicio == null) {
                break;
            }
        }
        StringJoiner joiner = new StringJoiner("->");
        stack.forEach(v -> joiner.add(String.valueOf(v)));
        System.out.println("\nCamino:");
        System.out.println(joiner.toString());
    }

    private int getCost(Set<Integer> set, int prevVertex, Map<Indice, Integer> minCostDP) {
        set.remove(prevVertex);
        Indice index = Indice.crearIndice(prevVertex, set);
        int cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
    }

    private List<Set<Integer>> generarCombinaciones(int n) {
        int input[] = new int[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        List<Set<Integer>> allSets = new ArrayList<>();
        int result[] = new int[input.length];
        generarCombinaciones(input, 0, 0, allSets, result);
        Collections.sort(allSets, new SetSizeComparator());
        return allSets;
    }

    private void generarCombinaciones(int input[], int start, int pos, List<Set<Integer>> allSets, int result[]) {
        if(pos == input.length) {
            return;
        }
        Set<Integer> set = crearSet(result, pos);
        allSets.add(set);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generarCombinaciones(input, i+1, pos+1, allSets, result);
        }
    }

    private static Set<Integer> crearSet(int input[], int pos) {
        if(pos == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
    }
}