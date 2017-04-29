package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Comment;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    JSONArray addComment(@RequestParam String photoId, @RequestParam String text) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Comment comment = new Comment();
        comment.setUserId(securityService.getUserId());
        comment.setNickname(this.userService.findOne(securityService.getUserId()).getProfile().getNickname());
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
