package searchengine.dto.statistics.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IndexResponse {
    private boolean result;
    private String error;
    public IndexResponse(boolean result){
        this.result=result;
    }
}