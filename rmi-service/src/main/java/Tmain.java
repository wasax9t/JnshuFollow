import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

import java.util.concurrent.TimeUnit;

public class Tmain {
    public static void main(String[] args) throws InterruptedException {
        Node node = NodeFactory.newInstance().createNode("tuscany.composite");
        System.out.println("111");
        node.start();
        while (true ) {
            TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
        }
    }
}
