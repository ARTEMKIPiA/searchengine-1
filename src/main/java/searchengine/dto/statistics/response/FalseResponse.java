package searchengine.dto.statistics.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FalseResponse {
    private boolean result;
    private String error;
}

