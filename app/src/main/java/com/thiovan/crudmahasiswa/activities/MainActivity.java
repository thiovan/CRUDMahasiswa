package com.thiovan.crudmahasiswa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.thiovan.crudmahasiswa.R;
import com.thiovan.crudmahasiswa.adapters.MahasiswaAdapter;
import com.thiovan.crudmahasiswa.models.Mahasiswa;
import com.thiovan.crudmahasiswa.models.MahasiswaPOJO;
import com.thiovan.crudmahasiswa.models.MahasiswaResult;
import com.thiovan.crudmahasiswa.network.APIClient;
import com.thiovan.crudmahasiswa.network.MahasiswaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView lvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUser = (ListView) findViewById(R.id.lv_user);

//        int SDK_INT = Build.VERSION.SDK_INT;
//        if (SDK_INT > 8) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                    .permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//
//            try {
//                URL url = new URL("https://picsum.photos/200/300/?random");
//                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                ivCobaGambar.setImageBitmap(bmp);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        //String[] user = new String[]{"Prayitno", "Jono", "Joko", "Joni"};
//        ArrayList<String> user = new ArrayList<>();
//        user.add("User 1");
//        user.add("User 2");
//        user.add("User 3");
//        user.add("User 4");
        //ArrayAdapter<String> userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, user);



        //POJO
//        MahasiswaPOJO mahasiswa1 = new MahasiswaPOJO();
//        mahasiswa1.setNama("Thio Van Agusti");
//        mahasiswa1.setNim("3.34.15.0.23");
//        mahasiswa1.setEmail("thiovan99@gmail.com");
//        mahasiswa1.setFoto("https://picsum.photos/200/300/?image=1");
//
//        MahasiswaPOJO mahasiswa2 = new MahasiswaPOJO(
//                "Tatak Galih Prasetyo",
//                "3.34.15.0.22",
//                "tatakgalih@gmail.com",
//                "https://picsum.photos/200/300/?image=2"
//        );
//
//        MahasiswaPOJO mahasiswa3 = new MahasiswaPOJO(
//                "Rizal Dwi Prasetya",
//                "3.34.15.0.20",
//                "rizal@gmail.com",
//                "https://picsum.photos/200/300/?image=3"
//        );
//
//        ArrayList<MahasiswaPOJO> user = new ArrayList<>();
//        user.add(mahasiswa1);
//        user.add(mahasiswa2);
//        user.add(mahasiswa3);
//
//        MahasiswaAdapter userAdapter = new MahasiswaAdapter(this, 0, user);
//        lvUser.setAdapter(userAdapter);

        //Sumber Data Dari API
        MahasiswaService mService = APIClient.getClient().create(MahasiswaService.class);
        Call<MahasiswaResult> mahasiswas = mService.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                List<Mahasiswa> user = response.body().getMahasiswas();
                MahasiswaAdapter userAdapter = new MahasiswaAdapter(getApplicationContext(), 0, user);
                lvUser.setAdapter(userAdapter);
                Toast.makeText(MainActivity.this, "Jumlah data: " + response.body().getMahasiswas().size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Terhubung", Toast.LENGTH_SHORT).show();
            }
        });

        //asdads


    }
}
