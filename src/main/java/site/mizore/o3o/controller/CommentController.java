package site.mizore.o3o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.mizore.o3o.bean.Comment;
import site.mizore.o3o.common.CommonResult;
import site.mizore.o3o.service.CommentService;

import java.util.List;

@CrossOrigin
@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public CommonResult<Integer> add(@RequestBody Comment comment) {
        int result= commentService.add(comment);
        if(result==1) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping("/tree/{pageId}")
    public CommonResult<List<Comment>> tree(@PathVariable("pageId") String pageId) {
        return CommonResult.success(commentService.getCommentTree(pageId));
    }


}
