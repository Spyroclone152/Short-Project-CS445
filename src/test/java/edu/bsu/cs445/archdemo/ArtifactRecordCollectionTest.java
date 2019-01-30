package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtifactRecordCollectionTest {

    @Test
    void testCountRecordsByTitleQuery_emptyString_zero() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.createEmpty();
        int count = collection.countRecordsByTitleQuery("");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testCountRecordsByTitleQuery_oneItemMatch_one() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int count = collection.countRecordsByTitleQuery("Foo");
        Assertions.assertEquals(1, count);
    }

    @Test
    void testCountRecordsByTitleQuery_noItemsMatchInNonemptyCollection_zero() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int count = collection.countRecordsByTitleQuery("Bar");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testCountRecordsByTitleQuery_twoItemsMatch_two() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle("Foo"),
                ArtifactRecord.withTitle("Fool"));
        int count = collection.countRecordsByTitleQuery("Foo");
        Assertions.assertEquals(2, count);
    }
}
