package com.example.registro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo,nombre,apellido,cell,direccion,nota;
        ImageView imgLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo=(TextView) itemView.findViewById(R.id.tvCodigo);
            nombre=(TextView) itemView.findViewById(R.id.tvNombre);
            apellido=(TextView) itemView.findViewById(R.id.tvApellido);
            cell=(TextView) itemView.findViewById(R.id.tvCell);
            direccion=(TextView) itemView.findViewById(R.id.tvDireccion);
            nota=(TextView) itemView.findViewById(R.id.tvNota);

            imgLogo=(ImageView) itemView.findViewById(R.id.imgLogo);
        }
    }

    public List<ModeloDatos> RegistroLista;

    public RecyclerViewAdaptador(List<ModeloDatos> registroLista) {
        RegistroLista = registroLista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigo.setText(RegistroLista.get(position).getCodigo());
        holder.nombre.setText(RegistroLista.get(position).getNombre());
        holder.apellido.setText(RegistroLista.get(position).getApellido());
        holder.cell.setText(RegistroLista.get(position).getNumcell());
        holder.direccion.setText(RegistroLista.get(position).getDireccion());
        holder.nota.setText(RegistroLista.get(position).getNota());
    }


    @Override
    public int getItemCount() {
        return RegistroLista.size();
    }
}
