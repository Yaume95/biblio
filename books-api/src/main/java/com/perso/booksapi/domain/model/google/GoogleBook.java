package com.perso.booksapi.domain.model.google;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoogleBook {
    private VolumeInfo volumeInfo = null;
    private String id = null;
}
