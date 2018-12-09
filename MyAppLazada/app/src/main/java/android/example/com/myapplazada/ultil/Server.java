package android.example.com.myapplazada.ultil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Server {
        public static  String localhost = "192.168.56.1";  //http://appbanhang15dthj02.epizy.com/api/Sanpham.php
        public static  String Duongdansanphammoinhat = "http://"+localhost+":8080/api/Sanpham.php";


        public static  String docNoiDungJson (String Url){
                StringBuilder content  = new StringBuilder();
                try{
                        URL url = new URL(Url);
                        URLConnection urlConnection = url.openConnection();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                        String line ;
                        while ((line = bufferedReader.readLine()) != null){
                                content.append(line + "\n");
                        }
                        bufferedReader.close();
                }catch (Exception e){
                        e.printStackTrace();
                }
                return content.toString();
        }

}


