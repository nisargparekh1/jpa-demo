package io.pragra.learning.pragravisit.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PragraError {
    private String errorCode;
    private String description;
    private Instant reportDateTime;
}
