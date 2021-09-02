package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingmovietrailorModel {

    @Override
    public String toString() {
        return "TrendingmovietrailorModel{" +
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

        public TrendingmovietrailorModel withResults(List<Result> results) {
            this.results = results;
            return this;
        }




    public class Result {

        @Override
        public String toString() {
            return "Result{" +
                    "key='" + key + '\'' +
                    '}';
        }

        @SerializedName("key")
        @Expose
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Result withKey(String key) {
            this.key = key;
            return this;
        }

    }


}
