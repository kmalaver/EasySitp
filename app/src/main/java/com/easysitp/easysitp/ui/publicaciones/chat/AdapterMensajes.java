package com.easysitp.easysitp.ui.publicaciones.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.easysitp.easysitp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje>{


    private List<MensajeRecibir> listMensaje= new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c = c;
    }


    public void addMensaje(MensajeRecibir m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());

    }
    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes, parent, false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {

        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());

        Long codigoHora= listMensaje.get(position).getHora();
        Date d= new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        holder.getHora().setText(sdf.format(d));

    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}

