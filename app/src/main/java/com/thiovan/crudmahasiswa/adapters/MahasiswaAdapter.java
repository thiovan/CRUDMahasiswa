package com.thiovan.crudmahasiswa.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thiovan.crudmahasiswa.R;
import com.thiovan.crudmahasiswa.models.Mahasiswa;
import com.thiovan.crudmahasiswa.models.MahasiswaPOJO;

import java.util.List;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {

    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_mahasiswa, parent, false);
        }

        Mahasiswa user = getItem(position);

        ImageView ivUser = convertView.findViewById(R.id.iv_foto);
        Picasso.get().load(user.getFoto()).into(ivUser);
        TextView tvNama = convertView.findViewById(R.id.tv_nama);
        TextView tvNim = convertView.findViewById(R.id.tv_nim);
        TextView tvEmail = convertView.findViewById(R.id.tv_email);
        tvNama.setText(user.getNama());
        tvNim.setText(user.getNim());
        tvEmail.setText(user.getEmail());
        return convertView;
    }
}
