public class App {
    public static void main(String[] args) throws Exception {
        StAX dom = new StAX();

        for(int i=0; i<dom.list.size(); i++)
            System.out.println(dom.list.get(i).toString());
    }
}
