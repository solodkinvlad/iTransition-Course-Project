package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Comment;
import itransition.solodkin.security.SecurityServiceImpl;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eabil on 29.04.2017.
 */
@Controller
public class CommentController {
    private CloudphotoService cloudphotoService;
    private UserService userService;

    @Autowired
    public CommentController(CloudphotoService cloudphotoService, UserService userService) {
        this.cloudphotoService = cloudphotoService;
        this.userService = userService;
    }

    @GetMapping(value = "/comment")
    public
    @ResponseBody
    JSONArray addComment(@RequestParam String photoId, @RequestParam String text) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Comment comment = new Comment();
        comment.setUserId(SecurityServiceImpl.getUserId());
        comment.setNickname(this.userService.findOne(SecurityServiceImpl.getUserId()).getProfile().getNickname());
        comment.setComment(text);
        photo.getComments().add(comment);
        this.cloudphotoService.save(photo);

        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(Comment com : photo.getComments()) {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("nickname", com.getNickname());
            formDetailsJson.put("comment", com.getComment());
            jsonArray.add(formDetailsJson);
        }
        responseDetailsJson.put("forms", jsonArray);

        return jsonArray;
    }
}
