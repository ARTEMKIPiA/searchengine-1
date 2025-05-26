
package searchengine.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.config.Search;
import searchengine.dto.statistics.response.FalseResponse;
import searchengine.dto.statistics.response.IndexResponse;
import searchengine.dto.statistics.response.SearchResponse;
import searchengine.dto.statistics.SearchDto;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.IndexingService;
import searchengine.services.SearchService;
import searchengine.services.StatisticsService;
import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final StatisticsService statisticsService;
    private final IndexingService indexingService;
    private final SearchService searchService;
    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }
    @GetMapping("/startIndexing")
    public ResponseEntity<IndexResponse> startIndexing() {
        IndexResponse indexResponse = indexingService.startIndexing();
        return ResponseEntity.ok(indexResponse);
    }
    @GetMapping("/stopIndexing")
    public ResponseEntity<IndexResponse> stopIndexing() {
        IndexResponse indexResponse = indexingService.stopIndexing();
        return ResponseEntity.ok(indexResponse);
    }
    @PostMapping("/indexPage")
    public ResponseEntity<IndexResponse> indexPage(@RequestParam("url") String url) {
        IndexResponse indexResponse = indexingService.indexPage(url);
        return ResponseEntity.ok(indexResponse);
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(Search site) {
        List<SearchDto> listSearchDto = site.getSite() == null ?
                searchService.allSiteSearch(site) :
                searchService.siteSearch(site);
        return ResponseEntity.ok(listSearchDto.isEmpty() ?
                new FalseResponse(false, "Поисковый запрос не найден или введен не верно") :
                new SearchResponse(true,listSearchDto.size(),listSearchDto));
    }
}