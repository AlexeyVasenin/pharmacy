package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleDrug<T> {
    private final T result;
}
