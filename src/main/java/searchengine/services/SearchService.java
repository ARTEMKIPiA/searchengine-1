package searchengine.services;
import searchengine.config.Search;
import searchengine.dto.statistics.SearchDto;

import java.util.List;

public interface SearchService {
    List<SearchDto> allSiteSearch(Search searchCfg);
    List<SearchDto> siteSearch(Search searchCfg);
}
