public class EdgeNode {
    
    public int to;
    public int weight;
    public EdgeNode next;

    public EdgeNode(int to, int weight, EdgeNode next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }
}
