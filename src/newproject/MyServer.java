
package newproject;

import com.mashape.unirest.http.Unirest;
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.*;

public class MyServer extends JHTTPServer{

    static String IP = "";
    
    public static void setIP(){
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
    }
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;
        
        if(uri.equals("/adminLogin")){
            System.out.println("Request Received");
            String username = parms.getProperty("user");
            String password = parms.getProperty(("pass"));
            
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.users where Username=\""+username+"\" and Password=\""+password+"\"");
                
                if(rs.next()){
                    String gmail = rs.getString("Gmail");
                    res = new Response(HTTP_OK,"text/plain",gmail);
                }
                else{
                    res = new Response(HTTP_OK,"text/plain","Login Failed");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/newUser")){
            System.out.println("Request Received");
            String user = parms.getProperty("user");
            String pass = parms.getProperty(("pass"));
            String gmail = parms.getProperty(("gmail"));
            
            try{
                ResultSet rs = DBLoader.executeSQL("Select * from POS.users where username = \'" + user + "\'");       
            

                if (rs.next()) {
                    res = new Response(HTTP_OK,"text/plain","Already Exists");
                }
                 else {
                        rs.moveToInsertRow();
                        rs.updateString("username", user);
                        rs.updateString("password", pass);
                        rs.updateString("gmail", gmail);
                        rs.insertRow();
                        res = new Response(HTTP_OK,"text/plain","Login Success");
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
        
        if(uri.equals("/addBillDetails")){
            String Cname, CPhone, p_mode;
            String[] Products;
            String ProductsStr,qtyStr,ppriceStr,AdminGmail;
            long gtotal;
            int[] qty = new int[100], pprice = new int[100];
            String[] qtyS, ppriceS;
            int length;
            ArrayList<Integer> al;
            
            // <----------- Fetching Bill Details from Users ------------->
            CPhone = parms.getProperty("CPhone");
            p_mode = parms.getProperty("p_mode");
            AdminGmail = parms.getProperty("AdminGmail");
            ProductsStr = parms.getProperty("ProductsStr");
            gtotal = Integer.parseInt(parms.getProperty("gtotal"));
            qtyStr = parms.getProperty("qtyStr");
            ppriceStr = parms.getProperty("ppriceStr");
            length = Integer.parseInt(parms.getProperty("length"));
                
            Products = ProductsStr.split(":");
            qtyS = qtyStr.split(":");
            ppriceS = ppriceStr.split(":");
                
            for(int i=0;i<qtyS.length;i++){
                qty[i] = Integer.parseInt(qtyS[i]);
                pprice[i] = Integer.parseInt(ppriceS[i]);
            }
            
            // Fetching Current Date and Time
            LocalDateTime now = LocalDateTime.now();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            
            
                int BillId=0;
                // <---------------------------------------------------------->
            try{
                // <--------------  Storing data in database ----------------->
                ResultSet rs = DBLoader.executeSQL("Select * from POS.Bills");
                
                rs.moveToInsertRow();
                rs.updateString("Date_TIme", formattedDateTime);
                rs.updateLong("GTotal", gtotal);
                rs.updateString("AdminEmail", AdminGmail);
                rs.updateString("PhoneNo", CPhone);
                rs.updateString("Payment_Type", p_mode);
                rs.insertRow();
                System.out.println("Insertion Done");
                
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            try{
                // <--------------  Storing data in database ----------------->
                ResultSet rs = DBLoader.executeSQL("Select * from POS.Bills where Date_time='"+formattedDateTime+"'");
                
                if(rs.next()){
                    BillId = rs.getInt("BillID");
                    System.out.println(BillId);
                    
                    try{
                        for(int i=0;i<Products.length;i++){
                            ResultSet rs2 = DBLoader.executeSQL("Select * from POS.BillDetails");
                            
                            rs2.moveToInsertRow();
                        
                            rs2.updateInt("BillID", BillId);
                            rs2.updateString("PName", Products[i]);
                            rs2.updateInt("PricePerUnit", pprice[i]);
                            rs2.updateInt("Quantity", qty[i]);
                            rs2.insertRow();
                        }
                        
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                for(int i=0;i<Products.length;i++){
                    ResultSet rs = DBLoader.executeSQL("Select * from POS.Products where PName='"+Products[i]+"'");
                    
                    if(rs.next()){
                        int orig = rs.getInt("Quantity");
                        rs.updateInt("Quantity", orig-qty[i]);
                        rs.updateRow();
                        res = new Response(HTTP_OK,"text/plain","Quantity Reduced and Product Data Added");
                    }
                    else{
                        res = new Response(HTTP_OK,"text/plain","DataBase Error");
                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(uri.equals("/fetchBills")){
            System.out.println("Fetch Bills Request Received");
            
            try{
                ResultSet rs = DBLoader.executeSQL("SELECT * FROM POS.Bills");
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
        
        if(uri.equals("/fetchBillDetails")){
            System.out.println("Fetch Bill Details Request Received");
            String BillID = parms.getProperty("BillID");
            
            try{
                ResultSet rs = DBLoader.executeSQL("SELECT * FROM POS.BillDetails where BillID="+BillID);
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
        
        return res;
    }
    
    
    

    public MyServer(int portno) throws IOException {
        super(portno);
    }
    public static void main(String[] args) {
        try {
            setIP();
            MyServer obj = new MyServer(8000);
            System.out.println("Server IP: "+IP);
            Thread.sleep(1000000000);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
