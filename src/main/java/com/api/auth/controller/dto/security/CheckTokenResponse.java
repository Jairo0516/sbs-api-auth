package com.api.auth.controller.dto.security;

import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CheckTokenResponse {
    private boolean valid;
}
