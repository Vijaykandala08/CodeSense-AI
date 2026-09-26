package com.spring.devpilot.dto;

public record CitationDto(
        String filePath,
        Integer startLine,
        Integer endLine,
        String language) {
}
