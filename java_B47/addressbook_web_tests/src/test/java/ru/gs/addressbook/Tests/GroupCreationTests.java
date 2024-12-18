package ru.gs.addressbook.Tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.gs.addressbook.common.CommonFunctions;
import ru.gs.addressbook.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of(" ", "group name")) {
//            for (var header : List.of(" ", "group header")) {
//                for (var footer : List.of(" ", "group footer")) {
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }
        var json = "";
        try (var reader = new FileReader("groups.json");
            var breader = new BufferedReader(reader)) {
            var line = breader.readLine();
            while (line != null) {
                json = json + line;
                line  = breader.readLine();
            }
        }
 //       var mapper = new XmlMapper();
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {});
        result.addAll(value);
        return result;
    }

    public static Stream<GroupData> randomGroup() throws IOException {
        Supplier<GroupData> randomGroup = () -> new GroupData()
            .withName(CommonFunctions.randomString(10))
            .withHeader(CommonFunctions.randomString(20))
            .withFooter(CommonFunctions.randomString(30));
        return Stream.generate(randomGroup).limit(1);
    }

//    public static List<GroupData> singleRandomGroup() throws IOException {
//        return List.of(new GroupData()
//                .withName(CommonFunctions.randomString(10))
//                .withHeader(CommonFunctions.randomString(20))
//                .withFooter(CommonFunctions.randomString(30)));
//    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateGroupFromFile(GroupData group) throws SQLException {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.jdbc().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.Id()), Integer.parseInt(o2.Id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() - 1).Id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }


//    @ParameterizedTest
//    @MethodSource("singleRandomGroup")
//    public void canCreateSingleGroup(GroupData group) throws SQLException {
//        var oldGroups = app.jdbc().getGroupList();
//       app.groups().createGroup(group);
//        var newGroups = app.jdbc().getGroupList();
//        Comparator<GroupData> compareById = (o1, o2) -> {
//            return Integer.compare(Integer.parseInt(o1.Id()), Integer.parseInt(o2.Id()));
//        };
//        newGroups.sort(compareById);
//        var maxId = newGroups.get(newGroups.size() - 1).Id();
//        var expectedList = new ArrayList<>(oldGroups);
//        expectedList.add(group.withId(maxId));
//        expectedList.sort(compareById);
//        Assertions.assertEquals(newGroups, expectedList);
//    }

    @ParameterizedTest
    @MethodSource("randomGroup")
    public void canCreateSingleGroup(GroupData group) throws SQLException {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.jdbc().getGroupList();

        var extraGroups = newGroups.stream().filter(g -> ! oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).Id();

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newId));
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }

    @ParameterizedTest
    @MethodSource("randomGroup")
    public void canCreateSingleGroupHbm(GroupData group) throws SQLException {
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.Id()), Integer.parseInt(o2.Id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() - 1).Id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name ' ", " ", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
                Assertions.assertEquals(newGroups, oldGroups);
    }
}
