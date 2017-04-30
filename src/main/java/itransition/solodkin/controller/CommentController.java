package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Comment;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class CommentController {
    private CloudphotoService cloudphotoService;
    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public CommentController(CloudphotoService cloudphotoService, UserService userService, SecurityService securityService) {
        this.cloudphotoService = cloudphotoService;
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping(value = "/comment")
    public
    @ResponseBody
    ArrayList addComment(@RequestParam String photoId, @RequestParam String text) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Comment comment = new Comment();
        comment.setUserId(securityService.getUserId());
        comment.setNickname(this.userService.findOne(securityService.getUserId()).getProfile().getNickname());
        comment.setComment(text);
        photo.getComments().add(comment);
        this.cloudphotoService.save(photo);

        ArrayList<String> comments = new ArrayList<>();
        for (Comment com : photo.getComments()) {
            comments.add(com.getNickname());
            comments.add(com.getComment());
        }

        return comments;
    }
}
