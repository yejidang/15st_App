package com.example.a11st;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    ArrayList<Movie> items = new ArrayList<Movie>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.movie_item,viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie item = items.get(position);
        viewHolder.setItem(item);

    }

    @Override
    public int getItemCount() { return items.size(); }
    public void addItem (Movie item){ items.add(item); }
    public void setItems (ArrayList < Movie > items) { this.items = items; }
    public Movie getItem ( int position){ return items.get(position); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView moviewName;
        TextView peopleCount;
        TextView openMovie;
        TextView movieRank;
        TextView tdpeopleCount;


        public ViewHolder(View itemView) {
            super(itemView);
            moviewName = itemView.findViewById(R.id.movieName);
            peopleCount = itemView.findViewById(R.id.peopleCount);
            openMovie = itemView.findViewById(R.id.openMovie);
            movieRank = itemView.findViewById(R.id.movieRank);
            tdpeopleCount = itemView.findViewById(R.id.tdpeopleCount);
        }

        public void setItem(Movie item) {
            moviewName.setText(item.movieNm);
            peopleCount.setText("누적관객수 : " + item.audiAcc + "명");
            openMovie.setText("개봉일 : " + item.openDt);
            movieRank.setText(item.rank + "위");
            tdpeopleCount.setText("해당일의 관객수 : " + item.audiCnt + "명");
        }
    }
}