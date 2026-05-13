public class EdegNode {
    
    public int to;
    public int weight;
    public EdegNode next;

    public EdegNode(int to, int weight, EdegNode next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }
}
