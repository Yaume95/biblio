package com.perso.googlebooksapi.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoogleBook {
    VolumeInfo volumeInfo = null;
    String id = null;
}
