package com.YoutubeTools.Controller;

import com.YoutubeTools.Model.VideoDetails;
import com.YoutubeTools.Services.ThumbnailService;
import com.YoutubeTools.Services.YouTubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class YouTubeVideoController {

    private final YouTubeService youTubeService;
    private final ThumbnailService service;

    @GetMapping("/youtube/video-details")
    public String showVideoForm() {
        return "video-details";
    }

    @PostMapping("/youtube/video-detalis")
    public String fetchVideoDetails(@RequestParam String videoUrlOrId, Model model) {
        String videoId = service.extraVideoId(videoUrlOrId);

        if (videoId == null) {
            model.addAttribute("error", "Invalid video id");
            return "video-details";
        }
        VideoDetails details = youTubeService.getVideoDetails(videoId);
        if (details == null) {
            model.addAttribute("error", "Video not found");
            return "video-details";
        } else {
            model.addAttribute("videoDetails", details);
        }
         model.addAttribute("videoUrlOrId", videoUrlOrId);
            return "video-details";
        }
    }





