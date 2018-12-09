package android.example.com.myapplazada.activity;

import android.example.com.myapplazada.R;
import android.example.com.myapplazada.adapter.SanphamAdapter;
import android.example.com.myapplazada.model.Loaisp;
import android.example.com.myapplazada.model.Sanpham;
import android.example.com.myapplazada.ultil.CheckConnection;
import android.example.com.myapplazada.ultil.Server;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    // MyCode
    DrawerLayout drawer;
    Toolbar toolbar ;
    NavigationView navigationView;
    DrawerLayout drawerLayout ;
    ViewFlipper viewlipper;
    ArrayList<Loaisp> mangloaisp;
    RecyclerView recyclerViewManghinhchinh ;

    ArrayList<Sanpham> mangSanphams;
    SanphamAdapter sanphamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        InitView();
        InitButton();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // mycode
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionViewFripper();
            GetDuLieuMoiNhat();


           // runOnUiThread(new Runnable() {
             //   @Override
              //  public void run() {
                   // new DocJson().execute("https://khoapham.vn/download/json/vd3.php"); // đọc ngon lành
               //   new DocJson().execute("http://192.168.43.96:8080/api/Sanpham.php");
                   // new DocJson().execute("http://192.168.43.96:8080/androidwebservice/getData.php");
               // }
            //});

        }else{
            CheckConnection.ShowToast_Short(getApplicationContext(),R.string.No_Internet);
            finish();
        }


    }

    // Doc json
    class  DocJson extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            return Server.docNoiDungJson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }



    private void InitButton() {
    }

    private void InitView() {
       /* recyclerViewManghinhchinh = (RecyclerView) findViewById(R.id.recyclerviewManghinhchinh);
        viewlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        mangloaisp = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewManghinhchinh.setLayoutManager(linearLayoutManager);
        ArrayList<Sanpham> mangSanphams = new ArrayList<>();
        mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));
        mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));
        mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));

        SanphamAdapter sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangSanphams);
        recyclerViewManghinhchinh.setHasFixedSize(true);
        recyclerViewManghinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerViewManghinhchinh.setAdapter(sanphamAdapter);*/

        recyclerViewManghinhchinh = (RecyclerView) findViewById(R.id.recyclerviewManghinhchinh);
        viewlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        mangloaisp = new ArrayList<>();
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewManghinhchinh.setLayoutManager(linearLayoutManager);

        mangSanphams = new ArrayList<>();
       /* mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));
        mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));
        mangSanphams.add(new Sanpham(001, "aaa", 20000,"http://imagizer.imageshack.us/a/img924/331/ujExV6.jpg","aaaa bbb", 1));*/

        sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangSanphams);
        recyclerViewManghinhchinh.setHasFixedSize(true);
        recyclerViewManghinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerViewManghinhchinh.setAdapter(sanphamAdapter);

    }

    private void ActionBar() {

    }

    // Quảng cáo
    private void ActionViewFripper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://img.global.news.samsung.com/in/wp-content/uploads/2018/03/PR_1242x400_banner2.jpg");
        mangquangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS373ipruMbuZRyy0ltNxEQEepmip9FFhyt9-FyRtUf3w560Wqn");
        mangquangcao.add("http://www.giraffenet.com/wp-content/uploads/2015/04/GiraffenetCatCaseBanner.jpg");

        for(int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewlipper.addView(imageView);
        }
        viewlipper.setFlipInterval(5000);  /// time chay
        viewlipper.setAutoStart(true); // tu dong chay

        Animation animation_silde_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_silde_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewlipper.setInAnimation(animation_silde_in);
        viewlipper.setInAnimation(animation_silde_out);

    }

    // Lấy sản phẩm mới nhất.
    private void GetDuLieuMoiNhat() {
        RequestQueue requestQueue  = Volley.newRequestQueue(getApplicationContext());
     //   Toast.makeText(MainActivity.this, ""+ Server.Duongdansanphammoinhat, Toast.LENGTH_SHORT).show();
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansanphammoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                        int ID = 0 ;
                        String Tensanpham= "";
                        Integer Giasanpham = 0 ;
                        String Hinhanhsanpham = "";
                        String Motasanpham = "" ;
                        int IDSanpham = 0;

                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID  = jsonObject.getInt("id");
                            Tensanpham  = jsonObject.getString("tensp");
                            Giasanpham  = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motaso");
                            IDSanpham = jsonObject.getInt("idsanpham");

                            mangSanphams.add(new Sanpham(ID,Tensanpham, Giasanpham,Hinhanhsanpham,Motasanpham, IDSanpham));

                          //  Toast.makeText(MainActivity.this,response +"", Toast.LENGTH_LONG).show();

                           sanphamAdapter.notifyDataSetChanged(); // cp nhật cho layout

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Có lỗi load dữ li", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {  //R.id.nav_camera
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
