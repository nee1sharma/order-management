package com.sharma.nks.products.order.management.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UniqueIdGeneratorTest {

    @Test
    public void testUniqueGenerationByPrefix() {
        Stream.of("A", "BB", "CCC", "DDDD", "EEEEE", "FFFFF00","0000","0a11cDEF").forEach(prefix -> Assertions.assertThat(UniqueIdGenerator.getUniqueId(prefix)).hasSize(14));
    }

    @Test
    public void testDefaultUniqueGeneration() {
        IntStream.range(0, 100).forEach(i -> Assertions.assertThat(UniqueIdGenerator.getUniqueId()).hasSize(10));
    }

}
