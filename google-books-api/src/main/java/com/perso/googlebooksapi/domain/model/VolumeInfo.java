package com.perso.googlebooksapi.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
public class VolumeInfo {
    String title = null;
    List<String> authors = new ArrayList<>();
    String description = null;
    ImageLinks imageLinks = new ImageLinks();
    Number pageCount = null;
}

