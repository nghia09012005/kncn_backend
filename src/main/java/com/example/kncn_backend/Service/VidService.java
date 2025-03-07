package com.example.kncn_backend.Service;

import com.example.kncn_backend.Dto.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class VidService {
    private static String YOUTUBE_API_KEY = "AIzaSyA36x0TFt4lejSCziARQMMEsTamysbgR7Q";
    private static String url = "https://www.googleapis.com/youtube/v3/search";
    public static String videoUrl = "https://www.youtube.com/watch?v=";

    @Autowired
    private RestTemplate restTemplate;

    public String VidProcess(String query) throws IOException {


        // take an url video from YouTube api
        String Search;
        Search = url + "?part=snippet&q=" + query +  "&type=video&maxResults=1&key=" + YOUTUBE_API_KEY;
        result response = restTemplate.getForObject(Search, result.class);

        //check xem id co null khong
        if(response.items.get(0).id.getVideoId() == null){
            return "Please enter the right name of the song";
        }

        String vidYouTube = videoUrl + response.items.get(0).id.getVideoId();

        System.out.println(response.items.get(0).snippet.getTitle());

        // convert youTube video to url stream by yt-dlb
        ProcessBuilder processBuilder = new ProcessBuilder(
                "yt-dlp",
                "-g",
                vidYouTube
        );

        //processBuilder.redirectErrorStream(true); // gop error warning vao inputstream

        processBuilder.start();

        //start a process
        Process process = processBuilder.start();

        BufferedReader stdInput
                = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String streamUrl = null;

        streamUrl = stdInput.readLine() ;
        return streamUrl;
    }
}
