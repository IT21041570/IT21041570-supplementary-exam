package com.example.it21041570supplementaryassessment.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it21041570supplementaryassessment.Dashboard;
import com.example.it21041570supplementaryassessment.Database.DatabaseHelper;
import com.example.it21041570supplementaryassessment.EditNotes;
import com.example.it21041570supplementaryassessment.Models.Model;
import com.example.it21041570supplementaryassessment.Notes;
import com.example.it21041570supplementaryassessment.R;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.Holder>{

    private Context context;
    private ArrayList<Model> arrayList;

    //database object
    DatabaseHelper databaseHelper;

    public NotesAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

        //inisialize dbheler
        databaseHelper = new DatabaseHelper(context);

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_notes_details, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") final int position) {

        Model model = arrayList.get(position);
        //get for view
        final int id = model.getId();
        final String note = model.getNote();
        final String date = model.getDate();
        final String time = model.getTime();

        //set views
        holder.Note.setText(note);
        holder.Date.setText(date);
        holder.Time.setText(time);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDetails(
                        ""+position,
                        ""+id,
                        ""+note,
                        ""+date,
                        ""+time
                );
            }
        });

        //when long press on item, show and alert dialog for delete
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                DeleteItem(
                        ""+id
                );

                return false;
            }
        });

    }


    private void DeleteItem(final String id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Are you want to delete ?");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.delete);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                databaseHelper.deleteInfo(id);
                Intent i = new Intent(context,Notes.class);
                context.startActivity(i);
                Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        builder.create().show();
    }

    private void UpdateDetails(String position, String id, String note, String date, String time) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update");
        builder.setMessage("Are you want update ?");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.edit);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(context, EditNotes.class );
                intent.putExtra("ID", id);
                intent.putExtra("note", note);
                intent.putExtra("date", date);
                intent.putExtra("time", time);
                intent.putExtra("EditMode", true);

                context.startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends  RecyclerView.ViewHolder{

        TextView Note, Date, Time;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            Note = itemView.findViewById(R.id.note);
            Date = itemView.findViewById(R.id.date);
            Time = itemView.findViewById(R.id.time);
            imageView=(itemView).findViewById(R.id.imageView);
        }
    }
}
