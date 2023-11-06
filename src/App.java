public class App {
    public static void main(String[] args) throws Exception {
        DOM dom = new DOM();

        var k = dom.getGuns();
        for(int i=0; i<k.size(); i++)
            System.out.println(k.get(i).toString());
    }
}
