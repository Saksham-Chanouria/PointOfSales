package newproject;

import com.mashape.unirest.http.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class myclient {

    String IP = "";
    static String adminGmail = null;
    static boolean isSet = false;

    public int send_data(String u, String p) {
        if (u.equals("") || p.equals("")) {
            return -1;
        } else {
            try {
                    HttpResponse<String> res = Unirest.get("http://localhost:8000/adminLogin").queryString("user", u).queryString("pass", p).asString();

                    String ans = res.getBody();
                    if (ans.equals("Login Failed")) {
                        return 0;
                        
                    } else {
                        if(!isSet){
                            adminGmail = ans;
                            isSet = true;
                        }
                        
                        return 1;
                        
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -2;
    }

    public int add_Category(String name, String desc, String photo) {
        
        if (name.equals("") || desc.equals("") || photo.equals("null")) {
            return -1;
        } else {
            try {
                try {
                    System.out.println("I am here");
                    HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/addCateg").queryString("name", name).queryString("desc", desc).queryString("photo", photo).asString();

                    String ans = res.getBody();

                    if (ans.equals("Added Successfully")) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -2;
    }
    
    public int add_Product(String name, String desc, String categ_name, int price, int quantity, String photo) {
        if (name.equals("") || desc.equals("") || categ_name.equals("") || photo.equals("null")) {
            return -1;
        } 
        else if(price<=0 ||quantity<=0)
        {
                return -2;
        }
        else 
        {
            try {
                    System.out.println("I am here");
                    HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/addProd").queryString("name", name).queryString("desc", desc)
                                                                                                .queryString("categName", categ_name).queryString("price", price)
                                                                                                .queryString("quantity",quantity).queryString("photo", photo).asString();

                    String ans = res.getBody();

                    if (ans.equals("Added Successfully")) {
                        return 1;
                    } else {
                        return 0;
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -3;
    }

    public ArrayList fetchCategories() {
        ArrayList<Category> al = new ArrayList<>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Hello");
                    HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/fetchCateg").asString();

                    if (res.getStatus() == 200) {
                        String ans = res.getBody();

                        System.out.println(ans);

                        JSONArray arr = new JSONArray(ans);

                        int n = arr.length();

                        for (int i = 0; i <= n - 1; i++) {
                            JSONObject obj = (JSONObject) (arr.get(i));

                            String name = (String) obj.get("Name");
                            String desc = (String) obj.get("Description");
                            String photo = (String) obj.get("Photo");

                            al.add(new Category(name, desc, photo));
                        }

                    } else {
                        System.out.println(res.getBody());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
        t.start();
        
        try{
            t.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return al;
    }

    public ArrayList fetchProducts() {
        ArrayList<Products> al = new ArrayList<>();
        new Thread(new Runnable() {                                                         // Multithreading client requests to server so that there is synchronization
            @Override
            public void run() {
                System.out.println("Thread is running to continuously fetch products");
                
                try {
                    System.out.println("Hello");
                    HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/fetchProd").asString();

                    if (res.getStatus() == 200) {
                        String ans = res.getBody();

                        System.out.println(ans);

                        JSONArray arr = new JSONArray(ans);

                        int n = arr.length();

                        for (int i = 0; i <= n - 1; i++) {
                            JSONObject obj = (JSONObject) (arr.get(i));

                            String name = (String) obj.get("PName");
                            String desc = (String) obj.get("PDesc");
                            String category = (String) obj.get("Category");
                            String quantity = (String) obj.get("Quantity");
                            int price = (Integer) obj.get("Price");
                            String photo = (String) obj.get("Photo");

                            al.add(new Products(name, desc, category,quantity,price,photo));
                        }

                    } else {
                        System.out.println(res.getBody());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
        return al;
    }
    
    public ArrayList fetchCategName(){
        ArrayList<String> al = new ArrayList<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Hello");
                    HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/fetchCateg").asString();

                    if (res.getStatus() == 200) {
                        String ans = res.getBody();

                        System.out.println(ans);

                        JSONArray arr = new JSONArray(ans);

                        int n = arr.length();

                        for (int i = 0; i <= n - 1; i++) {
                            JSONObject obj = (JSONObject) (arr.get(i));

                            String name = (String) obj.get("Name");

                            al.add(name);
                        }

                    } else {
                        System.out.println(res.getBody());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return al;
    }
    
    public ArrayList fetchCategNamePhoto(){
        ArrayList<CategBill> al = new ArrayList<>();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    HttpResponse<String> res = Unirest.get("http://localhost:8000/fetchCategNmPh").asString();

                    if(res.getStatus()==200){
                        String ans = res.getBody();
                        System.out.println(ans);

                        JSONArray arr = new JSONArray(ans);

                        int n = arr.length();

                        for(int i=0;i<n;i++){
                            JSONObject obj = (JSONObject) (arr.get(i));

                            String name = (String) obj.get("Name");
                            String photo = (String) obj.get("Photo");

                            al.add(new CategBill(name,photo));
                        }
                    }
                    else{
                        System.out.println(res.getBody());
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return al;
    }
    
    public ArrayList fetchProductNmPh(String name){
        ArrayList<ProductBill> al = new ArrayList<>();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    HttpResponse<String> res = Unirest.get("http://localhost:8000/fetchProductNmPh").queryString("CategName",name).asString();

                    if(res.getStatus()==200){
                        String ans = res.getBody();
                        System.out.println(ans);

                        JSONArray arr = new JSONArray(ans);

                        for(int i=0;i<arr.length();i++){
                            JSONObject obj = (JSONObject) (arr.get(i));
                            String Pname = (String) obj.get("PName");
                            String photo = (String) obj.get("Photo");

                            al.add(new ProductBill(Pname,photo));
                        }
                    }
                    else{
                        System.out.println(res.getBody());
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public int removeCategory(String nm) {
        if (nm.equals("")) {
            return -1;
        } else {
            ArrayList<Category> al = new ArrayList<>();
            try {
                System.out.println("Hello");
                HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/removeCateg").queryString("name", nm).asString();

                if (res.getStatus() == 200) {
                    String ans = res.getBody();

                    System.out.println(ans);

                    if (ans.equals("Row Deleted")) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    System.out.println(res.getBody());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
    
    public int increaseQuantity(String product,int quantity){
        System.out.println("Increase Quantity request received.");
        try{
            
            HttpResponse<String> res = Unirest.get("http://127.0.0.1:8000/incQty").queryString("product", product).queryString("quantity",quantity).asString();
            
            if(res.getStatus()==200){
                String ans = res.getBody();
                
                System.out.println("ans");
                
                if (ans.equals("Quantity Incremented")) {
                        return 1;
                    } else {
                        return 0;
                    }
            }
            else {
                    System.out.println(res.getBody());
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public String checkQuantity(String name,int need){
        System.out.println("Name : "+name);
        
        try{
            HttpResponse<String> res = Unirest.get("http://localhost:8000/checkQty").queryString("Pname",name).queryString("need",need).asString();
            
            if(res.getStatus()==200){
                String ans = res.getBody();
                System.out.println(ans);
                if(ans.equals("available")){
                    return ans;
                }
                else{
                    return ans;
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    
    public ArrayList getBillProd(String Pname,int need){
        ArrayList<BillProd> al = new ArrayList<>();
        
        try{
            System.out.println("I am here in getBillProd");
            HttpResponse<String> res = Unirest.get("http://localhost:8000/fetchBillProd").queryString("Pname",Pname).asString();
            
            if(res.getStatus()==200){
                String ans = res.getBody();
                
                System.out.println("New Data: "+ans);
                
                JSONArray arr = new JSONArray(ans);
                System.out.println(arr.toString());
                
                for(int i=0;i<arr.length();i++){
                    JSONObject obj = (JSONObject) arr.get(i);
                    
                    String name = (String)obj.get("PName");
                    String cname = (String)obj.get("Category");
                    Object price= (obj.get("Price"));
                    String pr = price.toString();
                    System.out.println(price);
                    String photo = (String)obj.get("Photo");
                    String nd = need+"";
                    al.add(new BillProd(name,cname,photo,pr,nd));
                }
                System.out.println("This part is done");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return al;
    }
    
    public int Buy_prod(String CPhone,String p_mode,String[] Products,long gtotal,int[] qty,int [] pprice){
        System.out.println("I am in Buy Products");
        String ProductsStr="",qtyStr="",ppriceStr="";
        
        if(CPhone.equals("")){
            return 0;
        }
        
        else{
            for(int i=0;i<Products.length;i++){
                if(i==(Products.length-1)){
                    ProductsStr += Products[i];
                    qtyStr += qty[i]+"";
                    ppriceStr += pprice[i]+"";
                    break;
                }
                ProductsStr += Products[i]+":";
                qtyStr += qty[i]+":";
                ppriceStr += pprice[i]+":";
            }
            System.out.println(ProductsStr+"\n"+qtyStr+"\n"+ppriceStr+"\n");
            try{
                HttpResponse<String> res = Unirest.get("http://localhost:8000/addBillDetails")
                                                                                                 .queryString("CPhone",CPhone)
                                                                                                 .queryString("p_mode",p_mode)
                                                                                                 .queryString("ProductsStr",ProductsStr)
                                                                                                 .queryString("AdminGmail",adminGmail)
                                                                                                 .queryString("gtotal",gtotal)
                                                                                                 .queryString("qtyStr",qtyStr)
                                                                                                 .queryString("ppriceStr",ppriceStr)
                                                                                                 .queryString("length",qty.length)
                                                                                                 .asString();
                
                
                String ans = res.getBody();

                if (ans.equals("Quantity Reduced and Product Data Added")) {
                    return 1;
                } else {
                    return -1;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        
        
        return -2;
    }

    public static void main(String[] args) {

    }
}
