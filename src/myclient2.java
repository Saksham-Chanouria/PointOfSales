
public class myclient2 {
    public int send_data(String u,String p){
        if(!u.equals("") && !p.equals("")){
            System.out.println("Username: "+u);
            System.out.println("Password: "+p);
            return 1;
        }
        return 0;
    }
}
