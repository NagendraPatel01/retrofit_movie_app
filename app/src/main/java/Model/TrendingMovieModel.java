package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingMovieModel {


    public class Result {
        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", originalTitle='" + originalTitle + '\'' +
                    ", posterPath='" + posterPath + '\'' +
                    '}';
        }

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;

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

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public Result withOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
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

    }

    @Override
    public String toString() {
        return "TrendingMovieModel{" +
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

        public TrendingMovieModel withResults(List<Result> results) {
            this.results = results;
            return this;
        }

    }

