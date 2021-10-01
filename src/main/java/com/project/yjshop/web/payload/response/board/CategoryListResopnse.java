package com.project.yjshop.web.payload.response.board;

import lombok.*;

import java.util.List;

@Builder
@Data
public class CategoryListResopnse {

    private List<CategoryListResopnse.product> productList;

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class product {
        private String title;
        private String titleImage;
        private Integer price;
        private Integer count;
    }
}
