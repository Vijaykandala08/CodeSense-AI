package com.spring.devpilot.services.ai;

import com.spring.devpilot.dto.CitationDto;

import java.util.List;

public record RetrievedContext (
        List<CitationDto> citations,
        String contextText){


}
