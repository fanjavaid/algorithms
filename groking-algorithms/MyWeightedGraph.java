import java.util.*;

class MyWeightedGraph {
    private String title;
    private Map<String, Map<String, Double>> vertices = new HashMap();
    
    public MyWeightedGraph(String title) {
        this.title = title;
    }
    
    public Map<String, Map<String, Double>> getVertices() {
        return this.vertices;
    }
    
    public void addVertex(String v) {
        this.vertices.put(v, new HashMap());
    }
    
    public void addAdjacent(String from, String to, double weight) {
        this.vertices.get(from).put(to, weight);
    }
    
    public String toString() {
        Iterator it = this.vertices.entrySet().iterator();
        String str = "--------------------------\n" + this.title + "\n--------------------------";
        while(it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            str += "\n[" + (String) e.getKey() + "] -> " + e.getValue();
        }
        return str;
    }
}

