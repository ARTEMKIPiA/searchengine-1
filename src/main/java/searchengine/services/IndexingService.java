package searchengine.services;

import lombok.SneakyThrows;
import searchengine.dto.statistics.response.IndexResponse;

public interface IndexingService {
    @SneakyThrows
    IndexResponse startIndexing();

    @SneakyThrows
    IndexResponse stopIndexing();

    IndexResponse indexPage(String url);
}
