
package newproject;

import com.mashape.unirest.http.Unirest;
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.sql.*;
import org.json.*;

public class MyServer extends JHTTPServer{

    String IP = "";
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;
        if(uri.equals("/checkAddress")){
            System.out.println("Request Received");
            
            String ip = parms.getProperty("ip");
            
            // Code taken from Stack Overflow
            try {
                Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaceEnumeration.hasMoreElements()) {
                    for (InterfaceAddress interfaceAddress : networkInterfaceEnumeration.nextElement().getInterfaceAddresses()) {
                        if (interfaceAddress.getAddress().isSiteLocalAddress()) {
                            IP = interfaceAddress.getAddress().getHostAddress();
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
            
            if(ip.equals(IP)){
                res = new Response(HTTP_OK,"text/plain","Successful");
            }
            else{
                res = new Response(HTTP_OK,"text/plain","Failed");
            }
        }
        
        if(uri.equals("/adminLogin")){
            System.out.println("Request Received");
            String username = parms.getProperty("user");
            String password = parms.getProperty(("pass"));
            
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.users where Username=\""+username+"\" and Password=\""+password+"\"");
                
                if(rs.next()){
                    res = new Response(HTTP_OK,"text/plain","Login Successful");
                }
                else{
                    res = new Response(HTTP_OK,"text/plain","Login Failed");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/addCateg")){
            System.out.println("Add Categ Request Received");
            
            String name = parms.getProperty("name");
            String desc = parms.getProperty(("desc"));
            String photo = parms.getProperty(("photo"));
            System.out.println(name+"   "+desc+"   "+photo);
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.Category where Name=\""+name+"\"");
                
                if(rs.next()){
                    res = new Response(HTTP_OK,"text/plain","Already Exists");
                    System.out.println("Why i am here");
                }
                else{
                    System.out.println("I am here");
                    rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Description", desc);
                    rs.updateString("Photo", photo);
                    rs.insertRow();
                    
                    res = new Response(HTTP_OK,"text/plain","Added Successfully");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/addProd")){
            System.out.println("Add Product Request Received");
            
            String name = parms.getProperty("name");
            String desc = parms.getProperty(("desc"));
            String categName = parms.getProperty(("categName"));
            String price = parms.getProperty(("price"));
            String quantity = parms.getProperty(("quantity"));
            String photo = parms.getProperty(("photo"));
            System.out.println(name+"   "+desc+"   "+categName+"    "+price+"    "+quantity+"    "+photo);
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.Products where PName=\""+name+"\"");
                
                if(rs.next()){
                    res = new Response(HTTP_OK,"text/plain","Already Exists");
                    System.out.println("Why i am here");
                }
                else{
                    System.out.println("I am here");
                    rs.moveToInsertRow();
                    rs.updateString("PName", name);
                    rs.updateString("PDesc", desc);
                    rs.updateString("Category", categName);
                    rs.updateString("Quantity", quantity);
                    rs.updateString("Price", price);
                    rs.updateString("Photo", photo);
                    rs.insertRow();
                    
                    res = new Response(HTTP_OK,"text/plain","Added Successfully");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/fetchCateg")){
            System.out.println("Fetch Categories Request Received");
            
            try{
                ResultSet rs = DBLoader.executeSQL("SELECT * FROM POS.Category");
                JSONArray jsonArray = new JSONArray(); 
                
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();    
                
                while (rs.next()) {
                JSONObject jsonObject = new JSONObject(); // JSON object for each row
                for (int i = columnCount; i >= 1; i--) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    jsonObject.put(columnName, value);
                }
                jsonArray.put(jsonObject);
            }
               
                System.out.println("Hello "+jsonArray.toString());
              res = new Response(HTTP_OK,"application/json",jsonArray.toString());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/fetchProd")){
            System.out.println("Fetch Products Request Received");
            
            try{
                ResultSet rs = DBLoader.executeSQL("SELECT * FROM POS.Products");
                JSONArray jsonArray = new JSONArray(); 
                
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();    
                
                while (rs.next()) {
                JSONObject jsonObject = new JSONObject(); // JSON object for each row
                for (int i = columnCount; i >= 1; i--) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    jsonObject.put(columnName, value);
                }
                jsonArray.put(jsonObject);
            }
               
              System.out.println("Hello "+jsonArray.toString());
              res = new Response(HTTP_OK,"application/json",jsonArray.toString());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(uri.equals("/fetchCategNmPh")){
            try{
                ResultSet rs = DBLoader.executeSQL("Select Name,Photo from POS.Category");
                
                JSONArray jsonArray = new JSONArray();
                
                // Used to get the number of column of resulset
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();    
                
                while (rs.next()) {
                    JSONObject jsonObject = new JSONObject(); // JSON object for each row
                    for (int i = columnCount; i >= 1; i--) {
                        String columnName = metaData.getColumnName(i);
                        Object value = rs.getObject(i);
                        jsonObject.put(columnName, value);
                    }
                    jsonArray.put(jsonObject);
                }  
                System.out.println("Hello "+jsonArray.toString());
                res = new Response(HTTP_OK,"application/json",jsonArray.toString());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/fetchProductNmPh")){
            String CName = parms.getProperty("CategName");
            try{
                System.out.println("I am here");
                ResultSet rs = DBLoader.executeSQL("Select Pname,Photo from POS.Products where Category=\""+CName+"\"");
                
                JSONArray jsonArray = new JSONArray();
                
//                 Used to get the number of column of resulset
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();    
                
                while(rs.next()){
                    JSONObject jsonObject = new JSONObject(); // JSON object for each row
                    for (int i = columnCount; i >= 1; i--) {
                        String columnName = metaData.getColumnName(i);
                        Object value = rs.getObject(i);
                        jsonObject.put(columnName, value);
                    }
                    jsonArray.put(jsonObject);
                }    
                System.out.println("Hello "+jsonArray.toString());
                res = new Response(HTTP_OK,"application/json",jsonArray.toString());    
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/removeCateg")){
            System.out.println("Remove Category Request Received");
            
            String name = parms.getProperty("name");
            
            try{
                ResultSet rs = DBLoader.executeSQL("SELECT * FROM POS.Category where Name=\""+name+"\"");
                
                if(rs.next()){
                    rs.deleteRow();
                    System.out.println("Row Deleted");
                    res = new Response(HTTP_OK,"text/plain","Row Deleted");
                }
                else{
                    res = new Response(HTTP_OK,"text/plain","Not Found");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/incQty")){
            System.out.println("Increase Quantity Request Received");
            
            String pname = parms.getProperty("product");
            int qty = Integer.parseInt(parms.getProperty("quantity"));
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.Products where Pname=\""+pname+"\"");
                
                if(rs.next()){
                    int orig = rs.getInt("Quantity");
                    rs.updateInt("Quantity", qty+orig);
                    rs.updateRow();
                    res = new Response(HTTP_OK,"text/plain","Quantity Incremented");
                }
                else{
                    res = new Response(HTTP_OK,"text/plain","DataBase Error");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/checkQty")){
            String pname = parms.getProperty("Pname");
            int need = Integer.parseInt(parms.getProperty(("need")));
            int qty=-1;
            try{
                ResultSet rs = DBLoader.executeSQL("Select quantity from POS.Products where Pname=\""+pname+"\"");
                
                if(rs.next()){
                    qty = rs.getInt("Quantity");
                }
                if(qty>=need){
                    res = new Response(HTTP_OK,"text/plain","available");
                }
                else{
                    res = new Response(HTTP_OK,"text/plain",qty+"");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/fetchBillProd")){
            System.out.println("Fetch Product Bill Request received");
            String Pname = parms.getProperty("Pname");
            
            try{
                ResultSet rs = DBLoader.executeSQL("Select PName,Category,Price,Photo from POS.Products where PName=\""+Pname+"\"");
                
                    // Used to get the number of column of resulset
                    JSONArray jsonArray = new JSONArray();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();    

                    while (rs.next()) {
                        System.out.println(rs.getString("PName"));
                        JSONObject jsonObject = new JSONObject(); // JSON object for each row
                        for (int i = columnCount; i >= 1; i--) {
                            String columnName = metaData.getColumnName(i);
                            Object value = rs.getObject(i);
                            jsonObject.put(columnName, value);
                        }
                        jsonArray.put(jsonObject);
                    }  
                    System.out.println("Fetching JSON Array");
                    System.out.println("Hello "+jsonArray.toString());
                    res = new Response(HTTP_OK,"application/json",jsonArray.toString());
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return res;
    }
    
    
    

    public MyServer(int portno) throws IOException {
        super(portno);
    }
    public static void main(String[] args) {
        try {
            MyServer obj = new MyServer(8000);
            Thread.sleep(1000000000);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
