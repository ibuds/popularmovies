package com.example.popularmovies.POJO;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.popularmovies.MainActivityFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ian on 5/1/2016.
 */
public class Movie implements Parcelable {

    private int id;
    private String originalTitle;
    private String posterPath;
    private String backdropPath;
    private String overview;
    private int voteAverage;
    private String releaseDate;

    public Movie() {

    }

    public Movie(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.originalTitle = movie.getString("original_title");
        this.posterPath = movie.getString("poster_path");
        this.backdropPath = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.voteAverage = movie.getInt("vote_average");
        this.releaseDate = movie.getString("release_date");
    }

    public Movie(Cursor cursor) {
        this.id = cursor.getInt(MainActivityFragment.COL_MOVIE_ID);
        this.originalTitle = cursor.getString(MainActivityFragment.COL_ORIGINAL_TITLE);
        this.posterPath = cursor.getString(MainActivityFragment.COL_POSTER_PATH);
        this.backdropPath = cursor.getString(MainActivityFragment.COL_BACKDROP_PATH);
        this.overview = cursor.getString(MainActivityFragment.COL_OVERVIEW);
        this.voteAverage = cursor.getInt(MainActivityFragment.COL_VOTE_AVERAGE);
        this.releaseDate = cursor.getString(MainActivityFragment.COL_RELEASE_DATE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public static Creator<Movie> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(originalTitle);
        dest.writeString(posterPath);
        dest.writeString(backdropPath);
        dest.writeString(overview);
        dest.writeInt(voteAverage);
        dest.writeString(releaseDate);
    }

    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private Movie(Parcel in) {
        id = in.readInt();
        originalTitle = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        overview = in.readString();
        voteAverage = in.readInt();
        releaseDate = in.readString();
    }
}