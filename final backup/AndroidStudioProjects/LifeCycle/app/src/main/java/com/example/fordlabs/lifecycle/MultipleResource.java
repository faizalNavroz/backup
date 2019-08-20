package com.example.fordlabs.lifecycle;

import com.google.gson.annotations.SerializedName;

public class MultipleResource {

        @SerializedName("page")
        public Integer page;
        @SerializedName("per_page")
        public Integer perPage;
        @SerializedName("total")
        public Integer total;
        @SerializedName("total_pages")
        public Integer totalPages;

        MultipleResource() {
                total =  0;
        }

}
