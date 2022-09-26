package frontend.helpers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ObservableListHelper {
    public static <T> ObservableList<T> entitiesToObservableListDistinct(List<T> entities) {
        var mapped = entities.stream().distinct();
        return mapped.collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
}
