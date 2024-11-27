package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtistPage(Model model) {
        List<Artist> listedArtists = artistService.listArtists();

        model.addAttribute("listedArtists", listedArtists);

        return "artistList";
    }

    @PostMapping
    public String postArtistPage(
            @RequestParam(required = false, defaultValue = "no trackId") String trackId,
            Model model
    ) {
        List<Artist> listedArtists = artistService.listArtists();

        model.addAttribute("trackId", trackId);
        model.addAttribute("listedArtists", listedArtists);

        return "artistList";
    }
}