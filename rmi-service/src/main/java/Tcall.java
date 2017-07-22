import cn.yxy.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/6/20.
 */
public class Tcall {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        UserService userService = (UserService) Naming.lookup("//localhost:1199/UserService");
        System.out.println(userService);
        System.out.println(userService.selectByPrimaryKey(8));
    }
}
