package com.project.yjshop.web.api;

import com.project.yjshop.domain.board.Board;
import com.project.yjshop.security.auth.PrincipalDetails;
import com.project.yjshop.service.board.BoardService;
import com.project.yjshop.web.payload.request.board.BoardProductRequest;
import com.project.yjshop.web.payload.response.board.BoardProductResponse;
import com.project.yjshop.web.payload.response.board.CategoryListResopnse;
import com.project.yjshop.web.payload.response.board.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/product/")
    public BoardProductResponse postProduct(@ModelAttribute @Valid BoardProductRequest product,
                                            BindingResult bindingResult,
                                            @AuthenticationPrincipal PrincipalDetails principalDetails) throws IOException {
        return boardService.posting(product, bindingResult, principalDetails);
    }

    @DeleteMapping("/product/{boardId}")
    public BoardProductResponse delProduct(@PathVariable Integer boardId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return boardService.deleting(boardId, principalDetails);
    }

    @GetMapping("/product/")
    public List<Board> allProduct() {
        return boardService.findAll();
    }

    @GetMapping("/product/category")
    public CategoryListResopnse categoryList(@RequestBody Integer categoryId) {
        return boardService.categoryList(categoryId);
    }

    @GetMapping("/category/")
    public CategoryResponse sortedCategoryList() {
        return boardService.sortedCategoryList();
    }
}
