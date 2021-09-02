package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovieModel {

    @Override
    public String toString() {
        return "PopularMovieModel{" +
                "results=" + results +
                '}';
    }

    @SerializedName("results")
        @Expose
        private List<Result> results = null;

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public PopularMovieModel withResults(List<Result> results) {
            this.results = results;
            return this;
        }



    public class Result {


        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", posterPath='" + posterPath + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("title")
        @Expose
        private String title;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Result withId(Integer id) {
            this.id = id;
            return this;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public Result withPosterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Result withTitle(String title) {
            this.title = title;
            return this;
        }

    }
}
