package com.YoutubeTools.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDetails {
        private String id;
        private String description;
        private String channelTitle;
        private String  title;
        private List<String> tags;
        private String thumbnail;
        private String publishedAt;
}

